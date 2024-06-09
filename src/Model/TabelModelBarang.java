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
public class TabelModelBarang extends AbstractTableModel{

    public TabelModelBarang(List<Barang> lstBrg){
        this.lstBrg = lstBrg;
        
        
    }
    @Override
    public int getRowCount() {
        return this.lstBrg.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column)
        {
            case 0:
                return "ID Barang";
            case 1:
                return "Nama Barang";
            case 2:
                return "Harga Barang";
            case 3:
                return "Stok";
            case 4:
                return "Jenis Barang";  
            case 5:
                return "Suplier";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0:
                return lstBrg.get(rowIndex).getIDbrg();
            case 1:
                return lstBrg.get(rowIndex).getNamaBrg();
            case 2:
                return lstBrg.get(rowIndex).getHargaBrg();
            case 3:
                return lstBrg.get(rowIndex).getStok();
            case 4:
                return lstBrg.get(rowIndex).getJenisBrg();  
            case 5:
                return lstBrg.get(rowIndex).getSuplier();
            default:
                return null;
        }
    }
    
    List<Barang> lstBrg;
}
