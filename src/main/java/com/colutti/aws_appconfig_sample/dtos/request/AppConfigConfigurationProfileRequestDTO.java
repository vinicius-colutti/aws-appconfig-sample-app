package com.colutti.aws_appconfig_sample.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppConfigConfigurationProfileRequestDTO {

    @JsonProperty("application_id")
    private String applicationId;

    @JsonProperty("configuration_profile_name")
    private String configurationProfileName;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getConfigurationProfileName() {
        return configurationProfileName;
    }

    public void setConfigurationProfileName(String configurationProfileName) {
        this.configurationProfileName = configurationProfileName;
    }
}
