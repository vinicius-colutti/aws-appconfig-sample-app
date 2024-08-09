package com.colutti.aws_appconfig_sample.services;

import com.colutti.aws_appconfig_sample.dtos.request.AppConfigApplicationRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.request.AppConfigConfigurationProfileRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.request.AppConfigEnvironmentRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.request.AppConfigHostedConfigurationVersionRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.response.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;

/**
 * Interface to communicate with AppConfig Control Plane APIs.
 * docs: https://docs.aws.amazon.com/appconfig/2019-10-09/APIReference/API_Operations_Amazon_AppConfig.html
 */
public interface AppConfigControlPlaneService {

    AppConfigApplicationResponseDTO createApplication(AppConfigApplicationRequestDTO appRequestDto);
    AppConfigEnvironmentResponseDTO createEnvironment(AppConfigEnvironmentRequestDTO environmentRequestDTO);
    AppConfigConfigurationProfileResponseDTO createConfigurationProfile(AppConfigConfigurationProfileRequestDTO configProfileRequestDto);
    AppConfigHostedConfigurationVersionResponseDTO createHostedConfigurationVersion(AppConfigHostedConfigurationVersionRequestDTO hostedConfigRequestDto) throws JsonProcessingException;
    List<AppConfigListConfigurationProfileResponseDTO> listConfigurationProfiles(String applicationId);
}
