package com.colutti.aws_appconfig_sample.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppConfigGetConfigurationRequestDTO {

    @JsonProperty("application_name")
    private String applicationName;

    @JsonProperty("environment_name")
    private String environmentName;

    @JsonProperty("configuration_profile_name")
    private String configurationProfileName;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public String getConfigurationProfileName() {
        return configurationProfileName;
    }

    public void setConfigurationProfileName(String configurationProfileName) {
        this.configurationProfileName = configurationProfileName;
    }
}
