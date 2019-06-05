package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @package: com.example.demo.collections.domain
 * @author:
 * @email:
 * @createDate: 2019-06-05 10:58
 * @description:
 */
@Data
@AllArgsConstructor
public class Item {

    /*
     * @JsonView is used to indicate the View in which the property will be included for serialization/deserialization.
     * An example will show exactly how that works – we’ll use @JsonView to serialize an instance of Item entity.
     * */
    @JsonView(Views.Public.class)
    public int id;

    @JsonView(Views.Public.class)
    public String itemName;

    @JsonView(Views.Internal.class)
    public String ownerName;
}
