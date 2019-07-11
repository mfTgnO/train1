package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

/**
 * @package: com.example.demo.collections.model
 * @author:
 * @email:
 * @createDate: 2019-06-05 14:28
 * @description:
 */
/*
 * The @JsonManagedReference and @JsonBackReference annotations are used to handle parent/child relationships and work around loops.
 * In the following example – we use @JsonManagedReference and @JsonBackReference to serialize our ItemWithRef entity:
 * */
@Data
public class ItemWithRef {
    public final int id;
    public final String itemName;

    @JsonManagedReference
    public final UserWithRef owner;
}
