
package entity;

public class obat implements Entity{
    public static String tableName = "obat";
    private String nama_obat;
    private int id, harga_obat, jumlah_stok;
    
    public obat(){
        
    }
    
    public obat(int id,String nama_obat,int harga_obat){
        this.id = id;
        this.nama_obat = nama_obat;
        this.harga_obat = harga_obat;
        this.jumlah_stok = jumlah_stok;
    }
    
    public obat(String nama_obat,int harga_obat, int jumlah_stok){
        this.nama_obat = nama_obat;
        this.harga_obat = harga_obat;
        this.jumlah_stok = jumlah_stok;
    }
    
    public obat(int id ,int jumlah_stok){
        this.id = id;
        this.jumlah_stok = jumlah_stok;
    }

    public void setHarga_obat(int harga_obat) {
        this.harga_obat = harga_obat;
    }

    public int getHarga_obat() {
        return harga_obat;
    }

    public void setJumlah_stok(int jumlah_stok) {
        this.jumlah_stok = jumlah_stok;
    }

    public int getJumlah_stok() {
        return jumlah_stok;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}
