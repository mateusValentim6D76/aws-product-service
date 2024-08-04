package br.com.mv.cloud.aws.dto;


import br.com.mv.cloud.aws.enums.ColorEnum;

import java.math.BigDecimal;


public record ProductEventDTO(Long id, String name, String model, String code, BigDecimal price, ColorEnum color) {

}
