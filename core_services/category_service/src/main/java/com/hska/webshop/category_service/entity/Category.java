package com.hska.webshop.category_service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;


@Entity
public class Category extends com.hska.webshop.category_service.api.model.Category {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer category_id = null;

    @Override
    public Integer getId() {
        return this.category_id;
    }
}
