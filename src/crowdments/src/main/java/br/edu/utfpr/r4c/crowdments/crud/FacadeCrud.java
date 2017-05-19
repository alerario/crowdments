/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.crud;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ricar
 */
public abstract class FacadeCrud<T> {
    //Objeto da classe referência
    private Class<T> entityClass;

    //construtor que recebe a tipagem da mesma
    public FacadeCrud(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    //método abstrato para obter o EM na implementação
    protected abstract EntityManager getEntityManager();

    //salvar e persistir o objeto
    public void persist(T entity) {
    	try{
    		getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().getTransaction().commit();
    	}catch(Exception ex){
    		System.out.println("A persistência de " + entity.getClass().getSimpleName() + " falhou! Rollback em ação.");
    	}        
    }

    public void merge(T entity) {
    	try{
    		getEntityManager().getTransaction().begin();
            getEntityManager().merge(entity);
            getEntityManager().getTransaction().commit();
    	}catch(Exception ex){
    		System.out.println("A persistência de " + entity.getClass().getSimpleName() + " falhou! Rollback em ação.");
    	}                
    }

    public void remove(T entity) {
    	try{
    		getEntityManager().getTransaction().begin();
            getEntityManager().remove(getEntityManager().merge(entity));
            getEntityManager().getTransaction().commit();
    	}
    	catch(Exception ex){
    		System.out.println("A persistência de " + entity.getClass().getSimpleName() + " falhou! Rollback em ação.");
    	}            
    }

    //encontrar por objeto
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    
    //encontrar por identificador
    public T byId(Integer id) {
        try {
            return (T) getEntityManager().createNamedQuery(this.entityClass.getSimpleName().toString() +".findById").setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //obter todos entity
    public List<T> getAll() {
        try{
	        return getEntityManager().createNamedQuery(this.entityClass.getSimpleName().toString() +".findAll").getResultList();
        }catch(Exception e){
        	getEntityManager().getTransaction().rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
