package com.jjsolution.app.model;

import com.jjsolution.app.Helper.HibernateUtils;
import com.jjsolution.app.entities.Conta;
import com.jjsolution.app.entities.Pagamentos;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

public class PagamentosDAO {

    public List<Pagamentos> getPagamentos(){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            return session.createCriteria(Pagamentos.class)
                    .addOrder(Order.asc("id"))
                    .list();
        } finally {
            session.close();
        }
    }

    public boolean save(Pagamentos pagamento) {
        Session session = null;

        try {
            session = HibernateUtils.openSession();
            session.beginTransaction();
            session.save(pagamento);
            session.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            session.close();
        }
    }
}
