package com.ide.extensions.query.dto;

public class ExtensionDTO {
    
    private String extensionId;
    private String name;
    private String version;
    private String description;
    private String publisher;
    private String status;
    private Long downloadCount;
    private Double rating;

    public ExtensionDTO(String extensionId, String name, String version, String description,
                       String publisher, String status, Long downloadCount, Double rating) {
        this.extensionId = extensionId;
        this.name = name;
        this.version = version;
        this.description = description;
        this.publisher = publisher;
        this.status = status;
        this.downloadCount = downloadCount;
        this.rating = rating;
    }

    public String getExtensionId() {
        return extensionId;
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

    public String getStatus() {
        return status;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public Double getRating() {
        return rating;
    }
}

