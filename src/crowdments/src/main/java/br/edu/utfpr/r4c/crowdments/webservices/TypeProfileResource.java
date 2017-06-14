package br.edu.utfpr.r4c.crowdments.webservices;

import br.edu.utfpr.r4c.crowdments.crud.TypeprofileCrud;
import br.edu.utfpr.r4c.crowdments.entities.Typeprofile;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author ricar
 */
@Path("/typeprofiles")
@Produces("application/json")
public class TypeProfileResource extends FacadeWebservice<Typeprofile>{
    private TypeprofileCrud cr;    
                   
    public TypeProfileResource(){
        super(Typeprofile.class);
        cr = new TypeprofileCrud();
        this.setManager(cr);
    }     
}