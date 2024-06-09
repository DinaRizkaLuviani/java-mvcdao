/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOPemesanan;
import DAOInterface.IDAOPemesanan;
import Model.Pemesanan;
import Model.TabelModelPemesanan;
import View.FormPemesanan;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.time.LocalDateTime;
/**
 *
 * @author Lenovo
 */
public class ControllerPemesanan {
    
    public ControllerPemesanan(FormPemesanan frmPemesanan){
        this.frmPemesanan = frmPemesanan;
        iPemesanan = new DAOPemesanan();
    }
    
    public void isiTable(){
        lstPmsn = iPemesanan.getAll();
        TabelModelPemesanan tabelPmsn = new TabelModelPemesanan(lstPmsn);
        frmPemesanan.getTabelData().setModel(tabelPmsn);
    }
    
    public void insert()
    {
        Pemesanan p = new Pemesanan();
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        p.setIDpsn(Integer.parseInt(frmPemesanan.gettxtIDpsn().getText()));
        p.setTanggalPsn(timestamp);
        p.setBarangPsn(frmPemesanan.gettxtBarangPsn().getText());
        p.setTotHarga(frmPemesanan.gettxtTotalHarga().getText());
        p.setIDcust(Integer.parseInt(frmPemesanan.gettxtIDcust().getText()));
        
        boolean res = iPemesanan.insert(p);
        if(res)
            JOptionPane.showConfirmDialog(null, "input berhasil");
        else
            JOptionPane.showConfirmDialog(null, "Gagal/data duplikat");
           
    }
    
    public void reset()
    {
        if(!frmPemesanan.gettxtIDpsn().isEnabled())
            frmPemesanan.gettxtIDpsn().setEnabled(true);
        frmPemesanan.gettxtIDpsn().setText("");
        frmPemesanan.gettxtTanggalPsn().setText("");
        frmPemesanan.gettxtBarangPsn().setText("");
        frmPemesanan.gettxtTotalHarga().setText("");
        frmPemesanan.gettxtIDcust().setText("");
    }
    
    public void isiField(int row)
    {
        frmPemesanan.gettxtIDpsn().setEnabled(false);
        frmPemesanan.gettxtIDpsn().setText(lstPmsn.get(row).getIDpsn().toString());
        frmPemesanan.gettxtTanggalPsn().setText(lstPmsn.get(row).getTanggalPsn().toString());
        frmPemesanan.gettxtBarangPsn().setText(lstPmsn.get(row).getBarangPsn());
        frmPemesanan.gettxtTotalHarga().setText(lstPmsn.get(row).getTotHarga());
        frmPemesanan.gettxtIDcust().setText(lstPmsn.get(row).getIDcust().toString());
        
    }
    
    public void update()
    {
        Pemesanan p = new Pemesanan();
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        p.setTanggalPsn(timestamp);
        p.setBarangPsn(frmPemesanan.gettxtBarangPsn().getText());
        p.setTotHarga(frmPemesanan.gettxtTotalHarga().getText());
        p.setIDcust(Integer.parseInt(frmPemesanan.gettxtIDcust().getText()));
        p.setIDpsn(Integer.parseInt(frmPemesanan.gettxtIDpsn().getText()));
        
        iPemesanan.update(p);
        JOptionPane.showConfirmDialog(null, "update berhasil");
    }
    
    public void delete()
    {
        Pemesanan p = new Pemesanan();
        p.setIDpsn(Integer.parseInt(frmPemesanan.gettxtIDpsn().getText()));
        iPemesanan.delete(p);
        JOptionPane.showConfirmDialog(null, "delete berhasil");
    }
    
    public void cari(){
        lstPmsn = iPemesanan.getAllByName(frmPemesanan.gettxtCariPesanan().getText());
        TabelModelPemesanan tabelPmsn = new TabelModelPemesanan(lstPmsn);
        frmPemesanan.getTabelData().setModel(tabelPmsn);
    }
    
    FormPemesanan frmPemesanan;
    IDAOPemesanan iPemesanan;
    List<Pemesanan> lstPmsn;
}
