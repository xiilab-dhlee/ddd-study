package com.ide.collaboration.command.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "code_review")
public class CodeReview {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "file_path")
    private String filePath;
    
    @Column(name = "author_id")
    private String authorId;
    
    @Column(name = "reviewer_id")
    private String reviewerId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReviewStatus status;
    
    @ElementCollection
    @CollectionTable(name = "review_comments", 
                    joinColumns = @JoinColumn(name = "review_id"))
    private List<ReviewComment> comments;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    protected CodeReview() {
    }

    public CodeReview(String title, String filePath, String authorId, String reviewerId) {
        this.title = title;
        this.filePath = filePath;
        this.authorId = authorId;
        this.reviewerId = reviewerId;
        this.status = ReviewStatus.PENDING;
        this.comments = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }

    public void addComment(ReviewComment comment) {
        this.comments.add(comment);
    }

    public void approve() {
        this.status = ReviewStatus.APPROVED;
        this.completedAt = LocalDateTime.now();
    }

    public void requestChanges() {
        this.status = ReviewStatus.CHANGES_REQUESTED;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public ReviewStatus getStatus() {
        return status;
    }

    public List<ReviewComment> getComments() {
        return comments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public enum ReviewStatus {
        PENDING, IN_PROGRESS, APPROVED, CHANGES_REQUESTED
    }
}

