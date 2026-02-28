package org.example.service;

import org.example.entities.Seller;
import org.example.enums.PaymentMode;
import org.example.repositories.SellerRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SellerService {

    private SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository){
        this.sellerRepository=sellerRepository;
    }

    public void createSeller(String sellerId, List<String> serviceablePincodes, List<String> paymentModes) {
        Set<String> serviceablePincodeSet=new HashSet<>();
        for(String str: serviceablePincodes){
            serviceablePincodeSet.add(str);
        }
        Set<PaymentMode> paymentModeSet=new HashSet<>();
        for(String str: paymentModes){
            paymentModeSet.add(PaymentMode.from(str));
        }
       Seller seller=new Seller(sellerId,serviceablePincodeSet,paymentModeSet);
        sellerRepository.save(seller);
    }

}
