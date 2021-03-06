package com.studyspring.boardexample.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scraps")
@NoArgsConstructor
@AllArgsConstructor
public class Scrap {
    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "scrap_member_id")
    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    private Member scrapMember;

    @JoinColumn(name = "scrap_article_id")
    @ManyToOne(targetEntity = Article.class, fetch = FetchType.LAZY)
    private Article scrapArticle;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    private boolean deleted = false;
}
