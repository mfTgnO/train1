package com.example.demo.foundation;

public class StaticKeyDemo {
    private int orderId = 1000;
    private String orderName;

    //初始化块
    static {
        System.out.println("我是静态代码块");
    }

    {
        orderId = 1001;
        orderName = "AA";
        System.out.println("我是非静态代码块1");
    }

    {
        orderId = 1002;
        orderName = "BB";
        System.out.println("我是非静态代码块2");
    }

    public StaticKeyDemo() {
    }

    public StaticKeyDemo(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderName=" + orderName + "]";
    }
}
