package autohouse;

public class RepairList {

    private int repairId;
    private String repairDate;
    private String repairDes;
    private int repairPrize;
    private String carRegistrationId;

    public RepairList(){}

    public RepairList(int repairId, String repairDate, String repairDes, int repairPrize, String carRegistrationNumber) {
        this.repairId = repairId;
        this.repairDate = repairDate;
        this.repairDes = repairDes;
        this.repairPrize = repairPrize;
    }

    public RepairList(int repairId, int repairPrize, String carRegistrationId) {
        this.repairId = repairId;
        this.repairPrize = repairPrize;
        this.carRegistrationId = carRegistrationId;
    }

    public int getRepairId() {
        return repairId;
    }

    public void setRepairId(int repairId) {
        this.repairId = repairId;
    }

    public String getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(String repairDate) {
        this.repairDate = repairDate;
    }

    public String getRepairDes() {
        return repairDes;
    }

    public void setRepairDes(String repairDes) {
        this.repairDes = repairDes;
    }

    public int getRepairPrize() {
        return repairPrize;
    }

    public void setRepairPrize(int repairPrize) {
        this.repairPrize = repairPrize;
    }

    public String getCarRegistrationId() {
        return carRegistrationId;
    }

    public void setCarRegistrationId(String carRegistrationId) {
        this.carRegistrationId = carRegistrationId;
    }
}
