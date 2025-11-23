package com.ide.editor.query.application;

import com.ide.editor.query.dao.EditorDataDao;
import com.ide.editor.query.dto.EditorDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EditorQueryService {
    
    private EditorDataDao editorDataDao;

    public EditorQueryService(EditorDataDao editorDataDao) {
        this.editorDataDao = editorDataDao;
    }

    public Optional<EditorDTO> getEditor(String editorId) {
        return editorDataDao.findById(editorId);
    }

    public Optional<EditorDTO> getEditorByFilePath(String filePath) {
        return editorDataDao.findByFilePath(filePath);
    }

    public List<EditorDTO> getAllEditors() {
        return editorDataDao.findAll();
    }

    public List<EditorDTO> getEditorsByLanguage(String language) {
        return editorDataDao.findByLanguage(language);
    }
}

