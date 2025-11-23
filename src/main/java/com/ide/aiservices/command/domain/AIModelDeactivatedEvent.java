package com.ide.aiservices.command.domain;

import com.ide.common.event.Event;

public class AIModelDeactivatedEvent extends Event {

    private AIModelId modelId;
    private String modelName;

    public AIModelDeactivatedEvent(AIModelId modelId, String modelName) {
        super();
        this.modelId = modelId;
        this.modelName = modelName;
    }

    public AIModelId getModelId() {
        return modelId;
    }

    public String getModelName() {
        return modelName;
    }
}

