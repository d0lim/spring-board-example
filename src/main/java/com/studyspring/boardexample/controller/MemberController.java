package com.studyspring.boardexample.controller;

import com.studyspring.boardexample.domain.Member;
import com.studyspring.boardexample.dto.MemberFormDto;
import com.studyspring.boardexample.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberServiceImpl memberService;

    @PostMapping("")
    public ResponseEntity<?> insertMember(@Valid @RequestBody MemberFormDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Member savedMember = memberService.saveOrUpdateMember(dto.toEntity());

        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }
}
