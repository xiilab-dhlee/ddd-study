package com.ide.editor.command.domain;

import com.ide.common.event.Event;

public class DocumentFormattedEvent extends Event {

    private EditorId editorId;
    private FormattingRule formattingRule;

    public DocumentFormattedEvent(EditorId editorId, FormattingRule formattingRule) {
        super();
        this.editorId = editorId;
        this.formattingRule = formattingRule;
    }

    public EditorId getEditorId() {
        return editorId;
    }

    public FormattingRule getFormattingRule() {
        return formattingRule;
    }
}

