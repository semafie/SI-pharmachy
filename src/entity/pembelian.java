
package entity;

import java.security.Timestamp;
import java.util.Date;

public class pembelian implements Entity{
    public  static String tableName = "pembelian";
    private supplier supplier;
    private int total_harga;
    private Date tanggal;
    private Timestamp jam;
    
    public pembelian(supplier supplier, Date tanggal, Timestamp jam, int total_harga ) {
    this. supplier = supplier;

    this.tanggal = tanggal;
    this.jam = jam;
    this. total_harga = total_harga;
    }

    public void setJam(Timestamp jam) {
        this.jam = jam;
    }

    public Timestamp getJam() {
        return jam;
    }

    public void setSupplier(supplier supplier) {
        this.supplier = supplier;
    }

    public supplier getSupplier() {
        return supplier;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }

    public int getTotal_harga() {
        return total_harga;
    }
    
    
}
