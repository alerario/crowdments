/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.crud;

import br.edu.utfpr.r4c.crowdments.entities.VwUsersex;
import br.edu.utfpr.r4c.crowdments.util.DefaultParams;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ricar
 */
public class VwUsersexCrud extends FacadeCrud<VwUsersex>{
    private EntityManager em;
    
    public VwUsersexCrud(){
        super(VwUsersex.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null){
            em = Persistence.createEntityManagerFactory(DefaultParams.PU).createEntityManager();
        }
        return em;
    }
    
    public List<VwUsersex> byQuestionary(Integer questionary, String sex) {
        try {
            getEntityManager().getTransaction().begin();
            Query nm = getEntityManager().createNamedQuery(VwUsersex.class.getSimpleName()+".findByQuestionary");
            nm.setParameter("questionary", questionary);
            nm.setParameter("sex", sex);
            return nm.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public List<VwUsersex> allSex(Integer questionary) {
        try {
            getEntityManager().getTransaction().begin();
            Query nm = getEntityManager().createNamedQuery(VwUsersex.class.getSimpleName()+".findAllSex");
            nm.setParameter("questionary", questionary);
            return nm.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
