package com.ide.extensions.command.domain;

import com.ide.common.event.Event;

public class ExtensionDisabledEvent extends Event {
    
    private ExtensionId extensionId;
    private String name;

    public ExtensionDisabledEvent(ExtensionId extensionId, String name) {
        super();
        this.extensionId = extensionId;
        this.name = name;
    }

    public ExtensionId getExtensionId() {
        return extensionId;
    }

    public String getName() {
        return name;
    }
}

