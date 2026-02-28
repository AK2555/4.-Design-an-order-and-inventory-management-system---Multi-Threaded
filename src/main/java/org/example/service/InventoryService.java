package org.example.service;

import org.example.entities.Inventory;
import org.example.repositories.InventoryRepository;

public class InventoryService {
    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository=inventoryRepository;
    }

    public void addInventory(int productId, String sellerId, int delta) {
       Inventory inventory=inventoryRepository.getAndComputeIfAbsent(sellerId, String.valueOf(productId));
       inventory.addStock(delta);
    }

    public int getInventory(int productId, String sellerId) {
        Inventory inventory=inventoryRepository.find(sellerId,String.valueOf(productId));
        if(inventory==null){
            return 0;
        }
        return inventory.getQuantity();
    }
}
