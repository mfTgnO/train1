package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.template;

import java.util.function.Consumer;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.template
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-15 10:51
 * @Description:
 */
public class OnlineBankingLambda {
    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1337, (Customer c) -> System.out.println("Hello!"));
    }

    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

    static private class Customer {
    }

    static private class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }
}
