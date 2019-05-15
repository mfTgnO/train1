package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.factory
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-15 16:42
 * @Description:
 */
public class ProductFactory {
    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public Product createProduct(String name) {
        switch (name) {
            case "loan":
                return new Loan();
            case "stock":
                return new Stock();
            case "bond":
                return new Bond();
            default:
                throw new RuntimeException("No such product " + name);
        }
    }

    public Product createProductLambda(String name) {
        Supplier<Product> p = map.get(name);
        if (p != null) {
            return p.get();
        }
        throw new RuntimeException("No such product " + name);
    }
}
