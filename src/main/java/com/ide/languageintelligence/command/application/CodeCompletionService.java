package com.ide.languageintelligence.command.application;

import com.ide.languageintelligence.command.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CodeCompletionService {
    
    private CodeCompletionRepository codeCompletionRepository;

    public CodeCompletionService(CodeCompletionRepository codeCompletionRepository) {
        this.codeCompletionRepository = codeCompletionRepository;
    }

    @Transactional
    public CodeCompletionId requestCompletion(String filePath, int position) {
        CodeCompletionId id = CodeCompletionId.generate();
        CodeCompletion completion = new CodeCompletion(id, filePath, position);
        
        // AI 기반 코드 완성 로직 (여기서는 샘플 데이터)
        List<CompletionItem> suggestions = generateCompletions(filePath, position);
        suggestions.forEach(completion::addCompletionItem);
        
        codeCompletionRepository.save(completion);
        return id;
    }

    private List<CompletionItem> generateCompletions(String filePath, int position) {
        // 실제로는 LSP(Language Server Protocol)나 AI 모델을 통해 완성 제안 생성
        return List.of(
            new CompletionItem("toString", "toString()", 
                CompletionItem.CompletionType.METHOD, 
                "Returns a string representation", 0.95),
            new CompletionItem("equals", "equals(Object obj)", 
                CompletionItem.CompletionType.METHOD, 
                "Indicates whether some other object is equal", 0.88)
        );
    }
}

