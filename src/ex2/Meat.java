package ex2;

import java.time.LocalDate;

public class Meat extends Material implements Discount {
    private double weight;

    public Meat() {
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getAmount() {
        return weight * cost;
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.manufacturingDate.plusDays(7);
    }

    @Override
    public double getRealMoney() {
        final double DISCOUNT30PERCENT = 7f / 10;
        final double DISCOUNT10PERCENT = 9f / 10;
        if (isExpired()) {
            if (!manufacturingDate.plusDays(5).isAfter(LocalDate.now())) {
                return cost * DISCOUNT30PERCENT;
            } else return cost * DISCOUNT10PERCENT;
        } else return 0;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
