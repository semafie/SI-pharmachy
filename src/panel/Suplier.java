/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panel;
import entity.supplier;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import main.main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import repository.supplierRepository;
import util.Conn;
import view.dialog.Validasilogout1;
import view.dialog.editSupplier;
import view.dialog.tambahSupplier;

/**
 *
 * @author RESCOM-1
 */
public class Suplier extends javax.swing.JPanel {
    public static int id;
    supplierRepository supp = new supplierRepository();
    public Suplier() {
        initComponents();
        load_tabel();
    }
    public void load_tabel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAMA_OBAT");
        model.addColumn("NO TELP");
        model.addColumn("ALAMAT");
    
        try {
            for(supplier apa:supp.get()){
                model.addRow(new Object[]{
                    apa.getId(),
                    apa.getNama_supplier(),
                    apa.getNo_tlp(),
                    apa.getAlamat()

                });
            }
            table.setModel(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void load_tabel(String search) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("NAMA_SUPPLIER");
    model.addColumn("NO_TELP");
    model.addColumn("ALAMAT");

    try {
        String sql = "SELECT * FROM supplier WHERE id LIKE ? OR nama_supplier LIKE ?";
        Connection koneksi = (Connection) Conn.configDB();
        PreparedStatement pst = koneksi.prepareStatement(sql);
        pst.setString(1, "%" + search + "%");
        pst.setString(2, "%" + search + "%");

        ResultSet res = pst.executeQuery();

        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("id"),
                res.getString("nama_supplier"),
                res.getString("no_tlp"),
                res.getString("alamat")
            });
        }

        table.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSuplier = new javax.swing.JLabel();
        btnObat = new javax.swing.JLabel();
        btnTransaksi = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JLabel();
        btnPegawai = new javax.swing.JLabel();
        btnDasboard = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new view.swing.Table();
        btnTambah = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnHapus = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setLayout(null);

        btnSuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsupplier1.png"))); // NOI18N
        add(btnSuplier);
        btnSuplier.setBounds(10, 295, 230, 60);

        btnObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnobat2.png"))); // NOI18N
        btnObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnObatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnObatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnObatMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnObatMousePressed(evt);
            }
        });
        add(btnObat);
        btnObat.setBounds(10, 220, 230, 60);

        btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btntransaksi2.png"))); // NOI18N
        btnTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransaksiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTransaksiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTransaksiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTransaksiMousePressed(evt);
            }
        });
        add(btnTransaksi);
        btnTransaksi.setBounds(10, 370, 230, 60);

        btnLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlaporan2.png"))); // NOI18N
        btnLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaporanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLaporanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLaporanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLaporanMousePressed(evt);
            }
        });
        add(btnLaporan);
        btnLaporan.setBounds(10, 445, 230, 60);

        btnPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnpegawai2.png"))); // NOI18N
        btnPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPegawaiMousePressed(evt);
            }
        });
        add(btnPegawai);
        btnPegawai.setBounds(10, 520, 230, 60);

        btnDasboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btndashboard2.png"))); // NOI18N
        btnDasboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDasboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDasboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDasboardMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDasboardMousePressed(evt);
            }
        });
        add(btnDasboard);
        btnDasboard.setBounds(10, 140, 230, 60);

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlogout1.png"))); // NOI18N
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLogoutMousePressed(evt);
            }
        });
        add(btnLogout);
        btnLogout.setBounds(0, 680, 230, 50);

        jScrollPane1.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        add(jScrollPane1);
        jScrollPane1.setBounds(300, 220, 990, 470);

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformtambah1.png"))); // NOI18N
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTambahMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTambahMousePressed(evt);
            }
        });
        add(btnTambah);
        btnTambah.setBounds(280, 120, 195, 60);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformedit1.png"))); // NOI18N
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEditMousePressed(evt);
            }
        });
        add(btnEdit);
        btnEdit.setBounds(480, 120, 135, 60);

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformhapus1.png"))); // NOI18N
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHapusMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHapusMousePressed(evt);
            }
        });
        add(btnHapus);
        btnHapus.setBounds(620, 120, 170, 60);

        search.setBackground(new Color(0,0,0,0));
        search.setBorder(null);
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        add(search);
        search.setBounds(1010, 130, 300, 30);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/bg Supplier.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1366, 768);
    }// </editor-fold>//GEN-END:initComponents

    private void btnObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMouseClicked
        main main = (main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showObat();
    }//GEN-LAST:event_btnObatMouseClicked

    private void btnObatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMouseEntered
        btnObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnobat3.png")));
    }//GEN-LAST:event_btnObatMouseEntered

    private void btnObatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMouseExited
        btnObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnobat2.png")));
    }//GEN-LAST:event_btnObatMouseExited

    private void btnObatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMousePressed
        btnObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnobat4.png")));
    }//GEN-LAST:event_btnObatMousePressed

    private void btnTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseClicked
    main main = (main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showTransaksi();
    }//GEN-LAST:event_btnTransaksiMouseClicked

    private void btnTransaksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseEntered
        btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btntransaksi3.png")));
    }//GEN-LAST:event_btnTransaksiMouseEntered

    private void btnTransaksiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseExited
        btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btntransaksi2.png")));
    }//GEN-LAST:event_btnTransaksiMouseExited

    private void btnTransaksiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMousePressed
        btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btntransaksi4.png")));
    }//GEN-LAST:event_btnTransaksiMousePressed

    private void btnLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseClicked
    main main = (main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showLaporan();
    }//GEN-LAST:event_btnLaporanMouseClicked

    private void btnLaporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseEntered
        btnLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlaporan3.png")));
    }//GEN-LAST:event_btnLaporanMouseEntered

    private void btnLaporanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseExited
        btnLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlaporan2.png")));
    }//GEN-LAST:event_btnLaporanMouseExited

    private void btnLaporanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMousePressed
        btnLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlaporan4.png")));
    }//GEN-LAST:event_btnLaporanMousePressed

    private void btnPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseClicked
    main main = (main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showPegawai();
    }//GEN-LAST:event_btnPegawaiMouseClicked

    private void btnPegawaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseEntered
        btnPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnpegawai3.png")));
    }//GEN-LAST:event_btnPegawaiMouseEntered

    private void btnPegawaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseExited
        btnPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnpegawai2.png")));
    }//GEN-LAST:event_btnPegawaiMouseExited

    private void btnPegawaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMousePressed
        btnPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnpegawai4.png")));
    }//GEN-LAST:event_btnPegawaiMousePressed

    private void btnDasboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDasboardMouseClicked
        main main =(main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showDasboardOwner();
    }//GEN-LAST:event_btnDasboardMouseClicked

    private void btnDasboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDasboardMouseEntered
        btnDasboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btndashboard3.png")));
    }//GEN-LAST:event_btnDasboardMouseEntered

    private void btnDasboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDasboardMouseExited
        btnDasboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btndashboard2.png")));
    }//GEN-LAST:event_btnDasboardMouseExited

    private void btnDasboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDasboardMousePressed
        btnDasboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btndashboard4.png")));
    }//GEN-LAST:event_btnDasboardMousePressed

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        main main = (main)SwingUtilities.getWindowAncestor(this);
        Validasilogout1 apa = new Validasilogout1(main);
        apa.showPopUp();
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlogout2.png")));
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlogout1.png")));
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnLogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMousePressed
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlogout3.png")));
    }//GEN-LAST:event_btnLogoutMousePressed

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
    main main = (main)SwingUtilities.getWindowAncestor(this);
        tambahSupplier apa = new tambahSupplier(main);
        apa.showPopUp();    
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnTambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseEntered
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformtambah2.png")));
    }//GEN-LAST:event_btnTambahMouseEntered

    private void btnTambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseExited
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformtambah1.png")));
    }//GEN-LAST:event_btnTambahMouseExited

    private void btnTambahMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMousePressed
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformtambah3.png")));
    }//GEN-LAST:event_btnTambahMousePressed

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
    main main = (main)SwingUtilities.getWindowAncestor(this);
        editSupplier apa = new editSupplier(main);
        apa.showPopUp();  
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformedit2.png")));
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformedit1.png")));
    }//GEN-LAST:event_btnEditMouseExited

    private void btnEditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMousePressed
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformedit3.png")));
    }//GEN-LAST:event_btnEditMousePressed

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
    boolean cobak = supp.delete(id);
        if (cobak) {
            System.out.println("berhasil hapus");
        } else {
            System.out.println("gagal hapus suplier");
        }
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnHapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseEntered
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformhapus2.png")));
    }//GEN-LAST:event_btnHapusMouseEntered

    private void btnHapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseExited
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformhapus1.png")));
    }//GEN-LAST:event_btnHapusMouseExited

    private void btnHapusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMousePressed
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformhapus3.png")));
    }//GEN-LAST:event_btnHapusMousePressed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        load_tabel(search.getText());
    }//GEN-LAST:event_searchKeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
    int baris = table.rowAtPoint(evt.getPoint());
        String idd = table.getValueAt(baris, 0).toString();
        id = Integer.valueOf(idd);
        System.out.println(id);
    }//GEN-LAST:event_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btnDasboard;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnLaporan;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnObat;
    private javax.swing.JLabel btnPegawai;
    private javax.swing.JLabel btnSuplier;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel btnTransaksi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    private view.swing.Table table;
    // End of variables declaration//GEN-END:variables
}
