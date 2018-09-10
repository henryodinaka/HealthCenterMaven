/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package health.center.service;

import health.center.model.Administrator;

/**
 *
 * @author Blaccop Group
 */
public interface AdminService {
    public void createAccount(Administrator admin);
    
    public Administrator login(String username, String password);
}
