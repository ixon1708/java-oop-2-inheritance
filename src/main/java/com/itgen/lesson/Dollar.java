package com.itgen.lesson;

import java.util.Objects;

public class Dollar implements Comparable<Dollar> {

    private int cents;

    public Dollar(int cents) {
        this.cents = cents;
    }

    public Dollar() {
        this(0); //для избежания дублирования кода вызываем тут предыдущий конструктор
    }

    public int getCents() {
        return cents;
    }

    public void add(Dollar money) {
        this.cents += money.getCents();
    }

    public void restrict(Dollar money) {
        this.cents -= money.getCents();
    }

    public void multiple(int amount) {
        this.cents *= amount;
    }

    @Override
    public String toString() {
        return (cents / 100) + "." + (cents % 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dollar)) return false;
        Dollar dollar = (Dollar) o;
        return cents == dollar.cents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cents);
    }

    @Override
    public int compareTo(Dollar dollar) {
        return this.cents - dollar.getCents();
    }

}
