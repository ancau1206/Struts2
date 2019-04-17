package com.vn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vn.entity.Departs;
import com.vn.entity.Users;

public class DepartsDAOImpl implements DepartsDAO {
	private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	@SuppressWarnings("unchecked")
	@Override
	public List<Departs> getAll() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		List<Departs> list = session.createQuery("From Departs").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public Departs findById(int id) {
		Session session = sessionFactory.openSession();
		try {
			return (Departs) session.get(Departs.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
		
	}

	@Override
	public Departs findByUserame(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Departs departs) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.save(departs);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			return false;
		} finally {
			session.close();
		}
		
	}

	@Override
	public boolean update(Departs departs) {
		Session session = sessionFactory.openSession();
		System.out.println(departs.getId());
		System.out.println(departs.getCodeId());
		System.out.println(departs.getName());
		try {
			session.getTransaction().begin();
			session.update(departs);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean delete(Departs departs) {
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();
			session.delete(departs);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			return false;
		} finally {
			session.close();
		}
	}

}
