package com.ide.editor.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FormattingRule {
    
    @Column(name = "indent_size")
    private int indentSize;
    
    @Column(name = "use_tabs")
    private boolean useTabs;
    
    @Column(name = "trim_trailing_whitespace")
    private boolean trimTrailingWhitespace;

    protected FormattingRule() {
    }

    public FormattingRule(int indentSize, boolean useTabs, boolean trimTrailingWhitespace) {
        if (indentSize <= 0) {
            throw new IllegalArgumentException("Indent size must be positive");
        }
        this.indentSize = indentSize;
        this.useTabs = useTabs;
        this.trimTrailingWhitespace = trimTrailingWhitespace;
    }

    public static FormattingRule defaultRule() {
        return new FormattingRule(4, false, true);
    }

    public int getIndentSize() {
        return indentSize;
    }

    public boolean isUseTabs() {
        return useTabs;
    }

    public boolean isTrimTrailingWhitespace() {
        return trimTrailingWhitespace;
    }
}

