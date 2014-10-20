package com.epam.employeesdb.dao.impl;

import java.util.Formatter;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epam.employeesdb.dao.EntityDAO;
import com.epam.employeesdb.model.Entity;
import com.epam.employeesdb.util.HibernateUtil;

public abstract class AbstractEntityDAO<T extends Entity> implements
		EntityDAO<T> {
	private Class<?> entityClass;
	private static SessionFactory sessionFactory;

	public AbstractEntityDAO(Class<?> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public T get(Integer id) {
		Session session = getConfiguredSessionFactory().openSession();
		session.beginTransaction();
		T entity = (T) session.get(entityClass, id);
		session.getTransaction().commit();
		session.close();

		return entity;
	}

	@Override
	public void create(T entity) {
		Session session = getConfiguredSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void create(List<T> entityList) {
		Session session = getConfiguredSessionFactory().openSession();
		try {
			session.beginTransaction();
			for (int i = 0; i < entityList.size(); i++) {
				session.save(entityList.get(i));
				if (i % 20 == 0) {
					session.flush();
			        session.clear();
				}
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(Integer id) {
		Session session = getConfiguredSessionFactory().openSession();
		String deleteQ = "delete from %s where id=:id";
		Formatter f = new Formatter();
		try {
			session.beginTransaction();
			Query q = session.createQuery(f.format(deleteQ, entityClass.getSimpleName()).toString());
			q.setParameter("id", id);
			q.executeUpdate();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			f.close();
			session.close();
		}
	}

	@Override
	public void update(T entity) {
		Session session = getConfiguredSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	protected SessionFactory getConfiguredSessionFactory() {
		if (sessionFactory == null) {
			synchronized (this) {
				if (sessionFactory == null) {
					sessionFactory = HibernateUtil
							.buildAndConfigureSessionFactory();
				}
			}
		}

		return sessionFactory;
	}
}
