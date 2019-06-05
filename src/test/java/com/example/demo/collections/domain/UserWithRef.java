package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: com.example.demo.collections.domain
 * @author:
 * @email:
 * @createDate: 2019-06-05 14:29
 * @description:
 */
/*
 * The @JsonManagedReference and @JsonBackReference annotations are used to handle parent/child relationships and work around loops.
 * In the following example – we use @JsonManagedReference and @JsonBackReference to serialize our ItemWithRef entity:
 * */
@Data
public class UserWithRef {
    public int id;
    public String name;

    @JsonBackReference
    public List<ItemWithRef> userItems;

    public UserWithRef(int id, String name) {
        this.id = id;
        this.name = name;
        userItems = new ArrayList<>();
    }

    public void addItem(ItemWithRef itemWithRef) {
        userItems.add(itemWithRef);
    }
}
