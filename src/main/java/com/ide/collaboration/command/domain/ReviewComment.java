package com.ide.collaboration.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class ReviewComment {

    @Column(name = "comment_text")
    private String text;

    @Column(name = "line_number")
    private int lineNumber;

    @Column(name = "commenter_id")
    private String commenterId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    protected ReviewComment() {
    }

    public ReviewComment(String text, int lineNumber, String commenterId) {
        this.text = text;
        this.lineNumber = lineNumber;
        this.commenterId = commenterId;
        this.createdAt = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getCommenterId() {
        return commenterId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

