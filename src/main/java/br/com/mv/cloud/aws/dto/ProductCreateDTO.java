package br.com.mv.cloud.aws.dto;

import br.com.mv.cloud.aws.domain.Manufacturer;
import br.com.mv.cloud.aws.enums.ColorEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProductCreateDTO(Long id, String name, String model, String code, BigDecimal price, ColorEnum color, LocalDateTime createdAt) {
}
