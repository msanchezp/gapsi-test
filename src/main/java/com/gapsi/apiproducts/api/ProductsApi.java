package com.gapsi.apiproducts.api;


import com.gapsi.apiproducts.dto.ProductResource;
import com.gapsi.apiproducts.entity.Product;
import com.gapsi.apiproducts.service.ProductService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/products")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJAXRSSpecServerCodegen", date = "2021-06-19T03:50:40.413Z[GMT]")
public class ProductsApi {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{productId}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<?> getProductById(@PathVariable("productId") String productId
) {
        ProductResource productResource = this.productService.get(productId);

        if (productResource == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(productResource, HttpStatus.OK);
    }

    @RequestMapping(value = "/{productId}",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<?> updateProductById(
            @ApiParam(value = "Product", required = true) @Valid @RequestBody ProductResource body,
            @PathVariable("productId") String productId
) {
        Product product = this.productService.updateProduct(productId, body);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }}
