package com.ide.aiservices.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AIModelRepository extends JpaRepository<AIModel, AIModelId> {
    
    List<AIModel> findByProvider(AIProvider provider);
    
    List<AIModel> findByIsActive(boolean isActive);
}

