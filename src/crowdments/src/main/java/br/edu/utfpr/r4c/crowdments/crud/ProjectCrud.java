package br.edu.utfpr.r4c.crowdments.crud;

import br.edu.utfpr.r4c.crowdments.entities.Project;
import br.edu.utfpr.r4c.crowdments.entities.Task;
import br.edu.utfpr.r4c.crowdments.util.DefaultParams;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ricar
 */
public class ProjectCrud extends FacadeCrud<Project>{
    private EntityManager em;
    
    public ProjectCrud(){
        super(Project.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null){
            em = Persistence.createEntityManagerFactory(DefaultParams.PU).createEntityManager();
        }
        return em;
    }        
}
