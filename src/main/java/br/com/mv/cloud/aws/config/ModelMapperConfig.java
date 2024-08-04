package br.com.mv.cloud.aws.config;

import br.com.mv.cloud.aws.domain.Product;
import br.com.mv.cloud.aws.dto.ProductCreateDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        // Configuração personalizada para ProductCreateDTO
        Converter<Product, ProductCreateDTO> productToProductCreateDTOConverter = new Converter<Product, ProductCreateDTO>() {
            @Override
            public ProductCreateDTO convert(MappingContext<Product, ProductCreateDTO> context) {
                Product source = context.getSource();
                return new ProductCreateDTO(
                        source.getId(),
                        source.getName(),
                        source.getModel(),
                        source.getCode(),
                        source.getPrice(),
                        source.getColor(),
                        source.getCreatedAt()
                );
            }
        };

        //A partir daqui posso criar outros converters para outros DTOs se necessario

        modelMapper.addConverter(productToProductCreateDTOConverter);
        return modelMapper;
    }
}
