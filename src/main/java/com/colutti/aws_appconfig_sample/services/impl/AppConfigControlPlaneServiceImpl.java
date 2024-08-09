package com.colutti.aws_appconfig_sample.services.impl;

import com.colutti.aws_appconfig_sample.dtos.request.AppConfigApplicationRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.request.AppConfigConfigurationProfileRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.request.AppConfigEnvironmentRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.request.AppConfigHostedConfigurationVersionRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.response.*;
import com.colutti.aws_appconfig_sample.services.AppConfigControlPlaneService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.appconfig.AppConfigClient;
import software.amazon.awssdk.services.appconfig.model.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppConfigControlPlaneServiceImpl implements AppConfigControlPlaneService {

    private final AppConfigClient appConfigClient;
    private final ObjectMapper objectMapper;
    private static final String APPLICATION_JSON_CONTENT_TYPE_VALUE = "application/json";
    private static final String CONFIGURATION_PROFILE_HOSTED_VALUE = "hosted";
    private static final String CONFIGURATION_PROFILE_TYPE_VALUE = "AWS.Freeform";

    public AppConfigControlPlaneServiceImpl(AppConfigClient appConfigClient) {
        this.appConfigClient = appConfigClient;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public AppConfigApplicationResponseDTO createApplication(AppConfigApplicationRequestDTO appRequestDto) {
        CreateApplicationRequest createApplicationRequest = CreateApplicationRequest
                .builder()
                .name(appRequestDto.getApplicationName())
                .build();
        CreateApplicationResponse createApplicationResponse = appConfigClient
                .createApplication(createApplicationRequest);
        return new AppConfigApplicationResponseDTO(createApplicationResponse.id());
    }

    @Override
    public AppConfigEnvironmentResponseDTO createEnvironment(AppConfigEnvironmentRequestDTO appEnvironmentDto) {
        CreateEnvironmentRequest createEnvironmentRequest = CreateEnvironmentRequest
                .builder()
                .name(appEnvironmentDto.getEnvironmentName())
                .applicationId(appEnvironmentDto.getApplicationId())
                .build();
        CreateEnvironmentResponse createEnvironmentResponse = appConfigClient
                .createEnvironment(createEnvironmentRequest);
        return new AppConfigEnvironmentResponseDTO(createEnvironmentResponse.id());
    }

    @Override
    public AppConfigConfigurationProfileResponseDTO createConfigurationProfile(AppConfigConfigurationProfileRequestDTO configProfileRequestDto) {
        CreateConfigurationProfileRequest profileRequest = CreateConfigurationProfileRequest
                .builder()
                .name(configProfileRequestDto.getConfigurationProfileName())
                .applicationId(configProfileRequestDto.getApplicationId())
                .locationUri(CONFIGURATION_PROFILE_HOSTED_VALUE)
                .type(CONFIGURATION_PROFILE_TYPE_VALUE)
                .build();
        CreateConfigurationProfileResponse profileResponse = appConfigClient
                .createConfigurationProfile(profileRequest);
        return new AppConfigConfigurationProfileResponseDTO(profileResponse.id());
    }

    @Override
    public AppConfigHostedConfigurationVersionResponseDTO createHostedConfigurationVersion(AppConfigHostedConfigurationVersionRequestDTO hostedConfigRequestDto) throws JsonProcessingException {
        CreateHostedConfigurationVersionRequest versionRequest = CreateHostedConfigurationVersionRequest
                .builder()
                .applicationId(hostedConfigRequestDto.getApplicationId())
                .configurationProfileId(hostedConfigRequestDto.getConfigurationProfileId())
                .contentType(APPLICATION_JSON_CONTENT_TYPE_VALUE)
                .content(SdkBytes.fromUtf8String(
                        this.objectMapper
                                .writeValueAsString(hostedConfigRequestDto.getNewValue())
                ))
                .build();
        CreateHostedConfigurationVersionResponse versionResponse = appConfigClient
                .createHostedConfigurationVersion(versionRequest);
        return new AppConfigHostedConfigurationVersionResponseDTO(versionResponse.versionNumber().toString());
    }

    @Override
    public List<AppConfigListConfigurationProfileResponseDTO> listConfigurationProfiles(String applicationId) {
        ListConfigurationProfilesRequest listConfigurationProfilesRequest = ListConfigurationProfilesRequest
                .builder()
                .applicationId(applicationId)
                .build();
        ListConfigurationProfilesResponse listConfigurationProfilesResponse = appConfigClient
                .listConfigurationProfiles(listConfigurationProfilesRequest);
        return listConfigurationProfilesResponse
                .items().stream()
                .map(profile -> new AppConfigListConfigurationProfileResponseDTO(
                        profile.applicationId(),
                        profile.id(),
                        profile.name(),
                        profile.locationUri(),
                        profile.validatorTypesAsStrings(),
                        profile.type()
                ))
                .collect(Collectors.toList());
    }
}
