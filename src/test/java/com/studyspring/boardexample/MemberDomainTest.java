package com.studyspring.boardexample;

import com.studyspring.boardexample.domain.Member;
import com.studyspring.boardexample.domain.UserRole;
import com.studyspring.boardexample.repository.MemberRepository;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberDomainTest {


    @Autowired
    private MemberRepository memberRepository;

    @After("")
    public void cleanup() {
        /*
         * 이후 테스트 코드에 영향을 끼치지 않기 위해
         * 테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         */
        memberRepository.deleteAll();
    }

    @Test
    public void userInsert() {
        // given
        memberRepository.save(
                Member.builder()
                        .username("test")
                        .password("1234")
                        .role(UserRole.USER)
                        .build()
        );

        // when
        List<Member> userList = memberRepository.findAll();

        // then
        Member member = userList.get(0);
        assertThat(member.getUsername(), is("test"));
        assertThat(member.getPassword(), is("1234"));
        assertThat(member.getRole(), is(UserRole.USER));
    }
}