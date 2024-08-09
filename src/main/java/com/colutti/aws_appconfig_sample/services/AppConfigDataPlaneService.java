package com.colutti.aws_appconfig_sample.services;

import com.colutti.aws_appconfig_sample.dtos.request.AppConfigGetConfigurationRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.response.AppConfigGetConfigurationResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Interface to communicate with AppConfig Data Plane APIs.
 * docs: https://docs.aws.amazon.com/appconfig/2019-10-09/APIReference/API_Operations_AWS_AppConfig_Data.html
 */
public interface AppConfigDataPlaneService {

    AppConfigGetConfigurationResponseDTO getConfiguration(AppConfigGetConfigurationRequestDTO getConfigRequestDto) throws JsonProcessingException;
}
