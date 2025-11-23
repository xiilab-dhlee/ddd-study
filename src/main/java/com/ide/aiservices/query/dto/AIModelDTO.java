package com.ide.aiservices.query.dto;

public class AIModelDTO {
    
    private String modelId;
    private String name;
    private String provider;
    private String modelVersion;
    private Integer maxTokens;
    private Double temperature;
    private boolean isActive;

    public AIModelDTO(String modelId, String name, String provider, String modelVersion,
                     Integer maxTokens, Double temperature, boolean isActive) {
        this.modelId = modelId;
        this.name = name;
        this.provider = provider;
        this.modelVersion = modelVersion;
        this.maxTokens = maxTokens;
        this.temperature = temperature;
        this.isActive = isActive;
    }

    public String getModelId() {
        return modelId;
    }

    public String getName() {
        return name;
    }

    public String getProvider() {
        return provider;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public Double getTemperature() {
        return temperature;
    }

    public boolean isActive() {
        return isActive;
    }
}

