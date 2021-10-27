package autoHouseManager;

import autohouse.UserCars;
import autohouse.UserInfo;

import java.sql.*;
import java.util.ArrayList;

public class UserCarsManager {
    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-9IOR8E5;intedasatedSecurity=false;username=sa;password=Password123!;database=autoHousee2";

    private static final String CREATE_USER_CAR_PROCEDURE = "EXEC CreateUserCar ?, ?";
    private static final String DELETE_USER_CAR_PROCEDURE = "EXEC DeleteUserCar ?";
    private static final String UPDATE_USER_CAR_PROCEDURE = "EXEC UpdateUserCar ?, ?, ?";
    private static final String GET_USER_CAR_PROCEDURE = "EXEC GetUserCar ?";

    public static void createUserCar(UserCars userCars){

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(CREATE_USER_CAR_PROCEDURE)) {

            sta.setFloat(1, userCars.getRegistrationNumber());
            sta.setInt(2, userCars.getOwnerId());

            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while creating user car with registration number: " + userCars.getRegistrationNumber());
        }
    }

    public static void deleteUserCar(int carId) {

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(DELETE_USER_CAR_PROCEDURE)) {

            sta.setInt(1, carId);

            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while deleting user car with car ID: " + carId);
        }
    }

    public static void updateUserCar(int carId, UserCars userCars) {

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(UPDATE_USER_CAR_PROCEDURE)) {

            sta.setInt(1, carId);
            sta.setFloat(2, userCars.getRegistrationNumber());
            sta.setInt(3, userCars.getOwnerId());

            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while updating user car with registration number: " + userCars.getRegistrationNumber());
        }
    }

    public static UserCars getUserCar(int carId){

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(GET_USER_CAR_PROCEDURE)) {

            sta.setInt(1, carId);

            ResultSet rs = sta.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("carId");
                int ownerID = rs.getInt("ownerId");
                float registrationNumber =  rs.getFloat("registrationNumber");
                UserCars item = new UserCars(id, registrationNumber, ownerID);
                return item;

            }

        }
        catch (SQLException ex) {
            System.out.println("Error while getting user car with id: " + carId);
        }
        return null;
    }

    public static ArrayList<UserCars> getAllUserCars() throws SQLException {
        try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement sta = conn.createStatement()) {
            String Sql = "select * from UserCars";
            ResultSet rs = sta.executeQuery(Sql);
            ArrayList<UserCars> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("carId");
                int ownerID = rs.getInt("ownerId");
                float registrationNumber =  rs.getFloat("registrationNumber");
                UserCars item = new UserCars(id, registrationNumber, ownerID);
                list.add(item);
                System.out.println();
            }
            return list;
        }
    }


}
