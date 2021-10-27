package autohouse.resource;

import autoHouseManager.BrandNamesManager;
import autohouse.BrandNames;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/brand")
public class BrandNamesResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BrandNames getBrandName(@PathParam("id") int id){
        BrandNames name = BrandNamesManager.getBrand(id);
        return name;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<BrandNames> getAllBrandNames() throws SQLException {
        ArrayList<BrandNames> names = BrandNamesManager.getAllBrands();
        return names;
    }

    @POST
    public void postBrandName(BrandNames brandNames){
        BrandNamesManager.createBrand(brandNames);
    }

    @DELETE
    @Path("/{brandId}")
    public void deleteBrandName(@PathParam("brandId") int brandId){
        BrandNamesManager.deleteBrand(brandId);
    }

    @PUT
    @Path("/{id}")
    public void updateBrandName(@PathParam("id") int id, BrandNames brandNames){
        BrandNamesManager.updateBrand(id, brandNames);
    }
}

