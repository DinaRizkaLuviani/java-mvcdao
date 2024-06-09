/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;



/**
 *
 * @author Lenovo
 */
public class Pemesanan {

    /**
     * @return the IDpsn
     */
    public Integer getIDpsn() {
        return IDpsn;
    }

    /**
     * @param IDpsn the IDpsn to set
     */
    public void setIDpsn(Integer IDpsn) {
        this.IDpsn = IDpsn;
    }

    /**
     * @return the tanggalPsn
     */
    public Timestamp getTanggalPsn() {
        return tanggalPsn;
    }

    /**
     * @param tanggalPsn the tanggalPsn to set
     */
    public void setTanggalPsn(Timestamp tanggalPsn) {
        this.tanggalPsn = tanggalPsn;
    }

    /**
     * @return the BarangPsn
     */
    public String getBarangPsn() {
        return BarangPsn;
    }

    /**
     * @param BarangPsn the BarangPsn to set
     */
    public void setBarangPsn(String BarangPsn) {
        this.BarangPsn = BarangPsn;
    }

    /**
     * @return the totHarga
     */
    public String getTotHarga() {
        return totHarga;
    }

    /**
     * @param totHarga the totHarga to set
     */
    public void setTotHarga(String totHarga) {
        this.totHarga = totHarga;
    }

    /**
     * @return the IDcust
     */
    public Integer getIDcust() {
        return IDcust;
    }

    /**
     * @param IDcust the IDcust to set
     */
    public void setIDcust(Integer IDcust) {
        this.IDcust = IDcust;
    }
    private Integer IDpsn;
    private Timestamp tanggalPsn;
    private String BarangPsn;
    private String totHarga;
    private Integer IDcust;
    
}
