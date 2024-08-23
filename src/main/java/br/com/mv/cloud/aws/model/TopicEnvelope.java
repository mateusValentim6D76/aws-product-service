package br.com.mv.cloud.aws.model;

import br.com.mv.cloud.aws.enums.EventTypeInform;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicEnvelope {

    private EventTypeInform eventType;
    private String data;
}
