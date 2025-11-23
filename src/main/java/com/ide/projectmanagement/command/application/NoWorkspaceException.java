package com.ide.projectmanagement.command.application;

public class NoWorkspaceException extends RuntimeException {

    public NoWorkspaceException() {
        super("Workspace not found");
    }
}

