package com.ide.aiservices.command.application;

import com.ide.aiservices.command.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AIModelService {
    
    private AIModelRepository aiModelRepository;

    public AIModelService(AIModelRepository aiModelRepository) {
        this.aiModelRepository = aiModelRepository;
    }

    @Transactional
    public AIModelId registerModel(String name, AIProvider provider, 
                                   String modelVersion, Integer maxTokens) {
        AIModelId id = AIModelId.generate();
        AIModel model = new AIModel(id, name, provider, modelVersion, maxTokens);
        aiModelRepository.save(model);
        return id;
    }

    @Transactional
    public void activateModel(String modelId) {
        AIModel model = aiModelRepository.findById(new AIModelId(modelId))
                .orElseThrow(() -> new NoAIModelException());
        model.activate();
    }

    @Transactional
    public void deactivateModel(String modelId) {
        AIModel model = aiModelRepository.findById(new AIModelId(modelId))
                .orElseThrow(() -> new NoAIModelException());
        model.deactivate();
    }

    @Transactional
    public void updateTemperature(String modelId, Double temperature) {
        AIModel model = aiModelRepository.findById(new AIModelId(modelId))
                .orElseThrow(() -> new NoAIModelException());
        model.updateTemperature(temperature);
    }
}

