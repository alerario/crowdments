/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.crud;

import br.edu.utfpr.r4c.crowdments.entities.VwUserswithanwsersMail;
import br.edu.utfpr.r4c.crowdments.util.DefaultParams;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ricar
 */
public class VwUserswithanwsersMailCrud extends FacadeCrud<VwUserswithanwsersMail> {

    private EntityManager em;

    public VwUserswithanwsersMailCrud() {
        super(VwUserswithanwsersMail.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(DefaultParams.PU).createEntityManager();
        }
        return em;
    }

    public List<VwUserswithanwsersMail> getEmails(Integer id) {
        try {
            getEntityManager().getTransaction().begin();

            return getEntityManager().createNamedQuery(VwUserswithanwsersMail.class.getSimpleName() + ".findByQuestionary").setParameter("questionary", id).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
