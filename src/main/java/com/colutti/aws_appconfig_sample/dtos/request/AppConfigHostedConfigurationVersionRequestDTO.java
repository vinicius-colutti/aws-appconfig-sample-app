package com.colutti.aws_appconfig_sample.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class AppConfigHostedConfigurationVersionRequestDTO {

    @JsonProperty("application_id")
    private String applicationId;

    @JsonProperty("configuration_profile_id")
    private String configurationProfileId;

    @JsonProperty("new_value")
    private JsonNode newValue;


    public JsonNode getNewValue() {
        return newValue;
    }

    public void setNewValue(JsonNode newValue) {
        this.newValue = newValue;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getConfigurationProfileId() {
        return configurationProfileId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public void setConfigurationProfileId(String configurationProfileId) {
        this.configurationProfileId = configurationProfileId;
    }
}
