package autohouse.resource;

import autoHouseManager.BrandModelsManager;
import autoHouseManager.BrandNamesManager;
import autoHouseManager.UserInfoManager;
import autohouse.BrandModels;
import autohouse.UserInfo;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/user")
@Produces(MediaType.TEXT_PLAIN)
public class UserInfoResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserInfo getUserInfo(@PathParam("id") int id){
        UserInfo name = UserInfoManager.getUser(id);
        return name;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<UserInfo> getAllUserInfo() throws SQLException {
        ArrayList<UserInfo> names = UserInfoManager.getAllUsers();
        return names;
    }

    @POST
    public void postUsername(UserInfo user){
        UserInfoManager.createUser(user);
    }

    @DELETE
    @Path("/{userId}")
    public void deleteUsername(@PathParam("userId") int userId){
        UserInfoManager.deleteUser(userId);
    }

    @PUT
    @Path("/{userId}")
    public void updateUsername(@PathParam("userId") int userId, UserInfo user){
        UserInfoManager.updateUser(userId, user);
    }

}