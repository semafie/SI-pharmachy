
package panel;
import entity.obat;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import main.main;
import repository.obatRepository;
import util.Conn;
import view.dialog.Validasilogout1;

public class Obat extends javax.swing.JPanel {
private String pilih;
    obatRepository datamaster = new obatRepository();

    public Obat() {
        initComponents();
        btnsemuastok.setVisible(false);
        btnstokmenipis1.setVisible(false);
        btnCetak.setVisible(false);
        load_tabel();
        pilih = "semua stok";
    }
    public void load_tabel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAMA_OBAT");
        model.addColumn("HARGA_OBAT");
        model.addColumn("JUMLAH_STOK");
    
        try {
            for(obat apa:datamaster.get()){
                model.addRow(new Object[]{
                    apa.getId(),
                    apa.getNama_obat(),
                    apa.getHarga_obat(),
                    apa.getJumlah_stok()

                });
            }
            table.setModel(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void load_tabel1(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAMA_OBAT");
        model.addColumn("HARGA_OBAT");
        model.addColumn("JUMLAH_STOK");
    
        try {
            for(obat apa:datamaster.getstoktipis()){
                model.addRow(new Object[]{
                    apa.getId(),
                    apa.getNama_obat(),
                    apa.getHarga_obat(),
                    apa.getJumlah_stok()

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
    model.addColumn("NAMA_OBAT");
    model.addColumn("HARGA_OBAT");
    model.addColumn("JUMLAH_STOK");

    try {
        String sql = "SELECT * FROM obat WHERE id LIKE ? OR nama_obat LIKE ?";
        Connection koneksi = (Connection) Conn.configDB();
        PreparedStatement pst = koneksi.prepareStatement(sql);
        pst.setString(1, "%" + search + "%");
        pst.setString(2, "%" + search + "%");

        ResultSet res = pst.executeQuery();

        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("id"),
                res.getString("nama_obat"),
                res.getString("harga_obat"),
                res.getString("jumlah_stok")
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

        btnSupplier = new javax.swing.JLabel();
        btnObat = new javax.swing.JLabel();
        btnDasboard = new javax.swing.JLabel();
        btnTransaksi = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JLabel();
        btnPegawai = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        btnsemuastok1 = new javax.swing.JLabel();
        btnstokmenipis1 = new javax.swing.JLabel();
        btnstokmenipis = new javax.swing.JLabel();
        btnsemuastok = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new view.swing.Table();
        jLabel1 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnTambah = new javax.swing.JLabel();
        btnCetak = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setLayout(null);

        btnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsupplier2.png"))); // NOI18N
        btnSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSupplierMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSupplierMousePressed(evt);
            }
        });
        add(btnSupplier);
        btnSupplier.setBounds(10, 295, 230, 60);

        btnObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnobat1.png"))); // NOI18N
        add(btnObat);
        btnObat.setBounds(10, 220, 230, 60);

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

        btnsemuastok1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/pilih semua stok.png"))); // NOI18N
        btnsemuastok1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(btnsemuastok1);
        btnsemuastok1.setBounds(283, 94, 220, 38);

        btnstokmenipis1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/pilih stok menipis.png"))); // NOI18N
        btnstokmenipis1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnstokmenipis1);
        btnstokmenipis1.setBounds(510, 94, 220, 38);

        btnstokmenipis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/stok menipis.png"))); // NOI18N
        btnstokmenipis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnstokmenipis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnstokmenipisMouseClicked(evt);
            }
        });
        add(btnstokmenipis);
        btnstokmenipis.setBounds(540, 95, 150, 30);

        btnsemuastok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Semua Stok.png"))); // NOI18N
        btnsemuastok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsemuastok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsemuastokMouseClicked(evt);
            }
        });
        add(btnsemuastok);
        btnsemuastok.setBounds(330, 103, 140, 19);

        search.setBackground(new Color(0,0,0,0));
        search.setBorder(null);
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        add(search);
        search.setBounds(1010, 160, 310, 30);

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
        jScrollPane1.setViewportView(table);

        add(jScrollPane1);
        jScrollPane1.setBounds(300, 250, 1000, 402);
        add(jLabel1);
        jLabel1.setBounds(430, 730, 30, 30);

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
        btnHapus.setBounds(620, 150, 170, 60);

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
        btnEdit.setBounds(480, 150, 135, 60);

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
        btnTambah.setBounds(280, 150, 195, 60);

        btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncetak1.png"))); // NOI18N
        btnCetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCetakMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCetakMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCetakMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCetakMousePressed(evt);
            }
        });
        add(btnCetak);
        btnCetak.setBounds(280, 150, 150, 60);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/bg Obat Semua Stok.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1366, 768);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMouseClicked
    main main = (main)SwingUtilities.getWindowAncestor(this);
    this.setVisible(false);
    main.showSuplier();
    }//GEN-LAST:event_btnSupplierMouseClicked

    private void btnSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMouseEntered
        btnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsupplier3.png")));
    }//GEN-LAST:event_btnSupplierMouseEntered

    private void btnSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMouseExited
        btnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsupplier2.png")));
    }//GEN-LAST:event_btnSupplierMouseExited

    private void btnSupplierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMousePressed
        btnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsupplier4.png")));
    }//GEN-LAST:event_btnSupplierMousePressed

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

    private void btnsemuastokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsemuastokMouseClicked
    btnsemuastok.setVisible(false);
    btnsemuastok1.setVisible(true);
    btnstokmenipis.setVisible(true);
    btnstokmenipis1.setVisible(false);
    pilih = "semua stok";
    btnTambah.setVisible(true);
    btnEdit.setVisible(true);
    btnHapus.setVisible(true);
    btnCetak.setVisible(false);
    load_tabel();
    
    }//GEN-LAST:event_btnsemuastokMouseClicked

    private void btnstokmenipisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnstokmenipisMouseClicked
    btnCetak.setVisible(true);
    btnTambah.setVisible(false);
    btnEdit.setVisible(false);
    btnHapus.setVisible(false);
    btnsemuastok.setVisible(true);
    btnsemuastok1.setVisible(false);
    btnstokmenipis.setVisible(false);
    btnstokmenipis1.setVisible(true);
    pilih = "stok menipis";
    load_tabel1();
    }//GEN-LAST:event_btnstokmenipisMouseClicked

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        load_tabel(search.getText());
    }//GEN-LAST:event_searchKeyReleased

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformhapus1.png")));
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

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnformedit1.png")));
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

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
    
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

    private void btnCetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakMouseClicked

    private void btnCetakMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseEntered
    btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncetak2.png")));
    }//GEN-LAST:event_btnCetakMouseEntered

    private void btnCetakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseExited
    btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncetak1.png")));
    }//GEN-LAST:event_btnCetakMouseExited

    private void btnCetakMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMousePressed
    btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncetak3.png")));
    }//GEN-LAST:event_btnCetakMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btnCetak;
    private javax.swing.JLabel btnDasboard;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnLaporan;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnObat;
    private javax.swing.JLabel btnPegawai;
    private javax.swing.JLabel btnSupplier;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel btnTransaksi;
    private javax.swing.JLabel btnsemuastok;
    private javax.swing.JLabel btnsemuastok1;
    private javax.swing.JLabel btnstokmenipis;
    private javax.swing.JLabel btnstokmenipis1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    private view.swing.Table table;
    // End of variables declaration//GEN-END:variables
}
