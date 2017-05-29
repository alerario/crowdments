/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.webservices;

import br.edu.utfpr.r4c.crowdments.crud.AnwserHasTagpatternCrud;
import br.edu.utfpr.r4c.crowdments.crud.TagPatternCrud;
import br.edu.utfpr.r4c.crowdments.crud.VwTagsCrud;
import br.edu.utfpr.r4c.crowdments.entities.AnwserHasTagpattern;
import br.edu.utfpr.r4c.crowdments.entities.Tagpattern;
import br.edu.utfpr.r4c.crowdments.entities.VwTags;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author ricar
 */
@Path("/tag")
@Produces("application/json")
public class TagPatternResource extends FacadeWebservice<AnwserHasTagpattern>{
    private AnwserHasTagpatternCrud cr;
    
                   
    public TagPatternResource(){
        super(AnwserHasTagpattern.class);
        cr = new AnwserHasTagpatternCrud();
        this.setManager(cr);
    }    
    
    @GET
    @Path("tags")
    public List<Tagpattern> getPatterns() {
        TagPatternCrud vwCrud = new TagPatternCrud();
        List<Tagpattern> record = vwCrud.getAll();
        return record;
    }    
    
    @GET
    @Path("tags/{id}")
    public List<AnwserHasTagpattern> getTag(@PathParam("id") int id) {
        AnwserHasTagpatternCrud vwCrud = new AnwserHasTagpatternCrud();
        List<AnwserHasTagpattern> record = vwCrud.byTag(id);
        return record;
    }    
    
    @GET
    @Path("tags/stats")
    public List<VwTags> getStats() {
        VwTagsCrud vwCrud = new VwTagsCrud();
        List<VwTags> record = vwCrud.getAll();
        return record;
    }   
}
