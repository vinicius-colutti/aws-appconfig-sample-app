package com.colutti.aws_appconfig_sample.services.impl;

import com.colutti.aws_appconfig_sample.dtos.request.AppConfigGetConfigurationRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.response.AppConfigGetConfigurationResponseDTO;
import com.colutti.aws_appconfig_sample.services.AppConfigDataPlaneService;
import com.colutti.aws_appconfig_sample.utils.AwsAppConfigurationSessionApiTokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.appconfigdata.AppConfigDataClient;
import software.amazon.awssdk.services.appconfigdata.model.GetLatestConfigurationRequest;
import software.amazon.awssdk.services.appconfigdata.model.GetLatestConfigurationResponse;

@Service
public class AppConfigDataPlaneServiceAWSApi implements AppConfigDataPlaneService {

    private final AppConfigDataClient appConfigDataClient;
    private final ObjectMapper objectMapper;

    public AppConfigDataPlaneServiceAWSApi(AppConfigDataClient appConfigDataClient) {
        this.appConfigDataClient = appConfigDataClient;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public AppConfigGetConfigurationResponseDTO getConfiguration(AppConfigGetConfigurationRequestDTO getConfigRequestDto) throws JsonProcessingException {
        GetLatestConfigurationResponse configuration =
                appConfigDataClient.getLatestConfiguration(GetLatestConfigurationRequest
                        .builder()
                        .configurationToken(
                                AwsAppConfigurationSessionApiTokenUtil
                                        .getSessionToken(appConfigDataClient,
                                                getConfigRequestDto)
                        )
                        .build());
        return new AppConfigGetConfigurationResponseDTO(
                this.objectMapper.readTree(configuration.configuration().asUtf8String())
        );
    }
}
