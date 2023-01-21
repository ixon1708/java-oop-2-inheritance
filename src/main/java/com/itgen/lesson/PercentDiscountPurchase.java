package com.itgen.lesson;

import java.util.Objects;
import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase {
    private static final int AMOUNT_FOR_DISCOUNT = 2;

    private final double percent;

    public PercentDiscountPurchase(String name, Dollar price, int amount, double percent) {
        super(name, price, amount);
        this.percent = percent;
    }

    public PercentDiscountPurchase() {
        this.percent = 0;
    }

    public PercentDiscountPurchase(Scanner scanner) {
        super(scanner);
        this.percent = scanner.nextDouble();
    }

    public double getPercent() {
        return percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PercentDiscountPurchase)) return false;
        if (!super.equals(o)) return false;
        PercentDiscountPurchase that = (PercentDiscountPurchase) o;
        return Double.compare(that.percent, percent) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), percent);
    }

    @Override
    public String toString() {
        return super.toString() +
                ",\n\tpercent=" + percent;
    }

    @Override
    public Dollar getCost() {
        int generalCost = getPrice().getCents() * getAmount();
        return new Dollar((int) (generalCost - generalCost * percent));
    }
}
