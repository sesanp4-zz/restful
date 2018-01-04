/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ssp
 */
@Path("/path")
public class myservice {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of myservice
     */
    Dao d;
    public myservice() {
        d=new Dao();
    }

    
   @Path("/get")
   @GET
   //This is just for fetching data from datasource using jax-rs example
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<user> get_all_user_as_json(){
    return  d.get_users();
    }
    
   
   
    
    @Path("/post")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
     //This method consume json data and conovert it into java object
   public user add(user user){
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getRoom_id());
        return user;
   } 

}
