package com.ide.editor.infra;

import com.ide.editor.command.domain.EditorOpenedEvent;
import com.ide.editor.command.domain.TextEditedEvent;
import com.ide.editor.command.domain.DocumentFormattedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EditorEventHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(EditorEventHandler.class);

    @EventListener
    public void handleEditorOpened(EditorOpenedEvent event) {
        logger.info("Editor opened - ID: {}, File: {}, Language: {}", 
            event.getEditorId().getId(), 
            event.getFilePath(), 
            event.getLanguage());
    }

    @EventListener
    public void handleTextEdited(TextEditedEvent event) {
        logger.info("Text edited - Editor ID: {}, Operation: {}, Position: {}", 
            event.getEditorId().getId(), 
            event.getOperationType(), 
            event.getPosition());
    }

    @EventListener
    public void handleDocumentFormatted(DocumentFormattedEvent event) {
        logger.info("Document formatted - Editor ID: {}, Indent Size: {}", 
            event.getEditorId().getId(), 
            event.getFormattingRule().getIndentSize());
    }
}

