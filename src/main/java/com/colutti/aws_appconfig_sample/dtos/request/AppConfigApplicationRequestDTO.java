package com.colutti.aws_appconfig_sample.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppConfigApplicationRequestDTO {

    @JsonProperty("application_name")
    private String applicationName;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
