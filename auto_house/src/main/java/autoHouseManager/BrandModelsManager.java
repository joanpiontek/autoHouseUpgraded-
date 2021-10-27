package autoHouseManager;

import autohouse.BrandModels;
import autohouse.BrandNames;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BrandModelsManager {
    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-9IOR8E5;intedasatedSecurity=false;username=sa;password=Password123!;database=autoHousee2";

    private static final String CREATE_MODEL_PROCEDURE = "EXEC CreateModelProcedure ?, ?";
    private static final String DELETE_MODEL_PROCEDURE = "EXEC DeleteModelProcedure ?";
    private static final String UPDATE_MODEL_PROCEDURE = "EXEC UpdateModelProcedure ?, ?, ?";
    private static final String GET_MODEL_PROCEDURE = "EXEC GetModelProcedure ?";


    public static void createModel(BrandModels brandModels) {

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(CREATE_MODEL_PROCEDURE)) {

            sta.setString(1, brandModels.getModelName());
            sta.setInt(2, brandModels.getBrandID());

            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while creating model with name: " + brandModels.getModelName());
        }
    }

    public static void deleteModel(int modelId)  {

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(DELETE_MODEL_PROCEDURE)) {

            sta.setInt(1, modelId);

            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while deleting model with id: " + modelId);
        }
    }

    public static void updateModel(int id, BrandModels brandModels){

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(UPDATE_MODEL_PROCEDURE)) {

            sta.setInt(1, id);
            sta.setString(2, brandModels.getModelName());
            sta.setInt(3, brandModels.getBrandID());

            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while updating model with name: " + brandModels.getModelName());
        }
    }


    public static BrandModels getModel(int modelId, BrandModels model){

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(GET_MODEL_PROCEDURE)) {

            sta.setInt(1, modelId);
            sta.setString(2, model.getModelName());
            sta.setInt(3, model.getBrandID());


            sta.execute();

        }
        catch (SQLException ex) {
            System.out.println("Error while getting model with id: " + modelId);
        }
        return model;
    }

    public static BrandModels getModel(int modelId){

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             CallableStatement sta = conn.prepareCall(GET_MODEL_PROCEDURE)) {

            sta.setInt(1, modelId);

            ResultSet rs = sta.executeQuery();

            while (rs.next()) {
                String name = rs.getString("modelName");
                int id =  rs.getInt("modelId");
                int brandId =  rs.getInt("brandID");
                BrandModels item = new BrandModels(id, name, brandId);
                return item;

            }

        }
        catch (SQLException ex) {
            System.out.println("Error while getting model with id: " + modelId);
        }
        return null;
    }

    public static ArrayList<BrandModels> getAllModels() throws SQLException {
        try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement sta = conn.createStatement()) {
            String Sql = "select * from modelNames";
            ResultSet rs = sta.executeQuery(Sql);
            ArrayList<BrandModels> list = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("modelName");
                int id =  rs.getInt("modelId");
                int brandId =  rs.getInt("brandID");
                BrandModels item = new BrandModels(id, name, brandId);
                list.add(item);
                System.out.println();
            }
            return list;
        }
    }


}
