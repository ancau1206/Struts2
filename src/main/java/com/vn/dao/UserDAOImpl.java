package com.vn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vn.entity.Users;

public class UserDAOImpl implements UserDAO {

	private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public List<Users> getAll() {
		Session session = sessionFactory.openSession();
		List<Users> list = session.createQuery("From Users").list();
		return list;

	}

	@Override
	public Users findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users findByUserame(String username) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		String query = "SELECT u FROM Users u where u.username = :username";

		List<Users> results = session.createQuery(query).setString("username", username).list();
		System.out.println("lilili");
		session.getTransaction().commit();
		session.close();
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public boolean create(Users user) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.save(user);
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
	public boolean update(Users admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
