package com.example.demo.collections.domain;

/**
 * @package: com.example.demo.collections.model
 * @author:
 * @email:
 * @createDate: 2019-06-05 15:28
 * @description:
 */
public class ItemWithMixIn {
    public int id;
    public String itemName;
    public User owner;

    public ItemWithMixIn(int id, String itemName, User owner) {
        this.id = id;
        this.itemName = itemName;
        this.owner = owner;
    }
}
