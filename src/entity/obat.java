
package entity;

public class obat implements Entity{
    public static String tableName = "obat";
    private String nama_obat1, harga_obat, jumlah_stok;
    public obat(){
        
    }
    
    public obat(String nama_obat,String harga_obat, String jumlah_stok){
        this.nama_obat1 = nama_obat;
        this.harga_obat = harga_obat;
        this.jumlah_stok = jumlah_stok;
    }

    public void setHarga_obat(String harga_obat) {
        this.harga_obat = harga_obat;
    }

    public String getHarga_obat() {
        return harga_obat;
    }

    public void setJumlah_stok(String jumlah_stok) {
        this.jumlah_stok = jumlah_stok;
    }

    public String getJumlah_stok() {
        return jumlah_stok;
    }

    public void setNama_obat1(String nama_obat1) {
        this.nama_obat1 = nama_obat1;
    }

    public String getNama_obat1() {
        return nama_obat1;
    }
    
}
