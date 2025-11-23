package com.ide.editor.command.application;

import com.ide.editor.command.domain.Editor;
import com.ide.editor.command.domain.EditorId;
import com.ide.editor.command.domain.EditorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditTextService {
    
    private EditorRepository editorRepository;

    public EditTextService(EditorRepository editorRepository) {
        this.editorRepository = editorRepository;
    }

    @Transactional
    public void insertText(String editorId, int position, String text) {
        Editor editor = editorRepository.findById(new EditorId(editorId))
                .orElseThrow(() -> new NoEditorException());
        editor.insertText(position, text);
    }

    @Transactional
    public void deleteText(String editorId, int start, int end) {
        Editor editor = editorRepository.findById(new EditorId(editorId))
                .orElseThrow(() -> new NoEditorException());
        editor.deleteText(start, end);
    }

    @Transactional
    public void replaceText(String editorId, int start, int end, String text) {
        Editor editor = editorRepository.findById(new EditorId(editorId))
                .orElseThrow(() -> new NoEditorException());
        editor.replaceText(start, end, text);
    }

    @Transactional
    public void formatDocument(String editorId) {
        Editor editor = editorRepository.findById(new EditorId(editorId))
                .orElseThrow(() -> new NoEditorException());
        editor.formatDocument();
    }
}

