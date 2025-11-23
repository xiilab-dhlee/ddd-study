package com.ide.extensions.command.application;

import com.ide.extensions.command.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExtensionService {
    
    private ExtensionRepository extensionRepository;

    public ExtensionService(ExtensionRepository extensionRepository) {
        this.extensionRepository = extensionRepository;
    }

    @Transactional
    public void installExtension(String extensionId, String installPath) {
        Extension extension = extensionRepository.findById(new ExtensionId(extensionId))
                .orElseThrow(() -> new NoExtensionException());
        extension.install(installPath);
    }

    @Transactional
    public void uninstallExtension(String extensionId) {
        Extension extension = extensionRepository.findById(new ExtensionId(extensionId))
                .orElseThrow(() -> new NoExtensionException());
        extension.uninstall();
    }

    @Transactional
    public void enableExtension(String extensionId) {
        Extension extension = extensionRepository.findById(new ExtensionId(extensionId))
                .orElseThrow(() -> new NoExtensionException());
        extension.enable();
    }

    @Transactional
    public void disableExtension(String extensionId) {
        Extension extension = extensionRepository.findById(new ExtensionId(extensionId))
                .orElseThrow(() -> new NoExtensionException());
        extension.disable();
    }

    @Transactional
    public void publishExtension(String id, String name, String version, 
                                String description, String publisher) {
        Extension extension = new Extension(new ExtensionId(id), name, version, 
                                          description, publisher);
        extensionRepository.save(extension);
    }
}

