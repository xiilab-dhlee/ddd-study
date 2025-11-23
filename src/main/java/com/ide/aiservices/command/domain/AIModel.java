package com.ide.aiservices.command.domain;

import com.myshop.common.event.Events;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ai_model")
public class AIModel {
    
    @EmbeddedId
    private AIModelId id;
    
    @Column(name = "name")
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "provider")
    private AIProvider provider;
    
    @Column(name = "model_version")
    private String modelVersion;
    
    @Column(name = "max_tokens")
    private Integer maxTokens;
    
    @Column(name = "temperature")
    private Double temperature;
    
    @Column(name = "cost_per_token")
    private Double costPerToken;
    
    @Column(name = "is_active")
    private boolean isActive;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    protected AIModel() {
    }

    public AIModel(AIModelId id, String name, AIProvider provider, 
                  String modelVersion, Integer maxTokens) {
        this.id = id;
        this.name = name;
        this.provider = provider;
        this.modelVersion = modelVersion;
        this.maxTokens = maxTokens;
        this.temperature = 0.7;
        this.isActive = true;
        this.createdAt = LocalDateTime.now();
    }

    public void activate() {
        this.isActive = true;
        Events.raise(new AIModelActivatedEvent(id, name));
    }

    public void deactivate() {
        this.isActive = false;
        Events.raise(new AIModelDeactivatedEvent(id, name));
    }

    public void updateTemperature(Double newTemperature) {
        if (newTemperature < 0.0 || newTemperature > 2.0) {
            throw new IllegalArgumentException("Temperature must be between 0.0 and 2.0");
        }
        this.temperature = newTemperature;
    }

    public void updateCostPerToken(Double newCost) {
        this.costPerToken = newCost;
    }

    // Getters
    public AIModelId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AIProvider getProvider() {
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

    public Double getCostPerToken() {
        return costPerToken;
    }

    public boolean isActive() {
        return isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

