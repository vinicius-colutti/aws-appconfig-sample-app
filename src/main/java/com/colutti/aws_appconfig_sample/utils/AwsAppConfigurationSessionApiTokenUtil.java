package com.colutti.aws_appconfig_sample.utils;

import com.colutti.aws_appconfig_sample.dtos.request.AppConfigGetConfigurationRequestDTO;
import software.amazon.awssdk.services.appconfigdata.AppConfigDataClient;
import software.amazon.awssdk.services.appconfigdata.model.StartConfigurationSessionResponse;

public class AwsAppConfigurationSessionApiTokenUtil {

    public static String getSessionToken(AppConfigDataClient appConfigDataClient, AppConfigGetConfigurationRequestDTO getConfigRequestDto){
        StartConfigurationSessionResponse session =
                appConfigDataClient.startConfigurationSession(req -> req
                        .applicationIdentifier(getConfigRequestDto.getApplicationName())
                        .configurationProfileIdentifier(getConfigRequestDto.getConfigurationProfileName())
                        .environmentIdentifier(getConfigRequestDto.getEnvironmentName()));
        return session.initialConfigurationToken();
    }
}
