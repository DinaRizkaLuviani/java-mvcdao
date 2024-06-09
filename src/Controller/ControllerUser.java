/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import DAO.DAOUser;
import DAOInterface.IDAOUser;
import Model.User;
import View.FormLogin;
/**
 *
 * @author VNX
 */
public class ControllerUser {
    private DAOUser userDAO;
    FormLogin frmLogin;
    IDAOUser iUser;

    public ControllerUser() {
        userDAO = new DAOUser();
    }
    
    public ControllerUser(FormLogin frmLogin){
        this.frmLogin = frmLogin;
        userDAO = new DAOUser();
        iUser = new DAOUser();
    }

    public boolean login(String username, String password) {
        return userDAO.validateUser(username, password);
    }

    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

   
}
