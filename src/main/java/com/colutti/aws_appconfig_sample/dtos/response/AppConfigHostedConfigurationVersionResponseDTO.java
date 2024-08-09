package com.colutti.aws_appconfig_sample.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppConfigHostedConfigurationVersionResponseDTO {

    @JsonProperty("hosted_configuration_version")
    private String hostedConfigurationVersion;

    public AppConfigHostedConfigurationVersionResponseDTO(String hostedConfigurationVersion) {
        this.hostedConfigurationVersion = hostedConfigurationVersion;
    }

    public String getHostedConfigurationVersion() {
        return hostedConfigurationVersion;
    }
}
