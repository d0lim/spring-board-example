package com.studyspring.boardexample.service;

import com.studyspring.boardexample.domain.Member;
import com.studyspring.boardexample.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> member = this.memberRepository.findByUsername(username);

        if (member.isPresent()) {
            return User.builder()
                    .username(member.get().getUsername())
                    .password(member.get().getPassword())
                    .roles(member.get().getRole().getKey())
                    .build();
        } else {
            throw new UsernameNotFoundException(username + " 정보를 찾을 수 없습니다.");
        }
    }

    @Override
    public Member saveOrUpdateMember(Member member) {
        member.encodePassword(this.passwordEncoder);

        return this.memberRepository.save(member);
    }

}
