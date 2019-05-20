package com.jjsolution.app.model;

import com.jjsolution.app.Helper.HibernateUtils;
import com.jjsolution.app.entities.Conta;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

public class ContaDAO {

    public List<Conta> getConta(){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            return session.createCriteria(Conta.class)
                    .addOrder(Order.asc("id"))
                    .list();
        } finally {
            session.close();
        }
    }
}
