package org.example.repositoryImpl;

import org.example.entities.Inventory;
import org.example.repositories.InventoryRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class InMemoryInventoryRepository implements InventoryRepository {

    //sellerId-productId -> Inventory

    private ConcurrentHashMap<String,Inventory> inventoryMap;

    public InMemoryInventoryRepository(){
        this.inventoryMap=new ConcurrentHashMap<>();
    }

    @Override
    public void save(Inventory inventory) {
        String id=mergerIds(inventory.getSellerId(),inventory.getProductId());
        inventoryMap.put(id,inventory);
    }

    @Override
    public Inventory find(String sellerId, String productId) {
        String id=mergerIds(sellerId,productId);
        return inventoryMap.get(id);
    }

    @Override
    public Inventory getAndComputeIfAbsent(String sellerId, String productId) {
        String id=mergerIds(sellerId,productId);
       return inventoryMap.computeIfAbsent(id, new Function<String, Inventory>() {
            @Override
            public Inventory apply(String s) {
                return new Inventory(productId,sellerId,0);
            }
        });
    }

    private String mergerIds(String sellerId,String productId){
        return sellerId+"-"+productId;
    }
}
