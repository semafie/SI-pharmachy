
package entity;

public class detail_pembelian implements Entity{
    public static String tableName = "detail_pembelian";
    private pembelian pembelian;
    private obat obat;
    private String nama_obat;
    private int harga, jumlah_beli, sub_total, id;
    
    public detail_pembelian(){
        
    }
    
    public detail_pembelian(int id){
        this.id = id;
    }
    public detail_pembelian(pembelian pembelian,obat id_obat, String nama_obat, int jumlah_beli, int sub_total){
    this.pembelian = pembelian;
    this.obat = id_obat;
    this.nama_obat = nama_obat;
    
    this.jumlah_beli = jumlah_beli;
    this.sub_total = sub_total;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getHarga() {
        return harga;
    }

    public void setJumlah_beli(int jumlah_beli) {
        this.jumlah_beli = jumlah_beli;
    }

    public int getJumlah_beli() {
        return jumlah_beli;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setPembelian(pembelian pembelian) {
        this.pembelian = pembelian;
    }

    public pembelian getPembelian() {
        return pembelian;
    }

    public void setSub_total(int sub_total) {
        this.sub_total = sub_total;
    }

    public int getSub_total() {
        return sub_total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setObat(obat obat) {
        this.obat = obat;
    }

    public obat getObat() {
        return obat;
    }
    
    
}
