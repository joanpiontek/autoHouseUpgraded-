package autohouse;

public class UserInfo {
    private int userId;
    private String userName;
    private float personalId;
    private String address;
    private int gender;
    private float userNumber;
    private String userEmail;
    private String userPassword;

    public UserInfo(){

    }

    public UserInfo(int userId, String userName, float personalId, String address, int gender, float userNumber, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.personalId = personalId;
        this.address = address;
        this.gender = gender;
        this.userNumber = userNumber;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public UserInfo(int userId, float personalId, float userNumber) {
        this.userId = userId;
        this.personalId = personalId;
        this.userNumber = userNumber;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getPersonalId() {
        return personalId;
    }

    public void setPersonalId(float personalId) {
        this.personalId = personalId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public float getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(float userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
