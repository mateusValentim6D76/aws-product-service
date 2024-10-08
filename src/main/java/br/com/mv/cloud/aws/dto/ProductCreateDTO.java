package br.com.mv.cloud.aws.dto;

import br.com.mv.cloud.aws.enums.ColorEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductCreateDTO(Long id, String productName, String model, String code, BigDecimal price, ColorEnum color, LocalDateTime createdAt) {
}
