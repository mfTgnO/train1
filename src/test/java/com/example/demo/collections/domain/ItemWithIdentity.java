package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @package: com.example.demo.collections.domain
 * @author:
 * @email:
 * @createDate: 2019-06-05 14:43
 * @description:
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ItemWithIdentity {
    public int id;
    public String itemName;
    public UserWithIdentity owner;

    public ItemWithIdentity() {
    }

    public ItemWithIdentity(int id, String itemName, UserWithIdentity owner) {
        this.id = id;
        this.itemName = itemName;
        this.owner = owner;
    }
}
