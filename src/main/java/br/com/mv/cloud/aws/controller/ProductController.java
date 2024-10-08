package br.com.mv.cloud.aws.controller;

import br.com.mv.cloud.aws.dto.ProductUpdateDTO;
import br.com.mv.cloud.aws.model.Product;
import br.com.mv.cloud.aws.dto.ProductCreateDTO;
import br.com.mv.cloud.aws.dto.ProductDTO;
import br.com.mv.cloud.aws.exception.ErrorCreateProductException;
import br.com.mv.cloud.aws.service.ProductService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        var productOptional = productService.findById(id);
        return productOptional.map(product -> new ResponseEntity<>(product, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Page<?>> findAll(@PageableDefault(size = 10, sort = {"productName", "model"}) Pageable pageable) {
        var pageProducts = productService.findAll(pageable);
        return ResponseEntity.ok(pageProducts);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody ProductDTO productDTO) {
        try {
            System.out.println("Received ProductDTO: " + productDTO);
            ProductCreateDTO createProduct = productService.createProduct(productDTO);
            return ResponseEntity.ok(createProduct);
        } catch (ErrorCreateProductException e) {
            throw e;
        }
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@Valid @RequestBody ProductUpdateDTO productUpdateDTO, @PathVariable("id") Long id) {
        try {
            System.out.println("Received ProductDTO: " + productUpdateDTO);
            ProductUpdateDTO updateProduct = productService.updateProduct(productUpdateDTO, id);
            return ResponseEntity.ok(updateProduct);
        } catch (ErrorCreateProductException e) {
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            productService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}