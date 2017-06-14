package br.edu.utfpr.r4c.crowdments.crud;

import br.edu.utfpr.r4c.crowdments.entities.Typeprofile;
import br.edu.utfpr.r4c.crowdments.util.DefaultParams;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
/**
 *
 * @author ricar
 */
public class TypeprofileCrud extends FacadeCrud<Typeprofile>{
    private EntityManager em;
    
    public TypeprofileCrud(){
        super(Typeprofile.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null){
            em = Persistence.createEntityManagerFactory(DefaultParams.PU).createEntityManager();
        }
        return em;
    }
}
