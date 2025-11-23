package com.ide.extensions.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExtensionRepository extends JpaRepository<Extension, ExtensionId> {
    
    List<Extension> findByStatus(ExtensionStatus status);
    
    List<Extension> findByPublisher(String publisher);
}

