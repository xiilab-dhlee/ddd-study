package com.ide.editor.command.application;

import com.ide.editor.command.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OpenEditorService {

    private EditorRepository editorRepository;

    public OpenEditorService(EditorRepository editorRepository) {
        this.editorRepository = editorRepository;
    }

    @Transactional
    public EditorId openEditor(String filePath, ProgrammingLanguage language) {
        EditorId editorId = EditorId.generate();
        Editor editor = new Editor(editorId, filePath, language);
        editorRepository.save(editor);
        return editorId;
    }
}

