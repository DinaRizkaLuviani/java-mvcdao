/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class Barang {

    /**
     * @return the Suplier
     */
    public String getSuplier() {
        return Suplier;
    }

    /**
     * @param Suplier the Suplier to set
     */
    public void setSuplier(String Suplier) {
        this.Suplier = Suplier;
    }

    /**
     * @return the IDbrg
     */
    public String getIDbrg() {
        return IDbrg;
    }

    /**
     * @param IDbrg the IDbrg to set
     */
    public void setIDbrg(String IDbrg) {
        this.IDbrg = IDbrg;
    }

    /**
     * @return the NamaBrg
     */
    public String getNamaBrg() {
        return NamaBrg;
    }

    /**
     * @param NamaBrg the NamaBrg to set
     */
    public void setNamaBrg(String NamaBrg) {
        this.NamaBrg = NamaBrg;
    }

    /**
     * @return the HargaBrg
     */
    public String getHargaBrg() {
        return HargaBrg;
    }

    /**
     * @param HargaBrg the HargaBrg to set
     */
    public void setHargaBrg(String HargaBrg) {
        this.HargaBrg = HargaBrg;
    }

    /**
     * @return the Stok
     */
    public Integer getStok() {
        return Stok;
    }

    /**
     * @param Stok the Stok to set
     */
    public void setStok(Integer Stok) {
        this.Stok = Stok;
    }

    /**
     * @return the JenisBrg
     */
    public String getJenisBrg() {
        return JenisBrg;
    }

    /**
     * @param JenisBrg the JenisBrg to set
     */
    public void setJenisBrg(String JenisBrg) {
        this.JenisBrg = JenisBrg;
    }
    private String IDbrg;
    private String NamaBrg;
    private String HargaBrg;
    private Integer Stok;
    private String JenisBrg;
    private String Suplier;
}
