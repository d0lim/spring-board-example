package com.studyspring.boardexample.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "members")
@RequiredArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    private boolean deleted = false;
}
