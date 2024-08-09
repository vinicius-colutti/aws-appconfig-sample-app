package com.colutti.aws_appconfig_sample.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class AppConfigGetConfigurationResponseDTO {

    @JsonProperty("value")
    private final JsonNode value;

    public AppConfigGetConfigurationResponseDTO(JsonNode value) {
        this.value = value;
    }

    public JsonNode getValue() {
        return value;
    }
}
