package com.ide.editor.command.domain;

import com.myshop.common.event.Event;

public class EditorOpenedEvent extends Event {
    
    private EditorId editorId;
    private String filePath;
    private ProgrammingLanguage language;

    public EditorOpenedEvent(EditorId editorId, String filePath, ProgrammingLanguage language) {
        super();
        this.editorId = editorId;
        this.filePath = filePath;
        this.language = language;
    }

    public EditorId getEditorId() {
        return editorId;
    }

    public String getFilePath() {
        return filePath;
    }

    public ProgrammingLanguage getLanguage() {
        return language;
    }
}

