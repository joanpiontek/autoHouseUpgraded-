package autohouse;

public class UserCars {

    private int carId;
    private float registrationNumberFrame;
    private float registrationNumber;
    private int carModelId;
    private String carColor;
    private int ownerId;

    public UserCars(){

    }

    public UserCars(int carId, float registrationNumberFrame, float registrationNumber, int carModelId, String carColor, int ownerID) {
        this.carId = carId;
        this.registrationNumberFrame = registrationNumberFrame;
        this.registrationNumber = registrationNumber;
        this.carModelId = carModelId;
        this.carColor = carColor;
        this.ownerId = ownerID;
    }

    public UserCars(int carId, float registrationNumber, int ownerID) {
        this.carId = carId;
        this.registrationNumber = registrationNumber;
        this.ownerId = ownerID;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public float getRegistrationNumberFrame() {
        return registrationNumberFrame;
    }

    public void setRegistrationNumberFrame(float registrationNumberFrame) {
        this.registrationNumberFrame = registrationNumberFrame;
    }

    public float getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(float registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(int carModelId) {
        this.carModelId = carModelId;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
