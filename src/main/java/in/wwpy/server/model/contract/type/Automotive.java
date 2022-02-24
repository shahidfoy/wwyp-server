package in.wwpy.server.model.contract.type;

import javax.persistence.Entity;

@Entity
public class Automotive extends Item {
    private int doors;
    private String fuelType;
    private int mileage;

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
