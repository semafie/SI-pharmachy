
package entity;

public class supplier implements Entity{
    public  static String tableName = "supplier";
    private String nama_supplier, no_tlp, alamat;
    private int  id;
    public supplier(){
        
    }
    public supplier(int id){
        this.id = id;
    }
    
    public supplier(String nama_supplier, String no_tlp,String alamat){
        this.nama_supplier = nama_supplier;
        this.no_tlp = no_tlp;
        this.alamat = alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setNama_supplier(String nama_supplier) {
        this.nama_supplier = nama_supplier;
    }

    public String getNama_supplier() {
        return nama_supplier;
    }

    public void setNo_tlp(String no_tlp) {
        this.no_tlp = no_tlp;
    }

    public String getNo_tlp() {
        return no_tlp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    
}
