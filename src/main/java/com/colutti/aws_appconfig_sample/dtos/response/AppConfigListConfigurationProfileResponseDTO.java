package com.colutti.aws_appconfig_sample.dtos.response;

import java.util.List;

public class AppConfigListConfigurationProfileResponseDTO {

    private final String applicationId;
    private final String id;
    private final String name;
    private final String locationUri;
    private final List<String> validatorTypes;
    private final String type;

    public AppConfigListConfigurationProfileResponseDTO(String applicationId, String id, String name, String locationUri, List<String> validatorTypes, String type) {
        this.applicationId = applicationId;
        this.id = id;
        this.name = name;
        this.locationUri = locationUri;
        this.validatorTypes = validatorTypes;
        this.type = type;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocationUri() {
        return locationUri;
    }

    public List<String> getValidatorTypes() {
        return validatorTypes;
    }

    public String getType() {
        return type;
    }
}
