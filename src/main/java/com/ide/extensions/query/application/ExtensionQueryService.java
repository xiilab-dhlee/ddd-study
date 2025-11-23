package com.ide.extensions.query.application;

import com.ide.extensions.command.domain.Extension;
import com.ide.extensions.command.domain.ExtensionId;
import com.ide.extensions.command.domain.ExtensionRepository;
import com.ide.extensions.command.domain.ExtensionStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ExtensionQueryService {
    
    private ExtensionRepository extensionRepository;

    public ExtensionQueryService(ExtensionRepository extensionRepository) {
        this.extensionRepository = extensionRepository;
    }

    public Optional<Extension> getExtension(String extensionId) {
        return extensionRepository.findById(new ExtensionId(extensionId));
    }

    public List<Extension> getExtensionsByStatus(ExtensionStatus status) {
        return extensionRepository.findByStatus(status);
    }

    public List<Extension> getExtensionsByPublisher(String publisher) {
        return extensionRepository.findByPublisher(publisher);
    }

    public List<Extension> getAllExtensions() {
        return extensionRepository.findAll();
    }
}

