package com.ide.languageintelligence.query.dto;

public class CompletionItemDTO {
    
    private String label;
    private String insertText;
    private String type;
    private String documentation;
    private double confidenceScore;

    public CompletionItemDTO(String label, String insertText, String type,
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

    public String getType() {
        return type;
    }

    public String getDocumentation() {
        return documentation;
    }

    public double getConfidenceScore() {
        return confidenceScore;
    }
}

