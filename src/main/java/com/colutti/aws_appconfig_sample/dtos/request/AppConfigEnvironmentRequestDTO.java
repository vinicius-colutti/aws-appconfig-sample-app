package com.colutti.aws_appconfig_sample.dtos.request;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AppConfigEnvironmentRequestDTO {

    @JsonProperty("application_id")
    private String applicationId;

    @JsonProperty("environment_name")
    private String environmentName;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }
}
