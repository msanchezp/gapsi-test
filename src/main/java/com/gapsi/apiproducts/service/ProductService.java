package com.gapsi.apiproducts.service;

import com.gapsi.apiproducts.dto.ProductResource;
import com.gapsi.apiproducts.entity.Product;
import com.gapsi.apiproducts.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductResource get(String id) {
        log.info("finding product with id: {}", id);

        Product product = this.getById(id);

        if (product == null) {
            log.info("product not found");
            return null;
        }

        return this.convertToDTO(product);
    }

    public Product updateProduct(String id, ProductResource productResource) {
        log.info("updating product with id: {}", id);

        Product product = this.getById(id);

        if (product == null) {
            log.info("product not found");
            return null;
        }

        this.saveProduct(product, productResource);

        return product;
    }

    private Product getById(String id) {
        return this.productRepository.findById(id).orElse(null);
    }

    private ProductResource convertToDTO(Product product) {
        ProductResource productResource = new ProductResource();
        productResource.setId(product.getId());
        productResource.setName(product.getName());
        productResource.setDescription(product.getDescription());
        productResource.setPrice(new BigDecimal(product.getPrice()));
        productResource.setPrice(productResource.getPrice().setScale(2, RoundingMode.DOWN));
        productResource.setModel(product.getModel());

        return productResource;
    }

    private void saveProduct(Product product, ProductResource productResource) {
        product.setDescription(productResource.getDescription());
        product.setModel(productResource.getModel());

        this.productRepository.save(product);
    }
}
