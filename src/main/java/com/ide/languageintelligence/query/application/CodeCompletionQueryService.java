package com.ide.languageintelligence.query.application;

import com.ide.languageintelligence.command.domain.CodeCompletion;
import com.ide.languageintelligence.command.domain.CodeCompletionId;
import com.ide.languageintelligence.command.domain.CodeCompletionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CodeCompletionQueryService {
    
    private CodeCompletionRepository codeCompletionRepository;

    public CodeCompletionQueryService(CodeCompletionRepository codeCompletionRepository) {
        this.codeCompletionRepository = codeCompletionRepository;
    }

    public Optional<CodeCompletion> getCompletion(String completionId) {
        return codeCompletionRepository.findById(new CodeCompletionId(completionId));
    }
}

