package br.com.mv.cloud.aws.service.impl;

import br.com.mv.cloud.aws.model.Product;
import br.com.mv.cloud.aws.model.TopicEnvelope;
import br.com.mv.cloud.aws.dto.ProductEventDTO;
import br.com.mv.cloud.aws.enums.EventTypeInform;
import br.com.mv.cloud.aws.service.ProductPublisher;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.Topic;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductPublisherImpl implements ProductPublisher {

    private final ObjectMapper objectMapper;
    private final Topic productEventTopic;
    private final AmazonSNS snsClient;

    public ProductPublisherImpl(AmazonSNS snsClient, @Qualifier("productEventsTopic") Topic productEventTopic, ObjectMapper objectMapper) {
        this.snsClient = snsClient;
        this.productEventTopic = productEventTopic;
        this.objectMapper = objectMapper;

    }

    @Override
    public void publishProductEvent(Product product, EventTypeInform eventTypeInform, String username) {
        ProductEventDTO productEventDTO = new ProductEventDTO();
        productEventDTO.setCode(product.getCode());
        productEventDTO.setId(product.getId());
        productEventDTO.setName(product.getName());

        TopicEnvelope topicEnvelope = new TopicEnvelope();
        try {
            topicEnvelope.setData(objectMapper.writeValueAsString(productEventDTO));
            PublishResult publishResult = snsClient.publish(productEventTopic.getTopicArn(), objectMapper.writeValueAsString(topicEnvelope));
            log.info("Product event sent: - Event {} - ProductId: {} - MessageId: {}", topicEnvelope.getEventType(),
                    product.getId(),
                    publishResult.getMessageId());

        } catch (JsonProcessingException e) {
            log.error("Failed to create prodyuct event message");
            throw new RuntimeException(e);
        }
    }
}
