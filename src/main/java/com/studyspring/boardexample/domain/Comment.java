package com.studyspring.boardexample.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@RequiredArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String contents;

    @JoinColumn(name = "writer_id")
    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    private Member writer;

    @JoinColumn(name = "article_id")
    @ManyToOne(targetEntity = Article.class, fetch = FetchType.LAZY)
    private Article article;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    private boolean deleted = false;
}
