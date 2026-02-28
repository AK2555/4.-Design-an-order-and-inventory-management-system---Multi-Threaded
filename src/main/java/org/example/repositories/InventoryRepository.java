package org.example.repositories;

import org.example.entities.Inventory;

public interface InventoryRepository {
     void save(Inventory inventory);
     Inventory find(String sellerId,String productId);
     Inventory getAndComputeIfAbsent(String sellerId,String productId);
}
