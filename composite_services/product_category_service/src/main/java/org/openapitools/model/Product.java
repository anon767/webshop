package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Product
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T10:01:22.748495+01:00[Europe/Berlin]")

public class Product {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("details")
    private String details;

    @JsonProperty("category")
    private String category;

    public Product id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @ApiModelProperty(example = "0", required = true, value = "")
    @NotNull


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @ApiModelProperty(example = "Cat", value = "")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product price(BigDecimal price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     *
     * @return price
     */
    @ApiModelProperty(example = "50", value = "")

    @Valid

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product details(String details) {
        this.details = details;
        return this;
    }

    /**
     * Get details
     *
     * @return details
     */
    @ApiModelProperty(example = "fluffy pet", value = "")


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Product category(String category) {
        this.category = category;
        return this;
    }

    /**
     * Get category
     *
     * @return category
     */
    @ApiModelProperty(example = "Pet", value = "")


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(this.id, product.id) &&
                Objects.equals(this.name, product.name) &&
                Objects.equals(this.price, product.price) &&
                Objects.equals(this.details, product.details) &&
                Objects.equals(this.category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, details, category);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Product {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

