package com.colutti.aws_appconfig_sample.controllers;

import com.colutti.aws_appconfig_sample.dtos.request.AppConfigApplicationRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.request.AppConfigConfigurationProfileRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.request.AppConfigEnvironmentRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.request.AppConfigHostedConfigurationVersionRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.response.*;
import com.colutti.aws_appconfig_sample.services.AppConfigControlPlaneService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/appconfig-controlplane")
public class AppConfigControlPlaneController {

    private final AppConfigControlPlaneService appConfigControlPlaneService;

    public AppConfigControlPlaneController(AppConfigControlPlaneService appConfigControlPlaneService) {
        this.appConfigControlPlaneService = appConfigControlPlaneService;
    }

    @PostMapping("/applications")
    public AppConfigApplicationResponseDTO createApplication(
            @RequestBody AppConfigApplicationRequestDTO appRequestDto) throws URISyntaxException {
        return this.appConfigControlPlaneService.createApplication(appRequestDto);
    }

    @GetMapping("/applications/{applicationId}")
    public List<AppConfigListConfigurationProfileResponseDTO> listConfigurationProfiles(
            @PathVariable(name = "applicationId") String applicationId) throws URISyntaxException {
        return this.appConfigControlPlaneService.listConfigurationProfiles(applicationId);
    }

    @PostMapping("/applications/{appId}/environments")
    public AppConfigEnvironmentResponseDTO createEnvironment(
            @PathVariable(name = "appId") String applicationId,
            @RequestBody AppConfigEnvironmentRequestDTO environmentRequestDto) throws URISyntaxException {
        environmentRequestDto.setApplicationId(applicationId);
        return this.appConfigControlPlaneService.createEnvironment(environmentRequestDto);
    }

    @PostMapping("/applications/{appId}/configurations-profiles")
    public AppConfigConfigurationProfileResponseDTO createConfigurationProfile(
            @PathVariable(name = "appId") String applicationId,
            @RequestBody AppConfigConfigurationProfileRequestDTO configProfileRequestDto) throws URISyntaxException {
        configProfileRequestDto.setApplicationId(applicationId);
        return this.appConfigControlPlaneService.createConfigurationProfile(configProfileRequestDto);
    }

    @PostMapping("/applications/{appId}/configurations-profiles/{configurationProfileId}/versions")
    public AppConfigHostedConfigurationVersionResponseDTO createHostedConfigurationVersion(
            @PathVariable(name = "appId") String applicationId,
            @PathVariable(name = "configurationProfileId") String configurationProfileId,
            @RequestBody AppConfigHostedConfigurationVersionRequestDTO hostedConfigRequestDto) throws JsonProcessingException, URISyntaxException {
        hostedConfigRequestDto.setApplicationId(applicationId);
        hostedConfigRequestDto.setConfigurationProfileId(configurationProfileId);
        return this.appConfigControlPlaneService.createHostedConfigurationVersion(hostedConfigRequestDto);
    }
}
