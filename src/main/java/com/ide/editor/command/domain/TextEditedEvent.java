package com.ide.editor.command.domain;

import com.myshop.common.event.Event;

public class TextEditedEvent extends Event {
    
    private EditorId editorId;
    private String operationType;
    private int position;
    private String text;

    public TextEditedEvent(EditorId editorId, String operationType, int position, String text) {
        super();
        this.editorId = editorId;
        this.operationType = operationType;
        this.position = position;
        this.text = text;
    }

    public EditorId getEditorId() {
        return editorId;
    }

    public String getOperationType() {
        return operationType;
    }

    public int getPosition() {
        return position;
    }

    public String getText() {
        return text;
    }
}

