package com.ide.settings.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EditorSettings {
    
    @Column(name = "font_size")
    private int fontSize;
    
    @Column(name = "font_family")
    private String fontFamily;
    
    @Column(name = "tab_size")
    private int tabSize;
    
    @Column(name = "insert_spaces")
    private boolean insertSpaces;
    
    @Column(name = "word_wrap")
    private boolean wordWrap;
    
    @Column(name = "line_numbers")
    private boolean lineNumbers;
    
    @Column(name = "auto_save")
    private boolean autoSave;

    protected EditorSettings() {
    }

    public EditorSettings(int fontSize, String fontFamily, int tabSize, 
                         boolean insertSpaces, boolean wordWrap, 
                         boolean lineNumbers, boolean autoSave) {
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.tabSize = tabSize;
        this.insertSpaces = insertSpaces;
        this.wordWrap = wordWrap;
        this.lineNumbers = lineNumbers;
        this.autoSave = autoSave;
    }

    public static EditorSettings defaultSettings() {
        return new EditorSettings(14, "Consolas", 4, true, false, true, true);
    }

    // Getters
    public int getFontSize() {
        return fontSize;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public int getTabSize() {
        return tabSize;
    }

    public boolean isInsertSpaces() {
        return insertSpaces;
    }

    public boolean isWordWrap() {
        return wordWrap;
    }

    public boolean isLineNumbers() {
        return lineNumbers;
    }

    public boolean isAutoSave() {
        return autoSave;
    }
}

