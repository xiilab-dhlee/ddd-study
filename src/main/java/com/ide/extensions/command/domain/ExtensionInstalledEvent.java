package com.ide.extensions.command.domain;

import com.ide.common.event.Event;

public class ExtensionInstalledEvent extends Event {

    private ExtensionId extensionId;
    private String name;
    private String version;

    public ExtensionInstalledEvent(ExtensionId extensionId, String name, String version) {
        super();
        this.extensionId = extensionId;
        this.name = name;
        this.version = version;
    }

    public ExtensionId getExtensionId() {
        return extensionId;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}

