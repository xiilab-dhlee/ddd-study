package com.ide.editor.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CursorPosition {

    @Column(name = "line_number")
    private int line;

    @Column(name = "column_number")
    private int column;

    protected CursorPosition() {
    }

    public CursorPosition(int line, int column) {
        if (line < 0 || column < 0) {
            throw new IllegalArgumentException("Line and column must be non-negative");
        }
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public CursorPosition moveTo(int newLine, int newColumn) {
        return new CursorPosition(newLine, newColumn);
    }

    public CursorPosition moveDown(int lines) {
        return new CursorPosition(line + lines, column);
    }

    public CursorPosition moveUp(int lines) {
        return new CursorPosition(Math.max(0, line - lines), column);
    }

    public CursorPosition moveRight(int columns) {
        return new CursorPosition(line, column + columns);
    }

    public CursorPosition moveLeft(int columns) {
        return new CursorPosition(line, Math.max(0, column - columns));
    }
}

