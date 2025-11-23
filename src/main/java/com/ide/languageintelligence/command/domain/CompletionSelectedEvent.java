package com.ide.languageintelligence.command.domain;

import com.myshop.common.event.Event;

public class CompletionSelectedEvent extends Event {
    
    private CodeCompletionId completionId;
    private CompletionItem selectedItem;

    public CompletionSelectedEvent(CodeCompletionId completionId, CompletionItem selectedItem) {
        super();
        this.completionId = completionId;
        this.selectedItem = selectedItem;
    }

    public CodeCompletionId getCompletionId() {
        return completionId;
    }

    public CompletionItem getSelectedItem() {
        return selectedItem;
    }
}

