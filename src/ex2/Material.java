package ex2;

import java.time.LocalDate;

public abstract class Material {
    static int hiddenID = 10000;
    public String id;
    private String name;
    private LocalDate getManufacturingDate;
    private int cost;

    public Material() {
        hiddenID++;
    }

    public Material(String id, String name, LocalDate manufacturingDate, int cost) {
        this.id = id;
        this.name = name;
        this.getManufacturingDate = manufacturingDate;
        this.cost = cost;
        hiddenID++;
    }
    public abstract double getAmount();
    public abstract LocalDate getExpiryDate();
    public boolean isExpired(){
        if (this.getExpiryDate().isAfter(LocalDate.now())){
            return false;
        } else return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getManufacturingDate() {
        return getManufacturingDate;
    }

    public void setGetManufacturingDate(LocalDate getManufacturingDate) {
        this.getManufacturingDate = getManufacturingDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", getManufacturingDate=" + getManufacturingDate +
                ", cost=" + cost +
                '}';
    }
}
