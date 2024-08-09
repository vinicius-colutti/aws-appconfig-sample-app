package com.colutti.aws_appconfig_sample.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppConfigApplicationResponseDTO {

    @JsonProperty("application_id")
    private String applicationId;

    public AppConfigApplicationResponseDTO(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationId() {
        return applicationId;
    }
}
