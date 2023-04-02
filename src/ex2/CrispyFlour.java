package ex2;

import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount{
    private int quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public double getAmount(){
        return quantity * cost;
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.manufacturingDate.plusYears(1);
    }

    @Override
    public double getRealMoney() {
        final double DISCOUNT40PERCENT = 6f / 10;
        final double DISCOUNT20PERCENT = 8f / 10;
        final double DISCOUNT5PERCENT = 9.5 / 10;
        if(isExpired()) {
            if (!manufacturingDate.plusMonths(2).isAfter(LocalDate.now())) {
                return cost * DISCOUNT40PERCENT;
            } else if (!manufacturingDate.plusMonths(4).isBefore(LocalDate.now())) {
                return cost * DISCOUNT20PERCENT;
            } else return cost * DISCOUNT5PERCENT;
        } else return 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
