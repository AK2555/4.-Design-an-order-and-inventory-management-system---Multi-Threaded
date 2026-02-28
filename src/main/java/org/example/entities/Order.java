package org.example.entities;

public class Order {
    private final String orderId;
    private String sellerId;
    private String productId;
    private int productQuantity;

    public Order(String orderId, String sellerId, String productId, int productQuantity) {
        this.orderId = orderId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
