/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.webservices;

import br.edu.utfpr.r4c.crowdments.crud.AnwserCrud;
import br.edu.utfpr.r4c.crowdments.entities.Anwser;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author ricar
 */
@Path("/anwser")
@Produces("application/json")
public class AnwserResource extends FacadeWebservice<Anwser>{
    private AnwserCrud cr;
                       
    public AnwserResource(){
        super(Anwser.class);
        cr = new AnwserCrud();
        this.setManager(cr);
    }       
}
