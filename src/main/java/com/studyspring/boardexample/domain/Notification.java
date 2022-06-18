package com.studyspring.boardexample.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "from_member_id")
    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    private Member fromMember;

    @JoinColumn(name = "to_member_id")
    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    private Member toMember;

    @Column(name = "notification_target_type")
    @Enumerated(EnumType.STRING)
    private NotificationTargetType notificationTargetType;

    @JoinColumn(name = "target_article_id")
    @ManyToOne(targetEntity = Article.class, fetch = FetchType.LAZY)
    private Article targetArticle;

    @JoinColumn(name = "target_comment_id")
    @ManyToOne(targetEntity = Comment.class, fetch = FetchType.LAZY)
    private Comment targetComment;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    private boolean deleted = false;
}
