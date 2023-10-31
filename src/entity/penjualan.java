
package entity;

import java.sql.Timestamp;
import java.util.Date;

public class penjualan implements Entity{
    public static String tableName = "penjualan";
    private Date tanggal;
    private Timestamp jam;
    private int total_harga, id;
    
    public penjualan(){
        
    }
    
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
     
   
}
