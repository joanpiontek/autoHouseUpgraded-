package autoHouseManager;

import autohouse.CarRepairs;
import autohouse.RepairList;
import autohouse.UserCars;

import java.sql.*;
import java.util.ArrayList;

public class RepairListManager {
    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-9IOR8E5;intedasatedSecurity=false;username=sa;password=Password123!;database=autoHousee2";

    private static final String CREATE_CAR_REPAIR_PROCEDURE = "EXEC CreateUserCarRepair ?, ?";
    private static final String UPDATE_CAR_REPAIR_PROCEDURE = "EXEC UpdateUserCarRepair ?, ?, ?";
    private static final String GET_CAR_REPAIR_PROCEDURE = "EXEC GetUserCarRepair ?";

    public static void createCarRepair(RepairList repairList){

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(CREATE_CAR_REPAIR_PROCEDURE)) {

            sta.setInt(1, repairList.getRepairPrize());
            sta.setString(2, repairList.getCarRegistrationId());

            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while creating user car repair with registration number: " + repairList.getCarRegistrationId());
        }
    }

    public static void updateCarRepair(int repairId, RepairList repairList) {

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(UPDATE_CAR_REPAIR_PROCEDURE)) {

            sta.setInt(1, repairId);
            sta.setInt(2, repairList.getRepairPrize());
            sta.setString(3, repairList.getCarRegistrationId());

            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while updating user car repair with registration number: " + repairList.getCarRegistrationId());
        }
    }


    public static RepairList getUserCarRepair(int repairId){

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(GET_CAR_REPAIR_PROCEDURE)) {

            sta.setInt(1, repairId);

            ResultSet rs = sta.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("repairId");
                int price = rs.getInt("repairPrize");
                String registrationId =  rs.getString("carRegistrationId");
                RepairList item = new RepairList(id, price, registrationId);
                return item;
            }
        }
        catch (SQLException ex) {
            System.out.println("Error while getting user car with id: " + repairId);
        }
        return null;
    }

    public static ArrayList<RepairList> getAllUserCarRepairs() throws SQLException {
        try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement sta = conn.createStatement()) {
            String Sql = "select * from RepairList";
            ResultSet rs = sta.executeQuery(Sql);
            ArrayList<RepairList> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("repairId");
                int price = rs.getInt("repairPrize");
                String registrationId =  rs.getString("carRegistrationId");
                RepairList item = new RepairList(id, price, registrationId);
                list.add(item);
                System.out.println();
            }
            return list;
        }
    }

}
