package com.colutti.aws_appconfig_sample.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppConfigEnvironmentResponseDTO {

    @JsonProperty("environment_id")
    private String environmentId;

    public AppConfigEnvironmentResponseDTO(String environmentId) {
        this.environmentId = environmentId;
    }

    public String getEnvironmentId() {
        return environmentId;
    }
}
