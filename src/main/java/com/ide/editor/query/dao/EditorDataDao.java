package com.ide.editor.query.dao;

import com.ide.editor.query.dto.EditorDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EditorDataDao {
    
    private JdbcTemplate jdbcTemplate;

    public EditorDataDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<EditorDTO> editorMapper = (rs, rowNum) -> 
        new EditorDTO(
            rs.getString("editor_id"),
            rs.getString("file_path"),
            rs.getString("content"),
            rs.getString("language"),
            rs.getInt("line_number"),
            rs.getInt("column_number"),
            rs.getBoolean("syntax_highlighting_enabled"),
            rs.getBoolean("code_folding_enabled"),
            rs.getBoolean("minimap_enabled"),
            rs.getTimestamp("last_modified_at").toLocalDateTime()
        );

    public Optional<EditorDTO> findById(String editorId) {
        String sql = "SELECT * FROM editor WHERE editor_id = ?";
        List<EditorDTO> results = jdbcTemplate.query(sql, editorMapper, editorId);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    public Optional<EditorDTO> findByFilePath(String filePath) {
        String sql = "SELECT * FROM editor WHERE file_path = ?";
        List<EditorDTO> results = jdbcTemplate.query(sql, editorMapper, filePath);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    public List<EditorDTO> findAll() {
        String sql = "SELECT * FROM editor ORDER BY last_modified_at DESC";
        return jdbcTemplate.query(sql, editorMapper);
    }

    public List<EditorDTO> findByLanguage(String language) {
        String sql = "SELECT * FROM editor WHERE language = ? ORDER BY last_modified_at DESC";
        return jdbcTemplate.query(sql, editorMapper, language);
    }
}

