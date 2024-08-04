package br.com.mv.cloud.aws.dto;

import br.com.mv.cloud.aws.domain.Manufacturer;

public record ManufactureDTO(Long id, String manufactureName) {

    public ManufactureDTO(Manufacturer manufacturer) {
        this(manufacturer.getId(), manufacturer.getManufacturerName());
    }
}
