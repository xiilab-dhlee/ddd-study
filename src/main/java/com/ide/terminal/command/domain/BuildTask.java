package com.ide.terminal.command.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "build_task")
public class BuildTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "command")
    private String command;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private BuildTaskType type;

    @Column(name = "working_directory")
    private String workingDirectory;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BuildTaskStatus status;

    @Lob
    @Column(name = "output", columnDefinition = "TEXT")
    private String output;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    protected BuildTask() {
    }

    public BuildTask(String name, String command, BuildTaskType type, String workingDirectory) {
        this.name = name;
        this.command = command;
        this.type = type;
        this.workingDirectory = workingDirectory;
        this.status = BuildTaskStatus.PENDING;
    }

    public void start() {
        this.status = BuildTaskStatus.RUNNING;
        this.startedAt = LocalDateTime.now();
    }

    public void complete(String output) {
        this.status = BuildTaskStatus.SUCCESS;
        this.output = output;
        this.completedAt = LocalDateTime.now();
    }

    public void fail(String errorOutput) {
        this.status = BuildTaskStatus.FAILED;
        this.output = errorOutput;
        this.completedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

    public BuildTaskType getType() {
        return type;
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    public BuildTaskStatus getStatus() {
        return status;
    }

    public String getOutput() {
        return output;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public enum BuildTaskType {
        BUILD, TEST, RUN, CLEAN, DEPLOY
    }

    public enum BuildTaskStatus {
        PENDING, RUNNING, SUCCESS, FAILED
    }
}

