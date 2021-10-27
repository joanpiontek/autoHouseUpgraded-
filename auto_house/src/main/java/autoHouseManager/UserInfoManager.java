package autoHouseManager;

import autohouse.BrandModels;
import autohouse.UserInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInfoManager {
    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-9IOR8E5;intedasatedSecurity=false;username=sa;password=Password123!;database=autoHousee2";

    private static final String CREATE_USER_PROCEDURE = "EXEC CreateUser ?, ?, ?, ?";
    private static final String DELETE_USER_PROCEDURE = "EXEC DeleteUser ?";
    private static final String UPDATE_USER_PROCEDURE = "EXEC UpdateUser ?, ?, ?, ?, ?";
    private static final String GET_USER_PROCEDURE = "EXEC GetUser ?";

    public static void createUser(UserInfo user){

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(CREATE_USER_PROCEDURE)) {


            sta.setString(1, user.getUserName());
            sta.setFloat(2, user.getPersonalId());
            sta.setFloat(3, user.getUserNumber());
            sta.setString(4, user.getUserPassword());

            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while creating user with personalId: " + user.getPersonalId());
        }
    }

    public static void deleteUser(int userId) {

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(DELETE_USER_PROCEDURE)) {

            sta.setInt(1, userId);

            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while deleting user with userId: " + userId);
        }
    }

    public static void updateUser(int userId, UserInfo user){

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(UPDATE_USER_PROCEDURE)) {

            sta.setInt(1, userId);
            sta.setString(2, user.getUserName());
            sta.setFloat(3, user.getPersonalId());
            sta.setFloat(4, user.getUserNumber());
            sta.setString(5, user.getUserPassword());

            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while updating user with personalId: " + user.getPersonalId());
        }
    }

    public static UserInfo getUser(int userId){

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(GET_USER_PROCEDURE)) {

            sta.setInt(1, userId);

            ResultSet rs = sta.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("userId");
                float UserNumber = rs.getFloat("userNumber");
                float personal =  rs.getFloat("personalId");
                UserInfo item = new UserInfo(id, personal, UserNumber);
                return item;

            }

        }
        catch (SQLException ex) {
            System.out.println("Error while getting user with id: " + userId);
        }
        return null;
    }

    public static ArrayList<UserInfo> getAllUsers() throws SQLException {
        try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement sta = conn.createStatement()) {
            String Sql = "select * from UserInfo";
            ResultSet rs = sta.executeQuery(Sql);
            ArrayList<UserInfo> list = new ArrayList<>();
            while (rs.next()) {
                float UserNumber = rs.getFloat("userNumber");
                int id = rs.getInt("userId");
                float personal =  rs.getFloat("personalId");
                UserInfo item = new UserInfo(id, personal, UserNumber);
                list.add(item);
                System.out.println();
            }
            return list;
        }
    }

}
