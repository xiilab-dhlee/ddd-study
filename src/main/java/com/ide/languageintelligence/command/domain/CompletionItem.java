package com.ide.languageintelligence.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class CompletionItem {
    
    @Column(name = "label")
    private String label;
    
    @Column(name = "insert_text")
    private String insertText;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "completion_type")
    private CompletionType type;
    
    @Column(name = "documentation")
    private String documentation;
    
    @Column(name = "confidence_score")
    private double confidenceScore;

    protected CompletionItem() {
    }

    public CompletionItem(String label, String insertText, CompletionType type, 
                         String documentation, double confidenceScore) {
        this.label = label;
        this.insertText = insertText;
        this.type = type;
        this.documentation = documentation;
        this.confidenceScore = confidenceScore;
    }

    public String getLabel() {
        return label;
    }

    public String getInsertText() {
        return insertText;
    }

    public CompletionType getType() {
        return type;
    }

    public String getDocumentation() {
        return documentation;
    }

    public double getConfidenceScore() {
        return confidenceScore;
    }

    public enum CompletionType {
        METHOD, FUNCTION, VARIABLE, CLASS, INTERFACE, 
        MODULE, PROPERTY, KEYWORD, SNIPPET
    }
}

