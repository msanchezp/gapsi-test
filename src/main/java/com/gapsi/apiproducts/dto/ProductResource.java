package com.gapsi.apiproducts.dto;

import java.math.BigDecimal;
import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ProductResource {

    private @Valid String id = null;

    private @Valid String name = null;

    private @Valid String description = null;

    private @Valid BigDecimal price = null;

    private @Valid String model = null;

    public ProductResource id(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("id")
    @Size(min=10,max=10)
    public String getId() {
    return id;
  }
    public void setId(String id) {
    this.id = id;
  }

    public ProductResource name(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("name")
    @Size(max=20)
    public String getName() {
    return name;
  }
    public void setName(String name) {
    this.name = name;
  }

    public ProductResource description(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("description")
    @NotNull
    @Size(max=200)
    public String getDescription() {
    return description;
  }
    public void setDescription(String description) {
    this.description = description;
  }

    public ProductResource price(BigDecimal price) {
        this.price = price;
        return this;
    }

    @JsonProperty("price")
    public BigDecimal getPrice() {
    return price;
  }
    public void setPrice(BigDecimal price) {
    this.price = price;
  }

    public ProductResource model(String model) {
        this.model = model;
        return this;
    }

    @JsonProperty("model")
    @NotNull
    @Size(max=10)
    public String getModel() {
    return model;
  }
    public void setModel(String model) {
    this.model = model;
  }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }


        ProductResource productResource = (ProductResource) o;
        return Objects.equals(id, productResource.id) &&
                Objects.equals(name, productResource.name) &&
                Objects.equals(description, productResource.description) &&
                Objects.equals(price, productResource.price) &&
                Objects.equals(model, productResource.model);
    }

    @Override
    public int hashCode() {
    return Objects.hash(id, name, description, price, model);
  }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductResource {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    model: ").append(toIndentedString(model)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
