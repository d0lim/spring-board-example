package com.studyspring.boardexample.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scraps")
@RequiredArgsConstructor
public class Scrap {
    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "scrap_member_id")
    @ManyToOne
    private Member scrapMember;

    @JoinColumn(name = "scrap_article_id")
    @ManyToOne
    private Article scrapArticle;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    private boolean deleted = false;
}
