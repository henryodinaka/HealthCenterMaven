/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package health.center.service;

import health.center.model.Administrator;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Blaccop Group
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void createAccount(Administrator admin) {
        sessionFactory.getCurrentSession().save(admin);
    }

    @Override
    public Administrator login(String username, String password) {
        return (Administrator) sessionFactory.getCurrentSession()
                .createQuery("FROM Administrator WHERE username = :username AND password = :password")
                .setParameter("username", username)
                .setParameter("password", password)
                .uniqueResult();
    }
    
}
