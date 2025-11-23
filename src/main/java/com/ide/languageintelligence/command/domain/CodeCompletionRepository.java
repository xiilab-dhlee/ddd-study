package com.ide.languageintelligence.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeCompletionRepository extends JpaRepository<CodeCompletion, CodeCompletionId> {
}

