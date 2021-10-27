package autohouse.resource;

import autoHouseManager.RepairListManager;
import autoHouseManager.UserCarsManager;
import autohouse.RepairList;
import autohouse.UserCars;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/user/car/repair")
@Produces(MediaType.TEXT_PLAIN)
public class RepairListResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RepairList getUserCarRepair(@PathParam("id") int id){
        RepairList name = RepairListManager.getUserCarRepair(id);
        return name;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<RepairList> getAllUserCarRepairs() throws SQLException {
        ArrayList<RepairList> names = RepairListManager.getAllUserCarRepairs();
        return names;
    }

    @POST
    public void createCarRepair(RepairList repairList){
        RepairListManager.createCarRepair(repairList);
    }

    @PUT
    @Path("/{repairId}")
    public void updateCarRepair(@PathParam("repairId") int repairId, RepairList repairList){
        RepairListManager.updateCarRepair(repairId, repairList);
    }
}
