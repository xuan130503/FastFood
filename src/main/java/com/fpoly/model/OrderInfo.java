package com.fpoly.model;

import com.fpoly.entity.Order;

public class OrderInfo {
	private Order order;
    private double totalAmount;

    public OrderInfo(Order order, double totalAmount) {
        this.order = order;
        this.totalAmount = totalAmount;
    }

    public Order getOrder() {
        return order;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
