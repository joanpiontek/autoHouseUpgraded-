package autohouse.resource;

import autoHouseManager.BrandNamesManager;
import autoHouseManager.UserCarsManager;
import autoHouseManager.UserInfoManager;
import autohouse.CarRepairs;
import autohouse.UserCars;
import autohouse.UserInfo;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/user/car")
@Produces(MediaType.TEXT_PLAIN)
public class UserCarsResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserCars getUserCar(@PathParam("id") int id){
        UserCars name = UserCarsManager.getUserCar(id);
        return name;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<UserCars> getAllUserCars() throws SQLException {
        ArrayList<UserCars> names = UserCarsManager.getAllUserCars();
        return names;
    }

    @POST
    public void createUserCar(UserCars userCars){
        UserCarsManager.createUserCar(userCars);
    }

    @DELETE
    @Path("/{carId}")
    public void deleteUserCar(@PathParam("carId") int carId){
        UserCarsManager.deleteUserCar(carId);
    }

    @PUT
    @Path("/{carId}")
    public void updateUserCar(@PathParam("carId") int carId, UserCars userCars){
        UserCarsManager.updateUserCar(carId, userCars);
    }
}