package com.colutti.aws_appconfig_sample.builder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.appconfig.AppConfigClient;
import software.amazon.awssdk.services.sts.StsClient;
import software.amazon.awssdk.services.sts.model.AssumeRoleRequest;
import software.amazon.awssdk.services.sts.model.AssumeRoleResponse;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Component
public class AppConfigClientWithSessionBuilder {

    @Value("${localstack.url}")
    private String localstackUrl;

    public AppConfigClient build(Region region, String roleArn) throws URISyntaxException {
        StsClient stsClient = StsClient.builder()
                .region(region)
                .endpointOverride(new URI(localstackUrl)).build();

        AssumeRoleRequest roleRequest = AssumeRoleRequest.builder()
                .roleArn(roleArn)
                .roleSessionName(UUID.randomUUID().toString())
                .build();
        AssumeRoleResponse roleResponse = stsClient.assumeRole(roleRequest);
        AwsSessionCredentials sessionCredentials = AwsSessionCredentials.create(
                roleResponse.credentials().accessKeyId(),
                roleResponse.credentials().secretAccessKey(),
                roleResponse.credentials().sessionToken()
        );
        return AppConfigClient.builder()
                .endpointOverride(new URI(localstackUrl))
                .credentialsProvider(StaticCredentialsProvider.create(sessionCredentials))
                .region(region)
                .build();
    }
}
