package model;

import java.util.Date;

public class OrderManagement {
    private int orderId;
    private String paymentMethod;
    private Date orderDate;
    private Date deliveryDate;
    private String addressOrder;
    private int customerId;
    private String personnelId;

    public OrderManagement() {}

    public OrderManagement(int orderId, String paymentMethod, Date orderDate,
                           Date deliveryDate, String addressOrder, int customerId,
                           String personnelId) {
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.addressOrder = addressOrder;
        this.customerId = customerId;
        this.personnelId = personnelId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getAddressOrder() {
        return addressOrder;
    }

    public void setAddressOrder(String addressOrder) {
        this.addressOrder = addressOrder;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(String personnelId) {
        this.personnelId = personnelId;
    }}