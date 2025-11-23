package com.ide.editor.command.application;

public class NoEditorException extends RuntimeException {

    public NoEditorException() {
        super("Editor not found");
    }
}

