package com.jatecnologia.ie.core.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jatecnologia.ie.core.entity.IEUser;

@Stateless
public class LoginService {
	  
	  @PersistenceContext(unitName="iePU")
	  private EntityManager em;
	  
	  public IEUser findByLoginAndPassword(String login){
		  Query query  = em.createQuery("SELECT u FROM IEUser u WHERE u.login = :login");
		  
		  query.setParameter("login", login);
		  
		  try{
			  return (IEUser) query.getSingleResult();
		  }catch (NoResultException ex){
			  return null;
		  }																																																																																																																																																																																													  
	  }

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	} 
	  
}																																																																																						
