package br.com.mv.cloud.aws.repository;

import br.com.mv.cloud.aws.domain.Product;
import br.com.mv.cloud.aws.dto.DataListProductDTO;
import br.com.mv.cloud.aws.dto.ProductCreateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);

    Optional<DataListProductDTO> findByCode(String code);
}
