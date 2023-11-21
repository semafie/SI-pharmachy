
package entity;

import java.sql.Timestamp;
import java.util.Date;

public class pembelian implements Entity{
    public  static String tableName = "pembelian";
    private String kodepembelian;
    private supplier supplier;
    private int total_harga, id, bayartunai, kembalian;
    private Date tanggal;
    private Timestamp jam;
    
    public pembelian(){
        
    }
    public pembelian(int id){
        this.id = id;
    }
    public pembelian(supplier supplier, Date tanggal, Timestamp jam, int total_harga ) {
    this. supplier = supplier;

    this.tanggal = tanggal;
    this.jam = jam;
    this. total_harga = total_harga;
    }
    public pembelian(String kode, supplier supplier, Date tanggal, Timestamp jam, int total_harga, int bayartunai, int kembalian) {
    this. supplier = supplier;
    this.kodepembelian = kode;
    this.tanggal = tanggal;
    this.jam = jam;
    this. total_harga = total_harga;
    this.bayartunai = bayartunai;
    this.kembalian= kembalian;
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setKodepembelian(String kodepembelian) {
        this.kodepembelian = kodepembelian;
    }

    public String getKodepembelian() {
        return kodepembelian;
    }

    public void setBayartunai(int bayartunai) {
        this.bayartunai = bayartunai;
    }

    public int getBayartunai() {
        return bayartunai;
    }

    public void setKembalian(int kembalian) {
        this.kembalian = kembalian;
    }

    public int getKembalian() {
        return kembalian;
    }
    
    
}
