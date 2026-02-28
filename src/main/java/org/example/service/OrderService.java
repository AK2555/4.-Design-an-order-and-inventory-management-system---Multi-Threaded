package org.example.service;

import org.example.entities.Inventory;
import org.example.entities.Order;
import org.example.entities.Seller;
import org.example.enums.PaymentMode;
import org.example.repositories.InventoryRepository;
import org.example.repositories.OrderRepository;
import org.example.repositories.SellerRepository;

public class OrderService {

    private OrderRepository orderRepository;
    private SellerRepository sellerRepository;
    private InventoryRepository inventoryRepository;

    public OrderService(OrderRepository orderRepository,SellerRepository sellerRepository,InventoryRepository inventoryRepository) {
        this.orderRepository = orderRepository;
        this.sellerRepository=sellerRepository;
        this.inventoryRepository=inventoryRepository;
    }

    public String createOrder(String orderId, String destinationPincode, String sellerId,
                              int productId, int productCount, String paymentMode) {
       Seller seller=sellerRepository.findById(sellerId);
       if(!seller.isPaymentModesSupported(PaymentMode.from(paymentMode))){
           return "payment mode not supported";
       }
       if(!seller.isPincodeServiceable(destinationPincode)){
           return "pincode unserviceable";
       }
       Inventory inventory=inventoryRepository.find(sellerId,String.valueOf(productId));
       if(!inventory.tryToDecreaseStock(productCount)){
           return "insufficient product inventory";
       }
       Order order=new Order(orderId,sellerId,String.valueOf(productId),productCount);
      // inventory.reduceStock(productCount);
       orderRepository.save(order);
       return "order placed";
    }

}
