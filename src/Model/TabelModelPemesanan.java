/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class TabelModelPemesanan extends AbstractTableModel{
    
    public TabelModelPemesanan(List<Pemesanan> lstPmsn){
        this.lstPmsn = lstPmsn;
        
        
    }
    @Override
    public int getRowCount() {
        return this.lstPmsn.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column)
        {
            case 0:
                return "ID Pesanan";
            case 1:
                return "Tanggal Pesan";
            case 2:
                return "Barang Pesanan";
            case 3:
                return "Total Harga";
            case 4:
                return "ID Customer";   
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0:
                return lstPmsn.get(rowIndex).getIDpsn();
            case 1:
                return lstPmsn.get(rowIndex).getTanggalPsn();
            case 2:
                return lstPmsn.get(rowIndex).getBarangPsn();
            case 3:
                return lstPmsn.get(rowIndex).getTotHarga();
            case 4:
                return lstPmsn.get(rowIndex).getIDcust();   
            default:
                return null;
        }
    }
    List<Pemesanan> lstPmsn;
}
