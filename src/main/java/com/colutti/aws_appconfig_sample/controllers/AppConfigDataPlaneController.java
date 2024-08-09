package com.colutti.aws_appconfig_sample.controllers;

import com.colutti.aws_appconfig_sample.dtos.request.AppConfigGetConfigurationRequestDTO;
import com.colutti.aws_appconfig_sample.dtos.response.AppConfigGetConfigurationResponseDTO;
import com.colutti.aws_appconfig_sample.services.AppConfigDataPlaneService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appconfig-dataplane")
public class AppConfigDataPlaneController {

    private final AppConfigDataPlaneService appConfigDataPlaneService;

    public AppConfigDataPlaneController(AppConfigDataPlaneService appConfigDataPlaneService) {
        this.appConfigDataPlaneService = appConfigDataPlaneService;
    }

    @GetMapping("/applications/{applicationName}/environments/{environmentName}/configurations-profiles/{configurationProfileName}")
    public AppConfigGetConfigurationResponseDTO getConfiguration(
            @PathVariable(name = "applicationName") String applicationName,
            @PathVariable(name = "environmentName") String environmentName,
            @PathVariable(name = "configurationProfileName") String configurationProfileName) throws JsonProcessingException {
        AppConfigGetConfigurationRequestDTO getConfigurationRequestDTO = new AppConfigGetConfigurationRequestDTO();
        getConfigurationRequestDTO.setApplicationName(applicationName);
        getConfigurationRequestDTO.setEnvironmentName(environmentName);
        getConfigurationRequestDTO.setConfigurationProfileName(configurationProfileName);
        return this.appConfigDataPlaneService.getConfiguration(getConfigurationRequestDTO);
    }
}
