package com.studyspring.boardexample.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String contents;

    @JoinColumn(name = "writer_id")
    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    private Member writer;

    @JoinColumn(name = "category_id")
    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    private Category category;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    private boolean deleted = false;

}
