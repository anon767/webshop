package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * Category
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T09:48:47.669952+01:00[Europe/Berlin]")
@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 3112775006335009399L;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Category name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @ApiModelProperty(example = "Pets", required = true, value = "")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category id(Integer id) {
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


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Category category = (Category) o;
        return Objects.equals(this.name, category.name) &&
                Objects.equals(this.id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Category {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

