package br.com.mv.cloud.aws.dto;

import br.com.mv.cloud.aws.model.Manufacturer;
import br.com.mv.cloud.aws.enums.ColorEnum;

import java.math.BigDecimal;

public record ProductUpdateDTO (String name, String model, BigDecimal price, ColorEnum color, Manufacturer manufacturer){
}
