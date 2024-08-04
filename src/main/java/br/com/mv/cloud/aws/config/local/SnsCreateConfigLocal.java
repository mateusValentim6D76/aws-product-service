package br.com.mv.cloud.aws.config.local;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.Topic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
@Slf4j
public class SnsCreateConfigLocal {

    private final AmazonSNS snsClient;
    private final String productEventsTopic;

    public SnsCreateConfigLocal(AmazonSNS amazonSNS, String productEventsTopic) {
        this.snsClient = AmazonSNSClient.builder()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("", Regions.US_EAST_1.getName()))
                .withCredentials(new DefaultAWSCredentialsProviderChain()).build();

        String TOPIC_NAME = "product-events";
        CreateTopicRequest createTopicRequest = new CreateTopicRequest(TOPIC_NAME);
        this.productEventsTopic = this.snsClient.createTopic(createTopicRequest).getTopicArn();

        log.info("SNS topic ARN {}" + productEventsTopic);
    }

    @Bean
    public AmazonSNS snsClient() {
        return this.snsClient;
    }

    @Bean(name = "productEventsTopic")
    public Topic snsProductEventsTopic() {
        return new Topic().withTopicArn(productEventsTopic);
    }
}
