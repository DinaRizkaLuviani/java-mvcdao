/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOInterface;

import Model.Customer;
import java.util.List;

/**
 *
 * @author VNX
 */
public interface  IDAOCustomer {
    List<Customer> getAllCustomers();
    boolean addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(String idCustomer);
    Customer getCustomerById(String idCustomer);
}
