/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author VNX
 */
public class TabelModelCustomer extends AbstractTableModel{

    List<Customer> lstCustomer;
    
    public TabelModelCustomer(List<Customer> lstCustomer){
        this.lstCustomer = lstCustomer;
    }
    @Override
    public int getRowCount() {
        return this.lstCustomer.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column)
        {
            case 0:
                return "ID Customer";
            case 1:
                return "Nama Customer";
            case 2:
                return "No Telp Customer";
            case 3:
                return "Alamat";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0:
                return lstCustomer.get(rowIndex).getIdCustomer();
            case 1:
                return lstCustomer.get(rowIndex).getNamaCustomer();
            case 2:
                return lstCustomer.get(rowIndex).getNoTelp();
            case 3:
                return lstCustomer.get(rowIndex).getAlamat();
 
            default:
                return null;
        }
    }

}

