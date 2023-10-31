
package repository;

import entity.pembelian;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Time;
import util.Conn;

public class pembelianRepository implements Repository<pembelian>{
    private String tableName = pembelian.tableName;

    @Override
    public List<pembelian> get() {
    String sql = "Select * from "+ tableName;
        List<pembelian> user = new ArrayList<>();
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
    public pembelian get(Integer id) {
    String sql = "select * from "+tableName+" where id = ?";
        pembelian us = new pembelian();
        
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
    public boolean add(pembelian us) {
    String sql = "INSERT INTO "+tableName+"( `id_supllier`, `tanggal`, `jam`, `total_harga`) VALUES(?,?,?,?)";
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            
            pst.setInt(1, us.getSupplier().getId());
            pst.setDate(2,new Date(us.getTanggal().getTime()));
            pst.setTime(3, new Time(us.getJam().getTime()));
            pst.setInt(4, us.getTotal_harga());
            pst.execute();
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(pembelian us) {
    String sql = "update "+tableName+" set id_supllier = ?, tanggal = ?, jam = ?, total_harga = ?  where id = ?";
        try {
            Connection koneksi =(Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, us.getSupplier().getId());
            pst.setDate(2, new Date(us.getTanggal().getTime()));
            pst.setTime(3, new Time(us.getJam().getTime()));
            pst.setInt(4, us.getTotal_harga());
            pst.setInt(5, us.getId());
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
    
    private pembelian mapToEntity(ResultSet res) throws SQLException {
        pembelian us = new pembelian(
                new supplierRepository().get(res.getInt("id_supplier")),
                res.getDate("tanggal"),
                res.getTimestamp("jam"),
                res.getInt("total_harga")
        );
        us.setId(res.getInt("id")
        );
        return us;
    }
    
}