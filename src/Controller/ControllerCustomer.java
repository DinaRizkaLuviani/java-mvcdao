/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOBarang;
import DAO.DAOCustomer;
import DAOInterface.IDAOCustomer;
import Model.Customer;
import Model.TabelModelCustomer;
import View.FormCustomer;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class ControllerCustomer {
    private DAOCustomer customerDAO;
    FormCustomer frmCustomer;
    IDAOCustomer iCustomer;
    List<Customer> lstCustomer;

    public ControllerCustomer() {
        customerDAO = new DAOCustomer();
    }
    
    public ControllerCustomer(FormCustomer frmCustomer){
        this.frmCustomer = frmCustomer;
        customerDAO = new DAOCustomer();
        iCustomer = new DAOCustomer();
    }
    
    public void isiTable()
    {
       lstCustomer = iCustomer.getAllCustomers();
       TabelModelCustomer tabelCustomer = new TabelModelCustomer(lstCustomer);
       frmCustomer.getTabelData().setModel(tabelCustomer);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public void addCustomer() {
        Customer c = new Customer();
        c.setIdCustomer(frmCustomer.gettxtIdCustomer().getText());
        c.setNamaCustomer(frmCustomer.gettxtNamaCustomer().getText());
        c.setNoTelp(frmCustomer.gettxtTelpCustomer().getText());
        c.setAlamat(frmCustomer.gettxtAlamat().getText());
        boolean res = iCustomer.addCustomer(c);
        if(res)
            JOptionPane.showMessageDialog(null, "input berhasil");
        else
            JOptionPane.showMessageDialog(null, "Gagal/data duplikat");
    }

    public void updateCustomer() {
        Customer c = new Customer();
        c.setNamaCustomer(frmCustomer.gettxtNamaCustomer().getText());
        c.setNoTelp(frmCustomer.gettxtTelpCustomer().getText());
        c.setAlamat(frmCustomer.gettxtAlamat().getText());
        c.setIdCustomer(frmCustomer.gettxtIdCustomer().getText());
        iCustomer.updateCustomer(c);
    }

    public void deleteCustomer() {
        Customer c = new Customer();
        String idCustomer = frmCustomer.gettxtIdCustomer().getText();
        iCustomer.deleteCustomer(idCustomer);
    }

    public Customer getCustomerById(String idCustomer) {
        return customerDAO.getCustomerById(idCustomer);
    }
    
    public void reset(){
        frmCustomer.gettxtIdCustomer().setText("");
        frmCustomer.gettxtNamaCustomer().setText("");
        frmCustomer.gettxtTelpCustomer().setText("");
        frmCustomer.gettxtAlamat().setText("");
    }
    
    public void isiField(int row)
    {
        frmCustomer.gettxtIdCustomer().setEnabled(false);
        frmCustomer.gettxtIdCustomer().setText(lstCustomer.get(row).getIdCustomer().toString());
        frmCustomer.gettxtNamaCustomer().setText(lstCustomer.get(row).getNamaCustomer().toString());
        frmCustomer.gettxtTelpCustomer().setText(lstCustomer.get(row).getNoTelp());
        frmCustomer.gettxtAlamat().setText(lstCustomer.get(row).getAlamat());
        
    }

}
