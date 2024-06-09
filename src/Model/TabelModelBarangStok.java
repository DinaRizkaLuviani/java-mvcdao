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
public class TabelModelBarangStok extends AbstractTableModel{
    
    public TabelModelBarangStok (List<Barang>lstBrg){
        this.lstBrg = lstBrg;
    }
    
    @Override
    public int getRowCount() {
        return this.lstBrg.size();
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
                return "Nama Barang";
            case 1:
                return "Harga Barang";
            case 2:
                return "Stok";
            case 3:
                return "Jenis Barang";   
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lstBrg.get(rowIndex).getNamaBrg();
            case 1:
                return lstBrg.get(rowIndex).getHargaBrg();
            case 2:
                return lstBrg.get(rowIndex).getStok();
            case 3:
                return lstBrg.get(rowIndex).getJenisBrg();
            default:
                return null;
        }

    }
    
    List<Barang> lstBrg;

}
