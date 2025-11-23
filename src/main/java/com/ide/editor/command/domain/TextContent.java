package com.ide.editor.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class TextContent {

    @Lob
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    protected TextContent() {
    }

    public TextContent(String content) {
        this.content = content != null ? content : "";
    }

    public String getContent() {
        return content;
    }

    public int getLength() {
        return content.length();
    }

    public int getLineCount() {
        return content.split("\n", -1).length;
    }

    public TextContent insert(int position, String text) {
        if (position < 0 || position > content.length()) {
            throw new IllegalArgumentException("Invalid position");
        }
        String newContent = content.substring(0, position) + text + content.substring(position);
        return new TextContent(newContent);
    }

    public TextContent delete(int start, int end) {
        if (start < 0 || end > content.length() || start > end) {
            throw new IllegalArgumentException("Invalid range");
        }
        String newContent = content.substring(0, start) + content.substring(end);
        return new TextContent(newContent);
    }

    public TextContent replace(int start, int end, String text) {
        return delete(start, end).insert(start, text);
    }
}

