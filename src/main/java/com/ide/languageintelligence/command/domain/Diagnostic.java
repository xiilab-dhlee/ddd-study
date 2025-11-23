package com.ide.languageintelligence.command.domain;

import javax.persistence.*;

@Entity
@Table(name = "diagnostic")
public class Diagnostic {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "file_path")
    private String filePath;
    
    @Column(name = "line_number")
    private int line;
    
    @Column(name = "column_number")
    private int column;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "severity")
    private DiagnosticSeverity severity;
    
    @Column(name = "message")
    private String message;
    
    @Column(name = "error_code")
    private String errorCode;

    protected Diagnostic() {
    }

    public Diagnostic(String filePath, int line, int column, 
                     DiagnosticSeverity severity, String message, String errorCode) {
        this.filePath = filePath;
        this.line = line;
        this.column = column;
        this.severity = severity;
        this.message = message;
        this.errorCode = errorCode;
    }

    public Long getId() {
        return id;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public DiagnosticSeverity getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public enum DiagnosticSeverity {
        ERROR, WARNING, INFO, HINT
    }
}

