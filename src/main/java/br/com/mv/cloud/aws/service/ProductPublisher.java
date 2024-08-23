package br.com.mv.cloud.aws.service;

import br.com.mv.cloud.aws.model.Product;
import br.com.mv.cloud.aws.enums.EventTypeInform;

public interface ProductPublisher {

    void publishProductEvent(Product product, EventTypeInform eventTypeInform, String username);
}
