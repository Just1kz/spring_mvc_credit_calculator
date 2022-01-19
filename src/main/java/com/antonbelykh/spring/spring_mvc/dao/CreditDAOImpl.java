package com.antonbelykh.spring.spring_mvc.dao;

import com.antonbelykh.spring.spring_mvc.entity.Credit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CreditDAOImpl implements CreditDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CreditDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Credit> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Credit", Credit.class).getResultList();
    }

    @Override
    public Credit getId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Credit.class, id);
    }

    @Override
    public void saveOrUpdate(Credit credit) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(credit);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Credit credit = getId(id);
        session.delete(credit);
    }

    @Override
    public void deleteScheduleAfterUpdateCreditParams(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Payment where credit.id =:creditId");
        query.setParameter("creditId", id);
        query.executeUpdate();
    }
}
