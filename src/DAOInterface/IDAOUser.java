/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOInterface;

import Model.User;

/**
 *
 * @author VNX
 */
public interface IDAOUser {
    User getUserByUsername(String username);
    boolean validateUser(String username, String password);
}
