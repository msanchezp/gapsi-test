package com.gapsi.apiproducts.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@javax.persistence.Entity
@Data
@Table(name = "products")
public class Product implements Serializable {
    @Schema( accessMode = Schema.AccessMode.READ_ONLY )
    @Id
    @Column(name = "id", updatable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "model")
    private String model;
}
