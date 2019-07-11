package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: com.example.demo.collections.model
 * @author:
 * @email:
 * @createDate: 2019-06-05 14:43
 * @description:
 */
/*
*
* */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserWithIdentity {
    public int id;
    public String name;
    public List<ItemWithIdentity> userItems;

    public UserWithIdentity() {
    }

    public UserWithIdentity(int id, String name) {
        this.id = id;
        this.name = name;
        this.userItems = new ArrayList<>();
    }

    public void addItem(ItemWithIdentity itemWithIdentity) {
        userItems.add(itemWithIdentity);
    }
}
