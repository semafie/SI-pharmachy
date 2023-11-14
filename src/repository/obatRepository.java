
package repository;

import entity.obat;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import util.Conn;

public class obatRepository implements Repository<obat>{
    private String tableName = obat.tableName;

    @Override
    public List<obat> get() {
    String sql = "Select * from "+ tableName;
        List<obat> user = new ArrayList<>();
        try {
            Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                user.add(mapToEntity(res));
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
        return user;
    }
    public List<obat> getstoktipis() {
    String sql = "Select * from "+ tableName + " where jumlah_stok <= 10";
        List<obat> user = new ArrayList<>();
        try {
            Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                user.add(mapToEntity(res));
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
        return user;
    }

    @Override
    public obat get(Integer id) {
        String sql = "select * from "+tableName+" where id = ?";
        obat us = new obat();
        
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                return mapToEntity(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return us;
    }

    @Override
    public boolean add(obat us) {
    String sql = "INSERT INTO "+tableName+"( `nama_obat`, `harga_obat`, `jumlah_stok`) VALUES(?,?,?)";
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            
            pst.setString(1, us.getNama_obat());
            pst.setInt(2, us.getHarga_obat());
            pst.setInt(3, us.getJumlah_stok());
            pst.execute();
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(obat us) {
    String sql = "update "+tableName+" set nama_obat = ?, harga_obat = ?  where id = ?";
        try {
            Connection koneksi =(Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, us.getNama_obat());
            pst.setInt(2, us.getHarga_obat());
            
            pst.setInt(3, us.getId());
            pst.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean updatestok(obat us) {
    String sql = "update "+tableName+" jumlah_stok = ?  where id = ?";
        try {
            Connection koneksi =(Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            
            pst.setInt(1, us.getJumlah_stok());
            pst.setInt(2, us.getId());
            pst.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
    String sql = "delete from "+tableName+" where id = ?";
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    
    }
    
    private obat mapToEntity(ResultSet res) throws SQLException {
        obat us = new obat(
                res.getString("nama_obat"),
                res.getInt("harga_obat"),
                res.getInt("jumlah_stok"));
        us.setId(res.getInt("id"));
        return us;
    }
}
