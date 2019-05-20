package com.jjsolution.app.model;

import com.jjsolution.app.Helper.HibernateUtils;
import com.jjsolution.app.entities.Acordo;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

public class AcordoDAO {


    public boolean save(Acordo acordo) {
        Session session = null;

        try {
            session = HibernateUtils.openSession();
            session.beginTransaction();
            session.save(acordo);
            session.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            session.close();
        }
    }

    public List<Acordo> getAcordo(){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            return session.createCriteria(Acordo.class)
                    .addOrder(Order.asc("id"))
                    .list();
        } finally {
            session.close();
        }
    }
}
