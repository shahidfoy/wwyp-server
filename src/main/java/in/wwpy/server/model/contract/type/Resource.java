package in.wwpy.server.model.contract.type;

import in.wwpy.server.model.Contract;

import javax.persistence.Entity;

@Entity
public class Resource extends Contract {
    private int estimatedHours;

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(int estimatedHours) {
        this.estimatedHours = estimatedHours;
    }
}
