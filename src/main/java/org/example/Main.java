package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Helper04 helper = new Helper04();
        Solution solution = new Solution();

        // init
        solution.init(helper, 10);
        helper.println("helper is initialized.");

        // create sellers
        solution.createSeller(
                "seller-0",
                Arrays.asList("110001", "560092", "452001", "700001"),
                Arrays.asList("netbanking", "cash", "upi")
        );

        solution.createSeller(
                "seller-1",
                Arrays.asList("400050", "110001", "600032", "560092"),
                Arrays.asList("netbanking", "cash", "upi")
        );

        // add inventory
        solution.addInventory(0, "seller-1", 52);
        helper.println("addInventory(0, seller-1, 52) returned \"inventory added\"");

        solution.addInventory(0, "seller-0", 32);
        helper.println("addInventory(0, seller-0, 32) returned \"inventory added\"");

        // create order 1
        String res1 = solution.createOrder(
                "order-1",
                "400050",
                "seller-1",
                0,
                5,
                "upi"
        );
        helper.println("createOrder(order-1, 400050, seller-1, 0, 5, upi) returned \"" + res1 + "\"");

        int inv1 = solution.getInventory(0, "seller-1");
        helper.println("getInventory(0, seller-1) returned " + inv1);

        // create order 2
        String res2 = solution.createOrder(
                "order-2",
                "560092",
                "seller-0",
                0,
                1,
                "upi"
        );
        helper.println("createOrder(order-2, 560092, seller-0, 0, 1, upi) returned \"" + res2 + "\"");

        int inv2 = solution.getInventory(0, "seller-0");
        helper.println("getInventory(0, seller-0) returned " + inv2);
    }
}