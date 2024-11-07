package br.com.mv.cloud.aws.service.impl;

import br.com.mv.cloud.aws.model.Product;
import br.com.mv.cloud.aws.dto.DataListProductDTO;
import br.com.mv.cloud.aws.dto.ProductCreateDTO;
import br.com.mv.cloud.aws.dto.ProductDTO;
import br.com.mv.cloud.aws.dto.ProductUpdateDTO;
import br.com.mv.cloud.aws.enums.EventTypeInform;
import br.com.mv.cloud.aws.exception.ErrorCreateProductException;
import br.com.mv.cloud.aws.repository.ProductRepository;
import br.com.mv.cloud.aws.service.ProductPublisher;
import br.com.mv.cloud.aws.service.ProductService;
import com.amazonaws.services.sns.model.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements ProductService {

    private static final BigDecimal MIN_VALUE = new BigDecimal("1.99");
    private final ProductRepository repository;
    private final ModelMapper modelMapper;
    private final ProductPublisher productPublisher;

    @Autowired
    public ProductServiceImpl(ProductRepository repository, ModelMapper modelMapper, ProductPublisher productPublisher) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.productPublisher = productPublisher;
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<DataListProductDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(DataListProductDTO::new);
    }

    @Override
    public ProductCreateDTO createProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        boolean isValidPrice = Stream.of(productDTO.price()).allMatch(price -> price.compareTo(MIN_VALUE) >= 0);
        if (!isValidPrice) {
            throw new ErrorCreateProductException("O valor deve ser maior ou igual a: " + MIN_VALUE);
        }
        product = repository.save(product);
        productPublisher.publishProductEvent(product, EventTypeInform.PRODUCT_CREATE, product.getUsername());

        return modelMapper.map(product, ProductCreateDTO.class);
    }

    @Override
    public ProductUpdateDTO updateProduct(ProductUpdateDTO productUpdate, Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            Product existingProduct = product.get();
            existingProduct.setProductName(productUpdate.getProductName());
            existingProduct.setColor(productUpdate.getColor());
            existingProduct.setModel(productUpdate.getModel());
            existingProduct.setPrice(productUpdate.getPrice());
            existingProduct.setUsername(productUpdate.getUsername());

            Product updatedProduct = repository.save(existingProduct);

            productPublisher.publishProductEvent(updatedProduct, EventTypeInform.PRODUCT_UPDATE, updatedProduct.getUsername());
            return modelMapper.map(updatedProduct, ProductUpdateDTO.class);
        } else {
            throw new ResourceNotFoundException("Resource not found by id: " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<Product> userID = repository.findById(id);
        if (userID.isPresent()) {
            Product product = userID.get();
            repository.deleteById(id);
            productPublisher.publishProductEvent(product, EventTypeInform.PRODUCT_DELETE, product.getUsername());

        } else {
            throw new ResourceNotFoundException("ID não encontrado: " + id);
        }
    }
}