
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
    
    public pembelian getlastkode() {
    String sql = "select * from "+tableName+" ORDER BY id DESC LIMIT 1";
        pembelian us = new pembelian();
        
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            
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
    String sql = "INSERT INTO "+tableName+"( `kode`,`id_supplier`, `tanggal`, `jam`, `total_harga`,`jumlah_bayar`,`kembalian` ) VALUES (?,?,?,?,?,?,?)";
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, us.getKodepembelian());
            pst.setInt(2, us.getSupplier().getId());
            pst.setDate(3,new Date(us.getTanggal().getTime()));
            pst.setTime(4, new Time(us.getJam().getTime()));
            pst.setInt(5, us.getTotal_harga());
            pst.setInt(6, us.getBayartunai());
            pst.setInt(7, us.getKembalian());
            pst.execute();
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(pembelian us) {
    String sql = "update "+tableName+" set id_supplier = ?, total_harga = ?, jumlah_bayar = ?, kembalian = ?  where id = ?";
        try {
            Connection koneksi =(Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, us.getSupplier().getId());
            pst.setInt(2, us.getTotal_harga());
            pst.setInt(3, us.getBayartunai());
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
                res.getString("kode"),
                new supplierRepository().get(res.getInt("id_supplier")),
                res.getDate("tanggal"),
                res.getTimestamp("jam"),
                res.getInt("total_harga"),
                res.getInt("jumlah_bayar"),
                res.getInt("kembalian")
        );
        us.setId(res.getInt("id")
        );
        return us;
    }
    
}
