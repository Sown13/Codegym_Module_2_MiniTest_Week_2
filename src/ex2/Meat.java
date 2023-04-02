package ex2;

import java.time.LocalDate;

public class Meat extends Material implements Discount{
    private double weight;

    public Meat() {
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getAmount() {
        return weight * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        final double DISCOUNT30PERCENT = 7f / 10;
        final double DISCOUNT10PERCENT = 9f / 10;
        boolean expireDateLessThan5Days = (getExpiryDate().minusDays(2)).isBefore(LocalDate.now());
        if (isExpired()) {
            if (expireDateLessThan5Days) {
                return getAmount() * DISCOUNT30PERCENT;
            } else return getAmount() * DISCOUNT10PERCENT;
        } else return 0;
    }
    @Override
    public double getDifferentPrice() {
        boolean materialUnexpired = (getRealMoney() != 0);
        if (materialUnexpired) {
            return this.getAmount() - getRealMoney();
        } return 0;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Expiring Date= " + getExpiryDate() +
                ", weight= " + getWeight() +
                ", Price before Discount: " + getAmount() +
                ", After Discount:" + getRealMoney() +
                ", Different Price= " + getDifferentPrice() +
                "\n";
    }
}
