package org.example.repositoryImpl;

import org.example.entities.Seller;
import org.example.repositories.SellerRepository;

import java.util.concurrent.ConcurrentHashMap;

public class InMemorySellerRepository implements SellerRepository {

    private ConcurrentHashMap<String,Seller> sellerMap;

    public InMemorySellerRepository(){
        this.sellerMap=new ConcurrentHashMap<>();
    }

    @Override
    public void save(Seller seller) {
        sellerMap.put(seller.getSellerId(),seller);
    }

    @Override
    public Seller findById(String sellerId) {
      return sellerMap.get(sellerId);
    }
}
