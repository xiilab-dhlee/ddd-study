package com.ide.extensions.command.domain;

import com.myshop.common.event.Events;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "extension")
public class Extension {
    
    @EmbeddedId
    private ExtensionId id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "version")
    private String version;
    
    @Column(name = "description", length = 1000)
    private String description;
    
    @Column(name = "publisher")
    private String publisher;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ExtensionStatus status;
    
    @Column(name = "download_count")
    private Long downloadCount;
    
    @Column(name = "rating")
    private Double rating;
    
    @Column(name = "install_path")
    private String installPath;
    
    @Column(name = "installed_at")
    private LocalDateTime installedAt;
    
    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    protected Extension() {
    }

    public Extension(ExtensionId id, String name, String version, 
                    String description, String publisher) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.description = description;
        this.publisher = publisher;
        this.status = ExtensionStatus.AVAILABLE;
        this.downloadCount = 0L;
        this.rating = 0.0;
        this.publishedAt = LocalDateTime.now();
    }

    public void install(String installPath) {
        if (this.status == ExtensionStatus.INSTALLED) {
            throw new IllegalStateException("Extension already installed");
        }
        this.status = ExtensionStatus.INSTALLED;
        this.installPath = installPath;
        this.installedAt = LocalDateTime.now();
        this.downloadCount++;
        Events.raise(new ExtensionInstalledEvent(id, name, version));
    }

    public void uninstall() {
        if (this.status != ExtensionStatus.INSTALLED) {
            throw new IllegalStateException("Extension not installed");
        }
        this.status = ExtensionStatus.AVAILABLE;
        this.installPath = null;
        Events.raise(new ExtensionUninstalledEvent(id, name));
    }

    public void enable() {
        if (this.status != ExtensionStatus.INSTALLED && this.status != ExtensionStatus.DISABLED) {
            throw new IllegalStateException("Cannot enable extension");
        }
        this.status = ExtensionStatus.INSTALLED;
        Events.raise(new ExtensionEnabledEvent(id, name));
    }

    public void disable() {
        if (this.status != ExtensionStatus.INSTALLED) {
            throw new IllegalStateException("Extension not installed");
        }
        this.status = ExtensionStatus.DISABLED;
        Events.raise(new ExtensionDisabledEvent(id, name));
    }

    public void updateRating(Double newRating) {
        this.rating = newRating;
    }

    // Getters
    public ExtensionId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    public String getPublisher() {
        return publisher;
    }

    public ExtensionStatus getStatus() {
        return status;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public Double getRating() {
        return rating;
    }

    public String getInstallPath() {
        return installPath;
    }

    public LocalDateTime getInstalledAt() {
        return installedAt;
    }
}

