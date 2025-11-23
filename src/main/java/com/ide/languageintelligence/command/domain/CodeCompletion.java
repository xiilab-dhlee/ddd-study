package com.ide.languageintelligence.command.domain;

import com.ide.common.event.Events;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "code_completion")
public class CodeCompletion {

    @EmbeddedId
    private CodeCompletionId id;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "trigger_position")
    private int triggerPosition;

    @ElementCollection
    @CollectionTable(name = "completion_items", 
                    joinColumns = @JoinColumn(name = "completion_id"))
    private List<CompletionItem> items;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    protected CodeCompletion() {
    }

    public CodeCompletion(CodeCompletionId id, String filePath, int triggerPosition) {
        this.id = id;
        this.filePath = filePath;
        this.triggerPosition = triggerPosition;
        this.items = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }

    public void addCompletionItem(CompletionItem item) {
        this.items.add(item);
    }

    public void selectCompletion(int index) {
        if (index >= 0 && index < items.size()) {
            CompletionItem selected = items.get(index);
            Events.raise(new CompletionSelectedEvent(id, selected));
        }
    }

    public CodeCompletionId getId() {
        return id;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getTriggerPosition() {
        return triggerPosition;
    }

    public List<CompletionItem> getItems() {
        return items;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

