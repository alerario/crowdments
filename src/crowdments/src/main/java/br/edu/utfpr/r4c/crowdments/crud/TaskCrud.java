package br.edu.utfpr.r4c.crowdments.crud;

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
public class TaskCrud extends FacadeCrud<Task>{
    private EntityManager em;
    
    public TaskCrud(){
        super(Task.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null){
            em = Persistence.createEntityManagerFactory(DefaultParams.PU).createEntityManager();
        }
        return em;
    }
    
    public List<Task> byProjectToDo (Integer id) {
        try {
            getEntityManager().getTransaction().begin();
            Query q = getEntityManager().createNamedQuery(Task.class.getSimpleName()+".findByStatues");
            q.setParameter("project", id);
            q.setParameter("statues", 1);
            
            return q.getResultList();
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public List<Task> byProjectToDoing(Integer id) {
        try {
            getEntityManager().getTransaction().begin();
            Query q = getEntityManager().createNamedQuery(Task.class.getSimpleName()+".findByStatues");
            q.setParameter("project", id);
            q.setParameter("statues", 2);
            
            return q.getResultList();
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public List<Task> byProjectToDone (Integer id) {
        try {
            getEntityManager().getTransaction().begin();
            Query q = getEntityManager().createNamedQuery(Task.class.getSimpleName()+".findByStatues");
            q.setParameter("project", id);
            q.setParameter("statues", 3);
            
            return q.getResultList();
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
