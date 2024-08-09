package com.colutti.aws_appconfig_sample.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.appconfig.AppConfigClient;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class AppConfigClientConfiguration {

    @Value("${localstack.access_key_id}")
    private String localstackAccessKeyId;

    @Value("${localstack.secret_access_key}")
    private String localstackSecretKeyId;

    @Value("${localstack.url}")
    private String localstackUrl;

    @Bean
    public AppConfigClient appConfigClient() throws URISyntaxException {
        return AppConfigClient.builder()
                .endpointOverride(new URI(localstackUrl))
                .credentialsProvider(StaticCredentialsProvider
                        .create(AwsBasicCredentials
                                .create(localstackAccessKeyId, localstackSecretKeyId)))
                .region(Region.US_EAST_1)
                .build();
    }
}
