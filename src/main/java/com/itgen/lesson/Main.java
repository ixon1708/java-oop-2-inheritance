package com.itgen.lesson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;

    static {
        try {
            //ВНИМАНИЕ!!! если ученик из страны, где в дробных числах используют точки,
            // то сканнер не поймет например число 1,5 из-за запятой
            scanner = new Scanner(new File("in.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Purchase[] purchases = new Purchase[6];
        for (int i = 0; i < 6; i++) {
            purchases[i] = readPurchase();
        }

        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }

        Purchase purchaseWithMaxCost = null;
        for (Purchase purchase : purchases) {
            if (purchaseWithMaxCost == null) {
                purchaseWithMaxCost = purchase;
            } else if (secondGreaterThenFirst(purchaseWithMaxCost, purchase)) {
                purchaseWithMaxCost = purchase;
            }
        }
        System.out.println(purchaseWithMaxCost);

    }

    private static boolean secondGreaterThenFirst(Purchase purchase1, Purchase purchase2) {
        return purchase1.getCost().compareTo(purchase2.getCost()) < 0;
    }

    private static Purchase readPurchase() { // на скрине в презентации эта логика вынесена в enum
        PurchaseType purchaseType = PurchaseType.valueOf(scanner.next());
        switch (purchaseType) {
            case GENERAL_PURCHASE:
                return new GeneralPurchase(scanner);
            case PRICE_DISCOUNT_PURCHASE:
                return new PriceDiscountPurchase(scanner);
            case PERCENT_DISCOUNT_PURCHASE:
                return new PercentDiscountPurchase(scanner);
        }
        return new GeneralPurchase();
    }

}
