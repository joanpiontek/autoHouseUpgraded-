package autohouse.resource;

import autoHouseManager.BrandModelsManager;
import autoHouseManager.BrandNamesManager;
import autohouse.BrandModels;
import autohouse.BrandNames;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/model")
@Produces(MediaType.TEXT_PLAIN)
public class BrandModelsResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BrandModels getBrandModel(@PathParam("id") int id){
        BrandModels name = BrandModelsManager.getModel(id);
        return name;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<BrandModels> getAllBrandModels() throws SQLException {
        ArrayList<BrandModels> names = BrandModelsManager.getAllModels();
        return names;
    }

    @POST
    public void postBrandModel(BrandModels brandModels){
        BrandModelsManager.createModel(brandModels);
    }

    @DELETE
    @Path("/{modelId}")
    public void deleteBrandModel(@PathParam("modelId") int modelId){
        BrandModelsManager.deleteModel(modelId);
    }

    @PUT
    @Path("/{id}")
    public void updateBrandModel(@PathParam("id") int id, BrandModels brandModels){
        BrandModelsManager.updateModel(id, brandModels);
    }

}
