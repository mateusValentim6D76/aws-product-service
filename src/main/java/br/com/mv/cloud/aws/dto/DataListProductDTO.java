package br.com.mv.cloud.aws.dto;

import br.com.mv.cloud.aws.model.Product;
import br.com.mv.cloud.aws.enums.ColorEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DataListProductDTO(Long id, String name, String model, String code, BigDecimal price, ColorEnum color,
                                 List<ManufactureDTO> manufacturer, LocalDateTime createdAt) {

    public DataListProductDTO(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getModel(),
                product.getCode(),
                product.getPrice(),
                product.getColor(),
                product.getManufacturer().stream()
                        .map(manufacture -> new ManufactureDTO(manufacture.getId(), manufacture.getManufacturerName()))
                        .collect(Collectors.toList()),
                product.getCreatedAt()
        );
    }
}
