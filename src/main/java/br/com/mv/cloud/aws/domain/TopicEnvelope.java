package br.com.mv.cloud.aws.domain;

import br.com.mv.cloud.aws.enums.EventTypeInform;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicEnvelope {

    private EventTypeInform eventType;
    private String data;
}
