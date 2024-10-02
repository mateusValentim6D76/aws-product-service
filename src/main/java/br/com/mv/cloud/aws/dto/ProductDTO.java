package br.com.mv.cloud.aws.dto;


import br.com.mv.cloud.aws.enums.ColorEnum;
import java.math.BigDecimal;




public record ProductDTO(String productName, String model, String code,  BigDecimal price, ColorEnum color, String username) {

}
