package com.vn.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vn.entity.Departs;
import com.vn.entity.Records;
import com.vn.entity.Staffs;





public class RecordsImpl implements RecordsDAO {
	private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	StaffsDAOImpl daoImpl;
	@Override
	public List<Object[]> getTop10Records() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		String hql = "SELECT r.staffs.name, SUM(case when r.type=1 then 1 else 0 end), SUM(case when r.type=0 then 1 else 0 end), (SUM(case when r.type=1 then 1 else 0 end) - SUM(case when r.type=0 then 1 else 0 end)), r.staffs.departs.name, r.staffs.photo "
				+ " FROM Records r " + "GROUP BY r.staffs.name,r.staffs.departs.name,r.staffs.photo "
				+ "ORDER BY (SUM(case when r.type=1 then 1 else 0 end) - SUM(case when r.type=0 then 1 else 0 end)) desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(10);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
		
	}
	@Override
	public List<Object[]> getListRecords() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		String hql = "SELECT r.staffs.codeId, r.staffs.name, SUM(case when r.type=1 then 1 else 0 end), SUM(case when r.type=0 then 1 else 0 end), (SUM(case when r.type=1 then 1 else 0 end) - SUM(case when r.type=0 then 1 else 0 end)), r.staffs.departs.name, r.staffs.id "
				+ " FROM Records r " + "GROUP BY r.staffs.codeId,r.staffs.name,r.staffs.departs.name,r.staffs.id";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	@Override
	public List<Object[]> getListRecordsDeparts() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		String hql = "SELECT r.staffs.departs.name, (SUM(case when r.type=1 then 1 else 0 end) - SUM(case when r.type=0 then 1 else 0 end))"
				+ " FROM Records r " + "GROUP BY r.staffs.departs.name";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	@Override
	public boolean insertRecord(Records records) {
		System.out.println(records.getStaffs()+"/n"+records.getType()+"/n"+records.getReason());
		Session session = sessionFactory.openSession();
		
		try {			
			session.getTransaction().begin();			
			
			session.save(records);
			
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			System.out.println("Loi");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

}
