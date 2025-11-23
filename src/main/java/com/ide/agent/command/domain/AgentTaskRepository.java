package com.ide.agent.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentTaskRepository extends JpaRepository<AgentTask, AgentId> {
    
    List<AgentTask> findByStatus(AgentTaskStatus status);
    
    List<AgentTask> findByTaskType(AgentTaskType taskType);
}

