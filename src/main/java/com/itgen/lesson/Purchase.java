package com.itgen.lesson;

import java.util.Objects;
import java.util.Scanner;

public abstract class Purchase {

    private String name;
    private Dollar price;
    private int amount;

    public Purchase(String name, Dollar price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Purchase() {
        this("", new Dollar(), 0);
    }

    public Purchase(Scanner scanner) {
        this(scanner.next(), new Dollar(scanner.nextInt()), scanner.nextInt());
    }

    public String getName() {
        return name;
    }

    public Dollar getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Dollar price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return amount == purchase.amount &&
                name.equals(purchase.name) &&
                price.equals(purchase.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, amount);
    }

    @Override
    public String toString() {
        return "Purchase:" +
                "\n\tname='" + name + '\'' +
                ",\n\tprice=" + price +
                ",\n\tamount=" + amount;
    }

    public Dollar getCost() {
        return new Dollar(price.getCents() * amount);
    }

}
