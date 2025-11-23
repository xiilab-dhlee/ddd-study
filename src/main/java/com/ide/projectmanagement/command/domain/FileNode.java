package com.ide.projectmanagement.command.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "file_node")
public class FileNode {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "path")
    private String path;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private FileNodeType type;
    
    @Column(name = "parent_path")
    private String parentPath;
    
    @Column(name = "size")
    private Long size;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    protected FileNode() {
    }

    public FileNode(String name, String path, FileNodeType type, String parentPath) {
        this.name = name;
        this.path = path;
        this.type = type;
        this.parentPath = parentPath;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    public void rename(String newName) {
        this.name = newName;
        this.modifiedAt = LocalDateTime.now();
    }

    public void updateSize(Long newSize) {
        this.size = newSize;
        this.modifiedAt = LocalDateTime.now();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public FileNodeType getType() {
        return type;
    }

    public String getParentPath() {
        return parentPath;
    }

    public Long getSize() {
        return size;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public enum FileNodeType {
        FILE, DIRECTORY
    }
}

