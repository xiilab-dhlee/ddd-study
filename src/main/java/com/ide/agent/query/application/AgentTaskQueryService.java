package com.ide.agent.query.application;

import com.ide.agent.command.domain.AgentTask;
import com.ide.agent.command.domain.AgentId;
import com.ide.agent.command.domain.AgentTaskRepository;
import com.ide.agent.command.domain.AgentTaskStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AgentTaskQueryService {
    
    private AgentTaskRepository agentTaskRepository;

    public AgentTaskQueryService(AgentTaskRepository agentTaskRepository) {
        this.agentTaskRepository = agentTaskRepository;
    }

    public Optional<AgentTask> getTask(String agentId) {
        return agentTaskRepository.findById(new AgentId(agentId));
    }

    public List<AgentTask> getTasksByStatus(AgentTaskStatus status) {
        return agentTaskRepository.findByStatus(status);
    }

    public List<AgentTask> getAllTasks() {
        return agentTaskRepository.findAll();
    }
}

