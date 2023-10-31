
package entity;

public class user implements Entity{
    public static String tableName = "user";
    private String nama, username, password, email, jenis_kelamin, alamat, no_tlp, token;
    private int id, level;
    
    public  user(){
        
    }
    
    public  user(String nama, String username,String password, String email, String jenis_kelamin,String alamat, String no_tlp,int level, String token){
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.email = email;
        this.jenis_kelamin = jenis_kelamin;
        this.alamat = alamat;
        this.no_tlp = no_tlp;
        this.token = token;
        this.level = level;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_tlp() {
        return no_tlp;
    }

    public void setNo_tlp(String no_tlp) {
        this.no_tlp = no_tlp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }
    
    
}
