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
        LocalDate dayExpireBefore2Month = (getExpiryDate().minusMonths(2));
        LocalDate dayExpireBefore4Month = (getExpiryDate().minusMonths(4));
        if(isExpired()) {
            if (dayExpireBefore2Month.isBefore(LocalDate.now())) {
                return getAmount() * DISCOUNT40PERCENT;
            } else if (dayExpireBefore4Month.isBefore(LocalDate.now())) {
                return getAmount() * DISCOUNT20PERCENT;
            } else return getAmount() * DISCOUNT5PERCENT;
        } else return 0;
    }

    @Override
    public double getDifferentPrice() {
        boolean materialUnexpired = (getRealMoney() != 0);
        if (materialUnexpired) {
            return this.getAmount() - getRealMoney();
        } return 0;
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
                ", Expiring Date= " + getExpiryDate() +
                ", quantity= " + getQuantity() +
                ", Price before Discount: " + getAmount() +
                ", After Discount:" + getRealMoney() +
                ", Different Price= " + getDifferentPrice() +
                "\n";
    }
}
