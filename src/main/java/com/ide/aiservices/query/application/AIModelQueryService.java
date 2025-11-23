package com.ide.aiservices.query.application;

import com.ide.aiservices.command.domain.AIModel;
import com.ide.aiservices.command.domain.AIModelId;
import com.ide.aiservices.command.domain.AIModelRepository;
import com.ide.aiservices.command.domain.AIProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AIModelQueryService {
    
    private AIModelRepository aiModelRepository;

    public AIModelQueryService(AIModelRepository aiModelRepository) {
        this.aiModelRepository = aiModelRepository;
    }

    public Optional<AIModel> getModel(String modelId) {
        return aiModelRepository.findById(new AIModelId(modelId));
    }

    public List<AIModel> getModelsByProvider(AIProvider provider) {
        return aiModelRepository.findByProvider(provider);
    }

    public List<AIModel> getActiveModels() {
        return aiModelRepository.findByIsActive(true);
    }

    public List<AIModel> getAllModels() {
        return aiModelRepository.findAll();
    }
}

