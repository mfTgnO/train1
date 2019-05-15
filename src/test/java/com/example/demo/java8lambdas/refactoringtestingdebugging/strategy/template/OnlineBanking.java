package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.template;


/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-14 17:55
 * @Description:
 */

/*
 * The processCustomer method provides a sketch for the online banking algorithm: fetch the
 * customer given its ID and then make the customer happy. Different branches can now provide
 * different implementations of the method makeCustomerHappy by subclassing the
 * OnlineBanking class.
 * */
abstract class OnlineBanking {
    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);

    // dummy Customer class
    static private class Customer {
    }

    // dummy Database class
    static private class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }
}