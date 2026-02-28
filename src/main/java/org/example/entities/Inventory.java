package org.example.entities;

import java.util.concurrent.atomic.AtomicInteger;

public class Inventory {
    private final String productId;
    private final String sellerId;
    private AtomicInteger quantity;

    public Inventory(String productId, String sellerId, int quantity) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.quantity = new AtomicInteger(quantity);
    }

    public String getProductId() {
        return productId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public int getQuantity() {
        return quantity.get();
    }

    public void addStock(int delta){
        quantity.getAndAdd(delta);
    }

    public void reduceStock(int delta){
        quantity.getAndAdd(-delta);
    }

    public boolean hasEnoughStock(int requiredQantity){
        return quantity.get()>=requiredQantity;
    }

    public boolean tryToDecreaseStock(int quant){
        while(true){
            int val=quantity.get();
            if(val<quant){
                return false;
            }
           if(quantity.compareAndSet(val,val-quant)){
               return true;
           }
        }
    }
}
