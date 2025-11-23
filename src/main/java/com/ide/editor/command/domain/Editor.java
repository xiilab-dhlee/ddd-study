package com.ide.editor.command.domain;

import com.myshop.common.event.Events;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "editor")
public class Editor {
    
    @EmbeddedId
    private EditorId id;
    
    @Column(name = "file_path")
    private String filePath;
    
    @Embedded
    private TextContent content;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private ProgrammingLanguage language;
    
    @Embedded
    private CursorPosition cursorPosition;
    
    @Embedded
    private FormattingRule formattingRule;
    
    @Column(name = "syntax_highlighting_enabled")
    private boolean syntaxHighlightingEnabled;
    
    @Column(name = "code_folding_enabled")
    private boolean codeFoldingEnabled;
    
    @Column(name = "minimap_enabled")
    private boolean minimapEnabled;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

    protected Editor() {
    }

    public Editor(EditorId id, String filePath, ProgrammingLanguage language) {
        this.id = id;
        this.filePath = filePath;
        this.content = new TextContent("");
        this.language = language;
        this.cursorPosition = new CursorPosition(0, 0);
        this.formattingRule = FormattingRule.defaultRule();
        this.syntaxHighlightingEnabled = true;
        this.codeFoldingEnabled = true;
        this.minimapEnabled = true;
        this.createdAt = LocalDateTime.now();
        this.lastModifiedAt = LocalDateTime.now();
        
        Events.raise(new EditorOpenedEvent(id, filePath, language));
    }

    public void insertText(int position, String text) {
        this.content = content.insert(position, text);
        this.lastModifiedAt = LocalDateTime.now();
        Events.raise(new TextEditedEvent(id, "insert", position, text));
    }

    public void deleteText(int start, int end) {
        this.content = content.delete(start, end);
        this.lastModifiedAt = LocalDateTime.now();
        Events.raise(new TextEditedEvent(id, "delete", start, null));
    }

    public void replaceText(int start, int end, String text) {
        this.content = content.replace(start, end, text);
        this.lastModifiedAt = LocalDateTime.now();
        Events.raise(new TextEditedEvent(id, "replace", start, text));
    }

    public void moveCursor(int line, int column) {
        this.cursorPosition = new CursorPosition(line, column);
    }

    public void formatDocument() {
        // 포맷팅 로직 실행
        this.lastModifiedAt = LocalDateTime.now();
        Events.raise(new DocumentFormattedEvent(id, formattingRule));
    }

    public void toggleSyntaxHighlighting() {
        this.syntaxHighlightingEnabled = !syntaxHighlightingEnabled;
    }

    public void toggleCodeFolding() {
        this.codeFoldingEnabled = !codeFoldingEnabled;
    }

    public void toggleMinimap() {
        this.minimapEnabled = !minimapEnabled;
    }

    public void updateFormattingRule(FormattingRule newRule) {
        this.formattingRule = newRule;
    }

    // Getters
    public EditorId getId() {
        return id;
    }

    public String getFilePath() {
        return filePath;
    }

    public TextContent getContent() {
        return content;
    }

    public ProgrammingLanguage getLanguage() {
        return language;
    }

    public CursorPosition getCursorPosition() {
        return cursorPosition;
    }

    public FormattingRule getFormattingRule() {
        return formattingRule;
    }

    public boolean isSyntaxHighlightingEnabled() {
        return syntaxHighlightingEnabled;
    }

    public boolean isCodeFoldingEnabled() {
        return codeFoldingEnabled;
    }

    public boolean isMinimapEnabled() {
        return minimapEnabled;
    }

    public LocalDateTime getLastModifiedAt() {
        return lastModifiedAt;
    }
}

