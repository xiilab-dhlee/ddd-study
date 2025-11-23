package com.ide.agent.command.application;

import com.ide.agent.command.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgentTaskService {
    
    private AgentTaskRepository agentTaskRepository;

    public AgentTaskService(AgentTaskRepository agentTaskRepository) {
        this.agentTaskRepository = agentTaskRepository;
    }

    @Transactional
    public AgentId createTask(AgentTaskType taskType, String description, String contextFiles) {
        AgentId id = AgentId.generate();
        AgentTask task = new AgentTask(id, taskType, description, contextFiles);
        agentTaskRepository.save(task);
        return id;
    }

    @Transactional
    public void startTask(String agentId) {
        AgentTask task = agentTaskRepository.findById(new AgentId(agentId))
                .orElseThrow(() -> new NoAgentTaskException());
        task.start();
    }

    @Transactional
    public void completeTask(String agentId, String result) {
        AgentTask task = agentTaskRepository.findById(new AgentId(agentId))
                .orElseThrow(() -> new NoAgentTaskException());
        task.complete(result);
    }

    @Transactional
    public void failTask(String agentId, String errorMessage) {
        AgentTask task = agentTaskRepository.findById(new AgentId(agentId))
                .orElseThrow(() -> new NoAgentTaskException());
        task.fail(errorMessage);
    }
}

