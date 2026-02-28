package org.example.repositories;

import org.example.entities.Seller;

public interface SellerRepository {
     void save(Seller seller);
     Seller findById(String sellerId);
}
