
package entity;

import java.security.Timestamp;
import java.util.Date;

public class penjualan {
    public static String tableName = "penjualan";
    private Date tanggal;
    private Timestamp jam;
    private int total_harga;
    public penjualan(Date tanggal, Timestamp jam, int total_harga){
        this.tanggal = tanggal; 
        this.jam =jam;
        this.total_harga = total_harga;
    }

    public void setJam(Timestamp jam) {
        this.jam = jam;
    }

    public Timestamp getJam() {
        return jam;
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
