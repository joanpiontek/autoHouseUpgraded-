package autohouse.runner;

import autohouse.config.BrandNamesConfiguration;
import autohouse.resource.*;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import java.sql.*;
import java.util.concurrent.ExecutionException;


public class BrandAPI extends Application<BrandNamesConfiguration> {
    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-9IOR8E5;intedasatedSecurity=false;username=sa;password=Password123!;database=autoHousee2";

    private static final String CREATE_BRAND_PROCEDURE = "EXEC CreateBrandProcedure ?";
    private static final String DELETE_BRAND_PROCEDURE = "EXEC DeleteBrandProcedure ?";
    private static final String UPDATE_BRAND_PROCEDURE = "EXEC UpdateBrandProcedure ?, ?";
    private static final String CREATE_MODEL_PROCEDURE = "EXEC CreateModelProcedure ?, ?";
    private static final String DELETE_MODEL_PROCEDURE = "EXEC CreateModelProcedure ?, ?";
    private static final String UPDATE_MODEL_PROCEDURE = "EXEC UpdateModelProcedure ?, ?, ?";
    private static final String CREATE_USER_PROCEDURE = "EXEC CreateUser ?, ?, ?, ?";
    private static final String DELETE_USER_PROCEDURE = "EXEC DeleteUser ?, ?";
    private static final String UPDATE_USER_PROCEDURE = "EXEC UpdateUser ?, ?, ?, ?";
    private static final String CREATE_USER_CAR_PROCEDURE = "EXEC CreateUserCar ?, ?, ?";
    private static final String DELETE_USER_CAR_PROCEDURE = "EXEC DeleteUserCar ?, ?, ?";
    private static final String UPDATE_USER_CAR_PROCEDURE = "EXEC UpdateUserCar ?, ?, ?";
    private static final String CREATE_CAR_REPAIR_PROCEDURE = "EXEC CreateUserCarRepair ?, ?, ?";
    private static final String DELETE_CAR_REPAIR_PROCEDURE = "EXEC DeleteUserCarRepair ?, ?, ?";
    private static final String UPDATE_CAR_REPAIR_PROCEDURE = "EXEC UpdateUserCarRepair ?, ?, ?";


    public static void main(String[] args) throws Exception, SQLException, ClassNotFoundException {
        new BrandAPI().run(args);
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        autoHouseManager.BrandNamesanager brandNamesManager = new autoHouseManager.BrandNamesManager();
////        brandNamesManager.createBrand("abc"M);

//          autoHouseManager.BrandModelsManager brandModelsManager = new autoHouseManager.BrandModelsManager();
//          brandModelsManager.updateModel(15, "model X", 2);

//        autoHouseManager.UserInfoManager userInfoManager = new autoHouseManager.UserInfoManager();
//        userInfoManager.createUser(8, "Pesho", 10, 882);

//        autoHouseManager.UserCarsManager userCarsManager = new autoHouseManager.UserCarsManager();
//        userCarsManager.updateUserCar(2, "1235", 3);

//        autoHouseManager.RepairListManager repairListManager = new autoHouseManager.RepairListManager();
//        repairListManager.createCarRepair();

    }

    @Override
    public void run(BrandNamesConfiguration brandNamesConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new BrandNamesResource());
        environment.jersey().register(new BrandModelsResource());
        environment.jersey().register(new UserInfoResource());
        environment.jersey().register(new UserCarsResource());
        environment.jersey().register(new RepairListResource());
    }
}