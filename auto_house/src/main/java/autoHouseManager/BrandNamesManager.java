package autoHouseManager;


import autohouse.BrandNames;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BrandNamesManager {

    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-9IOR8E5;intedasatedSecurity=false;username=sa;password=Password123!;database=autoHousee2";

    private static final String CREATE_BRAND_PROCEDURE = "EXEC CreateBrandProcedure ?";
    private static final String DELETE_BRAND_PROCEDURE = "EXEC DeleteBrandProcedure ?";
    private static final String UPDATE_BRAND_PROCEDURE = "EXEC UpdateBrandProcedure ?, ?";
    private static final String GET_BRAND_PROCEDURE = "EXEC GetBrandProcedure ? ";

    public static void createBrand(BrandNames brandNames) {

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(CREATE_BRAND_PROCEDURE)) {

            sta.setString(1, brandNames.getBrandName());

            sta.execute();

        } catch (SQLException ex) {
            System.out.println("Error while creating brand with name: " + brandNames.getBrandName());
        }
    }

    public static void deleteBrand(int brandId) {

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(DELETE_BRAND_PROCEDURE)) {

            sta.setInt(1, brandId);

            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while deleting brand with brand ID: " + brandId);
        }
    }

    public static void updateBrand(int id, BrandNames brandNames){

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(UPDATE_BRAND_PROCEDURE)) {

            sta.setInt(1, id);
            sta.setString(2, brandNames.getBrandName());

            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while updating brand with name: " + brandNames.getBrandName());
        }
    }

    public static BrandNames getBrand(int brandId) {

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(GET_BRAND_PROCEDURE)) {

            sta.setInt(1, brandId);

            ResultSet rs = sta.executeQuery();

            while (rs.next()) {
                String name = rs.getString("brandName");
                int id =  rs.getInt("brandId");
                BrandNames item = new BrandNames(id, name);
                return item;

            }

        }
        catch (SQLException ex) {
            System.out.println("Error while getting brand with id: " + brandId);
        }
        return null;
    }


    public static ArrayList<BrandNames> getAllBrands() throws SQLException {
        try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement sta = conn.createStatement()) {
            String Sql = "select * from brandNames";
            ResultSet rs = sta.executeQuery(Sql);
            ArrayList<BrandNames> list = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("brandName");
                int id =  rs.getInt("brandId");
                BrandNames item = new BrandNames(id, name);
                list.add(item);
                System.out.println();
            }
            return list;
        }
    }


}
