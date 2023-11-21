package entity;

public class detail_penjualan implements Entity{
    public static String tableName = "detail_penjualan";
    private penjualan penjualan;
    private String nama_obat;
    private obat id_obat;
    private int harga, jumlah_beli, sub_total, id;
    public detail_penjualan(){
        
    }
    
    public detail_penjualan(penjualan penjualan,obat id_obat, String nama_obat,int harga, int jumlah_beli,int sub_total){
        this.penjualan = penjualan;
        this.id_obat = id_obat;
        this.nama_obat = nama_obat;
        this.harga = harga;
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

    public void setPenjualan(penjualan penjualan) {
        this.penjualan = penjualan;
    }

    public penjualan getPenjualan() {
        return penjualan;
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

    public void setId_obat(obat id_obat) {
        this.id_obat = id_obat;
    }

    public obat getId_obat() {
        return id_obat;
    }
    
    
    
}
