package com.ide.aiservices.command.domain;

import javax.persistence.*;

@Entity
@Table(name = "prompt_template")
public class PromptTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "template", columnDefinition = "TEXT")
    private String template;

    @Enumerated(EnumType.STRING)
    @Column(name = "purpose")
    private PromptPurpose purpose;

    @Column(name = "max_context_files")
    private Integer maxContextFiles;

    protected PromptTemplate() {
    }

    public PromptTemplate(String name, String template, PromptPurpose purpose) {
        this.name = name;
        this.template = template;
        this.purpose = purpose;
        this.maxContextFiles = 5;
    }

    public String render(String... variables) {
        String rendered = template;
        for (int i = 0; i < variables.length; i++) {
            rendered = rendered.replace("{" + i + "}", variables[i]);
        }
        return rendered;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTemplate() {
        return template;
    }

    public PromptPurpose getPurpose() {
        return purpose;
    }

    public Integer getMaxContextFiles() {
        return maxContextFiles;
    }

    public enum PromptPurpose {
        CODE_GENERATION, BUG_FIX, REFACTORING, 
        DOCUMENTATION, CODE_REVIEW, EXPLANATION
    }
}

