
package repository;

import entity.supplier;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conn;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class supplierRepository implements Repository<supplier>{
    private String tableName = supplier.tableName;
    @Override
    public List<supplier> get() {
    String sql = "Select * from "+ tableName;
        List<supplier> user = new ArrayList<>();
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
    public supplier get(Integer id) {
        String sql = "select * from "+tableName+" where id = ?";
        supplier us = new supplier();
        
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
    public boolean add(supplier us) {
    String sql = "INSERT INTO "+tableName+"( `nama_supplier`, `no_tlp`, `alamat`) VALUES(?,?,?)";
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            
            pst.setString(1, us.getNama_supplier());
            pst.setString(2, us.getNo_tlp());
            pst.setString(3, us.getAlamat());
            pst.execute();
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(supplier us) {
    String sql = "update "+tableName+" set nama_supplier = ?, no_tlp = ?, alamat = ?  where id = ?";
        try {
            Connection koneksi =(Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, us.getNama_supplier());
            pst.setString(2, us.getNo_tlp());
            pst.setString(3, us.getAlamat());
            pst.setInt(4, us.getId());
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
    
    private supplier mapToEntity(ResultSet res) throws SQLException {
        supplier us = new supplier(
                res.getString("nama_supplier"),
                res.getString("no_tlp"),
                res.getString("alamat"));
        us.setId(res.getInt("id"));
        return us;
    }
}
