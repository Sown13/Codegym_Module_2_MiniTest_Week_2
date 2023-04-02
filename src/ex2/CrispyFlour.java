package ex2;

import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount{
    private int quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
        this.id = id + hiddenID;
    }

    public double getAmount(){
        return quantity * this.getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.getManufacturingDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        final double DISCOUNT40PERCENT = 6f / 10;
        final double DISCOUNT20PERCENT = 8f / 10;
        final double DISCOUNT5PERCENT = 9.5 / 10;
        if(isExpired()) {
            if (!getManufacturingDate().plusMonths(2).isAfter(LocalDate.now())) {
                return getCost() * DISCOUNT40PERCENT;
            } else if (!getManufacturingDate().plusMonths(4).isBefore(LocalDate.now())) {
                return getCost() * DISCOUNT20PERCENT;
            } else return getCost() * DISCOUNT5PERCENT;
        } else return 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return super.toString() +
                "CrispyFlour{" +
                "quantity=" + quantity +
                '}';
    }
}
