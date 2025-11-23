package com.ide.editor.query.dto;

import java.time.LocalDateTime;

public class EditorDTO {
    
    private String editorId;
    private String filePath;
    private String content;
    private String language;
    private int lineNumber;
    private int columnNumber;
    private boolean syntaxHighlightingEnabled;
    private boolean codeFoldingEnabled;
    private boolean minimapEnabled;
    private LocalDateTime lastModifiedAt;

    public EditorDTO(String editorId, String filePath, String content, String language,
                    int lineNumber, int columnNumber, boolean syntaxHighlightingEnabled,
                    boolean codeFoldingEnabled, boolean minimapEnabled, LocalDateTime lastModifiedAt) {
        this.editorId = editorId;
        this.filePath = filePath;
        this.content = content;
        this.language = language;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.syntaxHighlightingEnabled = syntaxHighlightingEnabled;
        this.codeFoldingEnabled = codeFoldingEnabled;
        this.minimapEnabled = minimapEnabled;
        this.lastModifiedAt = lastModifiedAt;
    }

    public String getEditorId() {
        return editorId;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getContent() {
        return content;
    }

    public String getLanguage() {
        return language;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
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

