package br.com.mv.cloud.aws.service;

import br.com.mv.cloud.aws.domain.Product;
import br.com.mv.cloud.aws.dto.DataListProductDTO;
import br.com.mv.cloud.aws.dto.ProductCreateDTO;
import br.com.mv.cloud.aws.dto.ProductDTO;
import br.com.mv.cloud.aws.dto.ProductUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    Optional<Product> findById(Long id);

    Page<DataListProductDTO> findAll(Pageable pageable);

    ProductCreateDTO createProduct(ProductDTO product);

    ProductCreateDTO updateProduct(ProductUpdateDTO productUpdate);

}
