package in.wwpy.server.model.contract.type;

import in.wwpy.server.model.Contract;

import javax.persistence.Entity;

@Entity
public class Realm extends Contract {
    private int squareFootage;

    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }
}
