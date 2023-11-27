
package entity;

import java.sql.Timestamp;
import java.util.Date;

public class penjualan implements Entity{
    public static String tableName = "penjualan";
    private String kodepenjulan;
    private Date tanggal;
    private Timestamp jam;
    private int total_harga, id, kembalian, jumlahbayar;
    
    public penjualan(){
        
    }
    
    public penjualan(int id){
        this.id =  id;
    }
    
    public penjualan(String kode,Date tanggal, Timestamp jam, int total_harga, int jumlahbayar, int kembali){
        this.kodepenjulan = kode;
        this.tanggal = tanggal; 
        this.jam =jam;
        this.total_harga = total_harga;
        this.jumlahbayar = jumlahbayar;
        this.kembalian = kembali;
    }
    
    public penjualan(int id, int total_harga, int jumlahbayar, int kembali){
        this.id = id;
        
        this.total_harga = total_harga;
        this.jumlahbayar = jumlahbayar;
        this.kembalian = kembali;
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

    public void setKodepenjulan(String kodepenjulan) {
        this.kodepenjulan = kodepenjulan;
    }

    public String getKodepenjulan() {
        return kodepenjulan;
    }

    public void setJumlahbayar(int jumlahbayar) {
        this.jumlahbayar = jumlahbayar;
    }

    public int getJumlahbayar() {
        return jumlahbayar;
    }

    public void setKembalian(int kembalian) {
        this.kembalian = kembalian;
    }

    public int getKembalian() {
        return kembalian;
    }
     
   
}
