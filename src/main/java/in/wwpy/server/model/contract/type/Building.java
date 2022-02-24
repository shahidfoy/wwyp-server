package in.wwpy.server.model.contract.type;

import javax.persistence.Entity;

@Entity
public class Building extends Realm {
    private boolean basement;
    private int baths;
    private int floors;
    private int lotSquareFootage;
    private int rooms;
    private String type;

    public boolean isBasement() {
        return basement;
    }

    public void setBasement(boolean basement) {
        this.basement = basement;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getLotSquareFootage() {
        return lotSquareFootage;
    }

    public void setLotSquareFootage(int lotSquareFootage) {
        this.lotSquareFootage = lotSquareFootage;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
