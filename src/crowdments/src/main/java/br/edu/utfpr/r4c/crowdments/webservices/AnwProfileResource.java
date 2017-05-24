/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.webservices;

import br.edu.utfpr.r4c.crowdments.crud.AnwProfileCurd;
import br.edu.utfpr.r4c.crowdments.entities.Anwserprofilequestion;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author ricar
 */
@Path("/anwser")
@Produces("application/json")
public class AnwProfileResource extends FacadeWebservice<Anwserprofilequestion>{
    private AnwProfileCurd cr;
                       
    public AnwProfileResource(){
        super(Anwserprofilequestion.class);
        cr = new AnwProfileCurd();
        this.setManager(cr);
    }       
}
