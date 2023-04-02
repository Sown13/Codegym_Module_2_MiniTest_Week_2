package ex2;

import java.time.LocalDate;

public abstract class Material {
    static int hiddenID = 10000;
    private String id;
    private String name;
    private LocalDate manufacturingDate;
    private int cost;

    public Material() {
        hiddenID++;
    }

    public Material(String id, String name, LocalDate manufacturingDate, int cost) {
        this.id = id + hiddenID;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
        this.cost = cost;
        hiddenID++;
    }
    public abstract double getAmount();
    public abstract LocalDate getExpiryDate();
    public boolean isExpired(){
        return !LocalDate.now().isAfter(this.getExpiryDate());
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
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return
                "id='" + getId() + '\'' +
                ", name= '" + name + '\'' +
                ", ManufacturingDate= " + manufacturingDate +
                ", cost= " + cost ;
    }
}
