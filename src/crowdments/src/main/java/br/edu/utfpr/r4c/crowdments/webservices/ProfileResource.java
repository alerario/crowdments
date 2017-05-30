/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.webservices;

import br.edu.utfpr.r4c.crowdments.crud.ProfileCrud;
import br.edu.utfpr.r4c.crowdments.entities.Profile;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author ricar
 */
@Path("/profile")
@Produces("application/json")
public class ProfileResource extends FacadeWebservice<Profile>{
    private ProfileCrud cr;
    
                   
    public ProfileResource(){
        super(Profile.class);
        cr = new ProfileCrud();
        this.setManager(cr);
    }       
    
    @GET
    @Path("byMail/{mail}")
    public Profile getAnwsersByMail(@PathParam("mail") String mail) {
        ProfileCrud vwCrud = new ProfileCrud();
        Profile record = vwCrud.byMail(mail);
        return record;
    }
    
}
