package org.example.entities;

import org.example.enums.PaymentMode;

import java.util.Set;

public class Seller {
    private final String sellerId;
    private Set<String> serviceablePincodes;
    private Set<PaymentMode> paymentModes;

    public Seller(String sellerId, Set<String> serviceablePincodes, Set<PaymentMode> paymentModes) {
        this.sellerId = sellerId;
        this.serviceablePincodes = serviceablePincodes;
        this.paymentModes = paymentModes;
    }

    public String getSellerId(){
        return sellerId;
    }

    public boolean isPincodeServiceable(String pinCode){
        return this.serviceablePincodes.contains(pinCode);
    }

    public boolean isPaymentModesSupported(PaymentMode paymentMode){
        return this.paymentModes.contains(paymentMode);
    }
}
