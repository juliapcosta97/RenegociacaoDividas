package com.jjsolution.app.model;

import com.jjsolution.app.Helper.HibernateUtils;
import com.jjsolution.app.entities.Divida;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

public class DividaDAO {

    public List<Divida> getDivida(){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            return session.createCriteria(Divida.class)
                    .addOrder(Order.asc("id"))
                    .list();
        } finally {
            session.close();
        }
    }

}
