package com.jjsolution.app.model;

import com.jjsolution.app.Helper.HibernateUtils;
import com.jjsolution.app.entities.Cliente;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

public class ClienteDAO {

    public List<Cliente> getCliente(){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            return session.createCriteria(Cliente.class)
                    .addOrder(Order.asc("id"))
                    .list();
        } finally {
            session.close();
        }
    }
}
