package com.colutti.aws_appconfig_sample.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppConfigConfigurationProfileResponseDTO {

    @JsonProperty("configuration_profile_id")
    private String configurationProfileId;

    public AppConfigConfigurationProfileResponseDTO(String configurationProfileId) {
        this.configurationProfileId = configurationProfileId;
    }

    public String getConfigurationProfileId() {
        return configurationProfileId;
    }
}
