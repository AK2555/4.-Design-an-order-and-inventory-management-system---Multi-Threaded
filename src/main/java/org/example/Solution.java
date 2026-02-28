package org.example;

import org.example.repositories.InventoryRepository;
import org.example.repositories.OrderRepository;
import org.example.repositories.SellerRepository;
import org.example.repositoryImpl.InMemoryInventoryRepository;
import org.example.repositoryImpl.InMemoryOrderRepository;
import org.example.repositoryImpl.InMemorySellerRepository;
import org.example.service.InventoryService;
import org.example.service.OrderService;
import org.example.service.SellerService;

import java.util.List;

public class Solution implements Q04EcommerceOrdersInterface {
    private Helper04 helper;
    private InventoryRepository inventoryRepository;
    private OrderRepository orderRepository;
    private SellerRepository sellerRepository;
    private InventoryService inventoryService;
    private OrderService orderService;
    private SellerService sellerService;

    public Solution(){}

    public void init(Helper04 helper, int productsCount){
        this.helper=helper;
        this.inventoryRepository=new InMemoryInventoryRepository();
        this.orderRepository=new InMemoryOrderRepository();
        this.sellerRepository=new InMemorySellerRepository();
        this.inventoryService=new InventoryService(inventoryRepository);
        this.orderService=new OrderService(orderRepository,sellerRepository,inventoryRepository);
        this.sellerService=new SellerService(sellerRepository);
    }

    //paymentModes it will be always one of  "cash", "upi", "netbanking", "debit card" and "credit card"
    public void createSeller(String sellerId, List<String> serviceablePincodes, List<String> paymentModes) {
         sellerService.createSeller(sellerId,serviceablePincodes,paymentModes);
    }

    //returns "inventory added", "product doesn't exist", "seller doesn't exist"
    public void addInventory(int productId, String sellerId, int delta) {
         inventoryService.addInventory(productId,sellerId,delta);
    }

    //if the product or seller doesn't exist then returns 0
    public int getInventory(int productId, String sellerId) {
        return inventoryService.getInventory(productId,sellerId);
    }

    // returns (in that order) : "order placed" or "pincode unserviceable"
    // or "payment mode not supported" or "insufficient product inventory"
    public String createOrder(String orderId, String destinationPincode, String sellerId,
                              int productId, int productCount, String paymentMode) {
        return orderService.createOrder(orderId,destinationPincode,sellerId,productId,productCount,paymentMode);
    }

}



interface Q04EcommerceOrdersInterface {

    public void init(Helper04 helper, int productsCount);

    void createSeller(String sellerId, List<String> serviceablePincodes, List<String> paymentModes);

    void addInventory(int productId, String sellerId, int delta);

    int getInventory(int productId, String sellerId);

    String createOrder(String orderId, String destinationPincode, String sellerId,
                       int productId, int productCount, String paymentMode);

}

class Helper04 {
    void print(String s){System.out.print(s);}
    void println(String s){System.out.println(s);}
}