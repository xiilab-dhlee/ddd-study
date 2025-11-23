package com.ide.editor.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EditorRepository extends JpaRepository<Editor, EditorId> {
    
    Optional<Editor> findByFilePath(String filePath);
}

