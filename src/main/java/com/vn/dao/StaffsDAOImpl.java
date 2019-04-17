package com.vn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vn.entity.Staffs;

public class StaffsDAOImpl implements StaffsDAO{
	@SuppressWarnings("deprecation")
	private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	@Override
	public List<Staffs> getAll() {
		
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Staffs> list = session.createQuery("From Staffs").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public Staffs findById(int id) {
		Session session = sessionFactory.openSession();
		try {
			return (Staffs) session.get(Staffs.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public Staffs findByCodeId(String codeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Staffs staffs) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.save(staffs);
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
	public boolean update(Staffs staffs) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.update(staffs);
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
	public boolean delete(Staffs staffs) {
		
		Session session = sessionFactory.openSession();

		try {
			session.getTransaction().begin();
			session.delete(staffs);
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
