package repository;

import entity.penjualan;
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

public class penjualanRepository implements Repository<penjualan>{
    private String tableName = penjualan.tableName;

    @Override
    public List<penjualan> get() {
    String sql = "Select * from "+ tableName;
        List<penjualan> user = new ArrayList<>();
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

    
    public List<penjualan> getdataterakhir() {
    String sql = "Select * from "+ tableName +"DORDER BY id DESC LIMIT 1";
        List<penjualan> user = new ArrayList<>();
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
    public penjualan get(Integer id) {
   String sql = "select * from "+tableName+" where id = ?";
        penjualan us = new penjualan();
        
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
    public boolean add(penjualan us) {
     String sql = "INSERT INTO "+tableName+"(`kode`, `tanggal`, `jam`, `total_harga`) VALUES(?,?,?,?)";
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            
            pst.setString(1,us.getKodepenjulan());
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
    public boolean update(penjualan us) {
    String sql = "update "+tableName+" set  tanggal = ?, jam = ?, total_harga = ?  where kode = ?";
        try {
            Connection koneksi =(Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setDate(1,new Date(us.getTanggal().getTime()));
            pst.setTime(2, new Time(us.getJam().getTime()));
            pst.setInt(3, us.getTotal_harga());
            pst.setString(4, us.getKodepenjulan());
            
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
    
    private penjualan mapToEntity(ResultSet res) throws SQLException {
        penjualan us = new penjualan(
                res.getString("kode"),
                res.getDate("tanggal"),
                res.getTimestamp("jam"),
                res.getInt("total_harga")
        );
        us.setId(res.getInt("id")
        );
        return us;
    }
}
