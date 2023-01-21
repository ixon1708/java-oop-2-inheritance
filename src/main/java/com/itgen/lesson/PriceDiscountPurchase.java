package com.itgen.lesson;

import java.util.Objects;
import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {

    private final int discount;

    public PriceDiscountPurchase(String name, Dollar price, int amount, int discount) {
        super(name, price, amount);
        this.discount = discount;
    }

    public PriceDiscountPurchase() {
        //super(); не обязательно т.к. компилятор сам подставит этот вызов
        this.discount = 0;
    }

    public PriceDiscountPurchase(Scanner scanner) {
        super(scanner);
        this.discount = scanner.nextInt();
    }

    @Override
    public Dollar getCost() {
        int centsForOne = getPrice().getCents();
        int centsForAll = centsForOne * getAmount();
        return new Dollar(centsForAll - discount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceDiscountPurchase)) return false;
        if (!super.equals(o)) return false;
        PriceDiscountPurchase that = (PriceDiscountPurchase) o;
        return discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }

    @Override
    public String toString() {
        return super.toString() +
                ",\n\tdiscount=" + discount;
    }
}
