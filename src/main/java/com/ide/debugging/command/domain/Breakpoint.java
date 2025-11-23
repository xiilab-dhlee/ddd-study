package com.ide.debugging.command.domain;

import javax.persistence.*;

@Entity
@Table(name = "breakpoint")
public class Breakpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "line_number")
    private int lineNumber;

    @Column(name = "condition")
    private String condition;

    @Column(name = "enabled")
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private BreakpointType type;

    protected Breakpoint() {
    }

    public Breakpoint(String filePath, int lineNumber, BreakpointType type) {
        this.filePath = filePath;
        this.lineNumber = lineNumber;
        this.type = type;
        this.enabled = true;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
    }

    public Long getId() {
        return id;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getCondition() {
        return condition;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public BreakpointType getType() {
        return type;
    }

    public enum BreakpointType {
        LINE, CONDITIONAL, EXCEPTION, DATA
    }
}

