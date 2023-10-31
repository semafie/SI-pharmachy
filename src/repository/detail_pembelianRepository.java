
package repository;

import entity.detail_pembelian;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import util.Conn;

public class detail_pembelianRepository implements Repository<detail_pembelian>{
    private String tableName = detail_pembelian.tableName;

    @Override
    public List<detail_pembelian> get() {
    String sql = "Select * from "+ tableName;
        List<detail_pembelian> user = new ArrayList<>();
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
    public detail_pembelian get(Integer id) {
    String sql = "select * from "+tableName+" where id = ?";
        detail_pembelian us = new detail_pembelian();
        
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
    public boolean add(detail_pembelian us) {
    String sql = "INSERT INTO "+tableName+"( `id_pembelian`, `nama_obat`, `harga`, `jumlah_beli`, `sub_total`) VALUES(?,?,?,?,?)";
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            
            pst.setInt(1, us.getPembelian().getId());
            pst.setString(2, us.getNama_obat());
            pst.setInt(3, us.getHarga());
            pst.setInt(4, us.getJumlah_beli());
            pst.setInt(5, us.getSub_total());
            pst.execute();
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(detail_pembelian us) {
   String sql = "update "+tableName+" set id_pembelian = ?, nama_obat = ?, harga = ?, jumlah_beli = ?, sub_total = ? where id = ?";
        try {
            Connection koneksi =(Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, us.getPembelian().getId());
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
    
    private detail_pembelian mapToEntity(ResultSet res) throws SQLException {
        detail_pembelian us = new detail_pembelian(
                new pembelianRepository().get(res.getInt("id_pembelian")),
                res.getString("nama_obat"),
                res.getInt("harga"),
                res.getInt("jumlah_beli"),
                res.getInt("sub_total"));
        us.setId(res.getInt("id"));
        return us;
    }
}
