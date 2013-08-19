package com.kaf.hibernate.dao;

import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


public class DaoHelper {

	@Autowired
	SessionFactory sessionFactory;

	Object object;
	
	/**
	 * Empty constructor, can be use if you don't need to know the type of the object
	 * in the transaction
	 */
	public DaoHelper(){

	}

	/**
	 * Constructor with a known class as parameter, change the type of the object
	 * @param className Class name including package
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public DaoHelper(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class c = Class.forName(className);
		setObject(c.newInstance());
	}

	/**
	 * Saves an object on the database and returns the created record id.
	 * @param object Object that is going to be saved on the database
	 * @return The id of the created record
	 * @throws Exception
	 */
	public Long save(Object object) throws Exception{
		Session session = null;
		Transaction transaction = null;
		Long id = null;

		try{

			try{
				/* Si existe una sesión la tomamos */
				session = sessionFactory.getCurrentSession();
			}catch(Exception e){
				/* Si no existe hay que abrir una nueva */
				session = sessionFactory.openSession();
			}

			transaction = session.beginTransaction();


			/*Salvamos el objeto en base de datos*/
			session.save(object);


			/* Esto solo funciona para la nomenclatura Id[Nombre] */
			Method method = object.getClass().getMethod("getId" + object.getClass().getSimpleName());

			id = (Long)method.invoke(object);

			/* Guardamos hasta que todo haya estado OK */
			transaction.commit();
		}catch(Exception e){
			/* Si hay algún error deshacemos el cambio*/
			transaction.rollback();
			e.printStackTrace();

		}finally{
			if(session!=null){
				/* Cerramos la sesión */
				session.close();
			}
		}
		return id;
	}

	/**
	 * Gets an object from the database given an id.
	 * @param id Id (Primary key) of the record in the database.
	 * @return Object with the given id.
	 */
	public Object getById(Long id){
		Session session = null;
		Transaction transaction = null;
		Object returnObject = null;

		try{

			try{
				/* Si existe una sesión la tomamos */
				session = sessionFactory.getCurrentSession();
			}catch(Exception e){
				/* Si no existe hay que abrir una nueva */
				session = sessionFactory.openSession();
			}

			transaction = session.beginTransaction();


			/*Obtenemos el objeto de base de datos*/
			returnObject = session.get(getObject().getClass(), id);


			/* Guardamos hasta que todo haya estado OK */
			transaction.commit();
		}catch(Exception e){
			/* Si hay algún error deshacemos el cambio*/
			transaction.rollback();
			e.printStackTrace();

		}finally{
			if(session!=null){
				/* Cerramos la sesión */
				session.close();
			}
		}
		return returnObject;
	}
	
	/**
	 * Updates a record on the database given an object
	 * @param object Objet that is going to be updated on the database
	 */
	public void update(Object object){
		Session session = null;
		Transaction transaction = null;
		
		try{

			try{
				/* Si existe una sesión la tomamos */
				session = sessionFactory.getCurrentSession();
			}catch(Exception e){
				/* Si no existe hay que abrir una nueva */
				session = sessionFactory.openSession();
			}

			transaction = session.beginTransaction();

			/*Salvamos el objeto en base de datos*/
			session.update(object);
			
			/* Guardamos hasta que todo haya estado OK */
			transaction.commit();
		}catch(Exception e){
			/* Si hay algún error deshacemos el cambio*/
			transaction.rollback();
			e.printStackTrace();

		}finally{
			if(session!=null){
				/* Cerramos la sesión */
				session.close();
			}
		}
	}
	
	public List<Object> getAll(){
		Session session;
	
			try{
				/* Si existe una sesión la tomamos */
				session = sessionFactory.getCurrentSession();
			}catch(Exception e){
				/* Si no existe hay que abrir una nueva */
				session = sessionFactory.openSession();
			}
			
		return session.createCriteria(getObject().getClass()).list();
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
