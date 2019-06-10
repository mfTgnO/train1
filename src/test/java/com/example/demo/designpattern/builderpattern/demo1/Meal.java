package com.example.demo.designpattern.builderpattern.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: com.example.demo.designpattern.builderpattern.demo1
 * @author:
 * @email:
 * @createDate: 2019-06-10 18:09
 * @description:
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}
