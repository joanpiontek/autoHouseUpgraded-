package autohouse;

public class CarRepairs {
    private int carRepairID;
    private int carID;
    private int repairID;

    public CarRepairs(){}

    public CarRepairs(int carRepairID, int carID, int repairID) {
        this.carRepairID = carRepairID;
        this.carID = carID;
        this.repairID = repairID;
    }

    public int getCarRepairID() {
        return carRepairID;
    }

    public void setCarRepairID(int carRepairID) {
        this.carRepairID = carRepairID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getRepairID() {
        return repairID;
    }

    public void setRepairID(int repairID) {
        this.repairID = repairID;
    }
}
