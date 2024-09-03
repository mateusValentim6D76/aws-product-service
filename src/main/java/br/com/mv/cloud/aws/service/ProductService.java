package br.com.mv.cloud.aws.service;

import br.com.mv.cloud.aws.model.Product;
import br.com.mv.cloud.aws.dto.DataListProductDTO;
import br.com.mv.cloud.aws.dto.ProductCreateDTO;
import br.com.mv.cloud.aws.dto.ProductDTO;
import br.com.mv.cloud.aws.dto.ProductUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);

    Page<DataListProductDTO> findAll(Pageable pageable);

    ProductCreateDTO createProduct(ProductDTO product);

    ProductUpdateDTO updateProduct(ProductUpdateDTO productUpdate, Long id);

    void deleteById(Long id);
}
