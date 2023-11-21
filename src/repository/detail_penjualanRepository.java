
package repository;

import entity.detail_penjualan;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import util.Conn;

public class detail_penjualanRepository implements Repository<detail_penjualan>{
    private String tableName = detail_penjualan.tableName;

    @Override
    public List<detail_penjualan> get() {
    String sql = "Select * from "+ tableName;
        List<detail_penjualan> user = new ArrayList<>();
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
    public detail_penjualan get(Integer id) {
    String sql = "select * from "+tableName+" where id = ?";
        detail_penjualan us = new detail_penjualan();
        
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
    public boolean add(detail_penjualan us) {
    String sql = "INSERT INTO "+tableName+" (`id_penjualan`,`id_obat`, `nama_obat`, `harga`, `jumlah_beli`, `sub_total`) VALUES(?,?,?,?,?,?)";
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            
            pst.setInt(1, us.getPenjualan().getId());
            pst.setInt(2, us.getId_obat().getId());
            pst.setString(3, us.getNama_obat());
            pst.setInt(4, us.getHarga());
            pst.setInt(5, us.getJumlah_beli());
            pst.setInt(6, us.getSub_total());
            pst.execute();
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(detail_penjualan us) {
     String sql = "update "+tableName+" set id_penjualan = ?, nama_obat = ?, harga = ?, jumlah_beli = ?, sub_total = ? where id = ?";
        try {
            Connection koneksi =(Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, us.getPenjualan().getId());
            pst.setString(2, us.getNama_obat());
            pst.setInt(3, us.getHarga());
            pst.setInt(4, us.getJumlah_beli());
            pst.setInt(5, us.getSub_total());
            pst.setInt(6, us.getId());
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
    private detail_penjualan mapToEntity(ResultSet res) throws SQLException {
        detail_penjualan us = new detail_penjualan(
                new penjualanRepository().get(res.getInt("id_pembelian")),
                new obatRepository().get(res.getInt("id_obat")),
                res.getString("nama_obat"),
                res.getInt("harga"),
                res.getInt("jumlah_beli"),
                res.getInt("sub_total"));
        us.setId(res.getInt("id"));
        return us;
    }
}
