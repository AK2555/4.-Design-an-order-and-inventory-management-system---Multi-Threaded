package org.example.enums;

public enum PaymentMode {
    UPI,
    CASH,
    NETBANKING,
    DEBIT_CARD,
    CREDIT_CARD;

    public static PaymentMode from(String str){
        return PaymentMode.valueOf(str.toUpperCase().replace(" ","_"));
    }
}
