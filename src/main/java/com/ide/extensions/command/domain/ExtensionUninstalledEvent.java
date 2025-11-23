package com.ide.extensions.command.domain;

import com.myshop.common.event.Event;

public class ExtensionUninstalledEvent extends Event {
    
    private ExtensionId extensionId;
    private String name;

    public ExtensionUninstalledEvent(ExtensionId extensionId, String name) {
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

