package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * @package: com.example.demo.model
 * @author:
 * @email:
 * @createDate: 2019-07-17 16:53
 * @description:
 */
@Data
//@AllArgsConstructor
@SolrDocument(collection = "gettingstarted")
public class Product implements Serializable {
    @Id
    @Indexed(name = "id", type = "string")
    private String id;

    @Indexed(name = "name", type = "string")
      private String name;

    public Product() {
    }

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
