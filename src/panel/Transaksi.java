/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panel;

import entity.obat;
import entity.supplier;
import java.awt.Color;
import java.awt.Container;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import main.main;
import repository.obatRepository;
import util.Conn;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import repository.pembelianRepository;
import repository.supplierRepository;
import view.dialog.Validasilogout1;
import view.dialog.pilihobat;
import view.glasspanel.GlassPanePopup;

/**
 *
 * @author RESCOM-1
 */
public class Transaksi extends javax.swing.JPanel {

    /**
     * Creates new form Transaksi
     */
    supplierRepository supp = new supplierRepository();
    obatRepository obat = new obatRepository();
    pembelianRepository pembelian = new pembelianRepository();
    private int id;
    private int kode = pilihobatpembelian.kode, subtotal = pilihobatpembelian.subtotal;
    private int kode1 = pilihobatpenjualan.kode, jumlah1 = pilihobatpenjualan.jumlah, subtotal1 = pilihobatpenjualan.subtotal;
    private String kodeterakhir = pembelian.getlastkode().getKodepembelian();
    
    public Transaksi() {
        initComponents();
        if(kodeterakhir == null){
            txt_idtransaksi.setText("TRP1");
        } else {
            
        }
//        System.out.println(kodeterakhir);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date hayo = new Date();
        txt_tanggalbeli.setText(sdf.format(hayo));
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        load_tabel();
        load_tabelsup();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Obat");
        model.addColumn("Nama Obat");
        
        model.addColumn("Jumlah Beli");
        model.addColumn("Sub Total");
        table23.setModel(model);
        btnpembelianstok.setVisible(false);
        btnpenjualan1.setVisible(false);
    }

    public static void tambahData(int col1, String col2, int col4, int col5) {
//        Object[] data = {col1, col2, col3, col4, col5};
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
////        model = (DefaultTableModel)table.getModel();
////        model.addColumn("Kode Obat");
////        model.addColumn("Nama Obat");
////        model.addColumn("Harga");
////        model.addColumn("Jumlah Beli");
////        model.addColumn("Sub Total");
////        model.addRow(data);
////        table.setModel(model);
//        for (int row = 0; row < model.getRowCount(); row++) {
//            // Mengambil nilai kolom kode pada baris tertentu
//            int kode = (int) model.getValueAt(row, 0);
//
//            // Memeriksa apakah nilai kolom kode == 1
//            if (kode == col1) {
//                // Mengubah nilai kolom ke-4 sesuai keinginan
//                // Misalnya, di sini di-set menjadi 100
//                model.setValueAt(col4, row, 3);
//            } else {
//                model.addRow(data);
//            }
//        }
        DefaultTableModel model = (DefaultTableModel) table23.getModel();
        boolean kodeExists = false;

        // Iterasi untuk memeriksa apakah nilai kolom kode sudah ada dalam tabel
        for (int row = 0; row < model.getRowCount(); row++) {
            int kode = (int) model.getValueAt(row, 0);
            if (kode == col1) {
                // Jika sudah ada, ubah nilai kolom ke-4
                int nilaiSebelumnya = (int) model.getValueAt(row, 2);
                int nilaiSebelumnya1 = (int) model.getValueAt(row, 3);
                int nilaiBaru = nilaiSebelumnya + col4;
                int nilaiBaru1 = nilaiSebelumnya1 + col5;
                model.setValueAt(col4, row, 2);
                model.setValueAt(col5, row, 3);
                kodeExists = true;
                break;  // Keluar dari loop karena nilai kode sudah ditemukan
            }
        }

        // Jika nilai kode belum ada dalam tabel, tambahkan baris baru
        if (!kodeExists) {
            Object[] data = {col1, col2, col4, col5};
            model.addRow(data);
        }
    }

//    private void updateTextField2(String apa) {
//        try {
//            // Get the value from textField1
//            int value = Integer.parseInt(apa);
//            int value2 = Integer.parseInt(txt_hargasatuan.getText());
//            
//            
//            // Multiply by 10000
//            int result = value * value2;
//
//            // Set the result in textField2
//            txt_subtotal.setText(String.valueOf(result));
//        } catch (NumberFormatException e) {
//            txt_subtotal.setText("Invalid input");
//        }
//    }
    public void load_tabel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAMA_OBAT");
        model.addColumn("HARGA_OBAT");
        model.addColumn("JUMLAH_STOK");

        try {
            for (obat apa : obat.get()) {
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

    public void load_tabelsup() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAMA_OBAT");
        model.addColumn("NO TELP");
        model.addColumn("ALAMAT");

        try {
            for (supplier apa : supp.get()) {
                model.addRow(new Object[]{
                    apa.getId(),
                    apa.getNama_supplier(),
                    apa.getNo_tlp(),
                    apa.getAlamat()

                });
            }
            table3.setModel(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void load_tabelsup(String search) {
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

            table3.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnsimpan = new javax.swing.JLabel();
        btnbatal = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_jumlah = new javax.swing.JTextField();
        txt_namaobat7 = new javax.swing.JTextField();
        txt_kodeobat = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new view.swing.Table();
        bg1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table3 = new view.swing.Table();
        btnsimpan1 = new javax.swing.JLabel();
        btnbatal1 = new javax.swing.JLabel();
        txt_namasuplier1 = new javax.swing.JTextField();
        kodesuplier1 = new javax.swing.JTextField();
        bg2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JLabel();
        btnPegawai = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JLabel();
        btnSuplier = new javax.swing.JLabel();
        btnObat = new javax.swing.JLabel();
        btnDasboard = new javax.swing.JLabel();
        btnSupplier = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table23 = new view.swing.Table();
        btnpembelianstok1 = new javax.swing.JLabel();
        btnpenjualan1 = new javax.swing.JLabel();
        btnpenjualan = new javax.swing.JLabel();
        btnpembelianstok = new javax.swing.JLabel();
        txt_idtransaksi = new javax.swing.JTextField();
        txt_kodesuplier = new javax.swing.JTextField();
        txt_namasuplier = new javax.swing.JTextField();
        txt_bayartunai = new javax.swing.JTextField();
        txt_totalharga = new javax.swing.JTextField();
        txt_kembali = new javax.swing.JTextField();
        txt_tanggalbeli = new javax.swing.JTextField();
        btncariobat = new javax.swing.JLabel();
        btnreset = new javax.swing.JLabel();
        btncarisuplier = new javax.swing.JLabel();
        btnhapustable = new javax.swing.JLabel();
        btnprosestransaksi = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setLayout(null);

        jPanel2.setBackground(new Color(0,0,0,70));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });
        jPanel2.setLayout(null);

        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsimpan1.png"))); // NOI18N
        btnsimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsimpanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsimpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsimpanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnsimpanMousePressed(evt);
            }
        });
        jPanel2.add(btnsimpan);
        btnsimpan.setBounds(730, 620, 190, 51);

        btnbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatal1.png"))); // NOI18N
        btnbatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbatalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbatalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbatalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnbatalMousePressed(evt);
            }
        });
        jPanel2.add(btnbatal);
        btnbatal.setBounds(500, 620, 190, 51);

        txt_subtotal.setBorder(null);
        jPanel2.add(txt_subtotal);
        txt_subtotal.setBounds(750, 560, 220, 30);

        txt_jumlah.setBorder(null);
        txt_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyReleased(evt);
            }
        });
        jPanel2.add(txt_jumlah);
        txt_jumlah.setBounds(450, 560, 220, 30);

        txt_namaobat7.setBorder(null);
        jPanel2.add(txt_namaobat7);
        txt_namaobat7.setBounds(750, 480, 220, 30);

        txt_kodeobat.setBorder(null);
        jPanel2.add(txt_kodeobat);
        txt_kodeobat.setBounds(450, 480, 220, 30);

        jScrollPane2.setBorder(null);

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
        jScrollPane2.setViewportView(table);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(300, 220, 780, 200);

        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/formpilihobatpembelian (1).png"))); // NOI18N
        jPanel2.add(bg1);
        bg1.setBounds(230, 70, 891, 620);

        add(jPanel2);
        jPanel2.setBounds(0, 0, 1370, 770);

        jPanel3.setBackground(new Color(0,0,0,80));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
        });
        jPanel3.setLayout(null);

        jScrollPane3.setBorder(null);

        table3.setModel(new javax.swing.table.DefaultTableModel(
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
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table3);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(300, 230, 780, 190);

        btnsimpan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsimpan1.png"))); // NOI18N
        btnsimpan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsimpan1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsimpan1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsimpan1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnsimpan1MousePressed(evt);
            }
        });
        jPanel3.add(btnsimpan1);
        btnsimpan1.setBounds(730, 620, 190, 51);

        btnbatal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatal1.png"))); // NOI18N
        btnbatal1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbatal1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbatal1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbatal1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnbatal1MousePressed(evt);
            }
        });
        jPanel3.add(btnbatal1);
        btnbatal1.setBounds(500, 620, 190, 51);

        txt_namasuplier1.setBorder(null);
        jPanel3.add(txt_namasuplier1);
        txt_namasuplier1.setBounds(740, 516, 230, 30);

        kodesuplier1.setBorder(null);
        jPanel3.add(kodesuplier1);
        kodesuplier1.setBounds(440, 516, 230, 30);

        bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/form pilih supplier.png"))); // NOI18N
        jPanel3.add(bg2);
        bg2.setBounds(230, 70, 891, 630);

        add(jPanel3);
        jPanel3.setBounds(0, 0, 1370, 770);

        jPanel1.setLayout(null);

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
        jPanel1.add(btnLogout);
        btnLogout.setBounds(0, 680, 230, 50);

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
        jPanel1.add(btnPegawai);
        btnPegawai.setBounds(10, 520, 230, 60);

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
        jPanel1.add(btnLaporan);
        btnLaporan.setBounds(10, 445, 230, 60);

        btnSuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btntransaksi1.png"))); // NOI18N
        jPanel1.add(btnSuplier);
        btnSuplier.setBounds(10, 370, 230, 60);

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
        jPanel1.add(btnObat);
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
        jPanel1.add(btnDasboard);
        btnDasboard.setBounds(10, 140, 230, 60);

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
        jPanel1.add(btnSupplier);
        btnSupplier.setBounds(10, 295, 230, 60);

        jScrollPane1.setBorder(null);

        table23.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table23);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(300, 200, 1000, 240);

        btnpembelianstok1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/pilih pemebelian.png"))); // NOI18N
        btnpembelianstok1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(btnpembelianstok1);
        btnpembelianstok1.setBounds(280, 120, 220, 38);

        btnpenjualan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/Pilih penjualan.png"))); // NOI18N
        btnpenjualan1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnpenjualan1);
        btnpenjualan1.setBounds(510, 120, 220, 38);

        btnpenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/Penjualan.png"))); // NOI18N
        btnpenjualan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpenjualanMouseClicked(evt);
            }
        });
        jPanel1.add(btnpenjualan);
        btnpenjualan.setBounds(560, 125, 130, 30);

        btnpembelianstok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/Pembelian.png"))); // NOI18N
        btnpembelianstok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpembelianstok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpembelianstokMouseClicked(evt);
            }
        });
        jPanel1.add(btnpembelianstok);
        btnpembelianstok.setBounds(330, 130, 140, 19);

        txt_idtransaksi.setBackground(new java.awt.Color(245, 241, 241));
        txt_idtransaksi.setBorder(null);
        txt_idtransaksi.setFocusable(false);
        jPanel1.add(txt_idtransaksi);
        txt_idtransaksi.setBounds(420, 565, 210, 30);

        txt_kodesuplier.setBackground(new java.awt.Color(245, 241, 241));
        txt_kodesuplier.setBorder(null);
        txt_kodesuplier.setFocusable(false);
        jPanel1.add(txt_kodesuplier);
        txt_kodesuplier.setBounds(680, 565, 210, 30);

        txt_namasuplier.setBackground(new java.awt.Color(245, 241, 241));
        txt_namasuplier.setBorder(null);
        txt_namasuplier.setFocusable(false);
        jPanel1.add(txt_namasuplier);
        txt_namasuplier.setBounds(950, 565, 210, 30);

        txt_bayartunai.setBackground(new java.awt.Color(245, 241, 241));
        txt_bayartunai.setBorder(null);
        jPanel1.add(txt_bayartunai);
        txt_bayartunai.setBounds(690, 640, 210, 30);

        txt_totalharga.setBackground(new java.awt.Color(245, 241, 241));
        txt_totalharga.setBorder(null);
        jPanel1.add(txt_totalharga);
        txt_totalharga.setBounds(430, 640, 210, 30);

        txt_kembali.setBackground(new java.awt.Color(245, 241, 241));
        txt_kembali.setBorder(null);
        jPanel1.add(txt_kembali);
        txt_kembali.setBounds(950, 635, 210, 30);

        txt_tanggalbeli.setBackground(new java.awt.Color(245, 241, 241));
        txt_tanggalbeli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tanggalbeli.setBorder(null);
        txt_tanggalbeli.setFocusable(false);
        jPanel1.add(txt_tanggalbeli);
        txt_tanggalbeli.setBounds(680, 495, 210, 30);

        btncariobat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncariobat1.png"))); // NOI18N
        btncariobat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncariobatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncariobatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncariobatMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btncariobatMousePressed(evt);
            }
        });
        jPanel1.add(btncariobat);
        btncariobat.setBounds(1140, 120, 210, 47);

        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnreset1.png"))); // NOI18N
        btnreset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnresetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnresetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnresetMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnresetMousePressed(evt);
            }
        });
        jPanel1.add(btnreset);
        btnreset.setBounds(1220, 470, 130, 40);

        btncarisuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncarisupplier1.png"))); // NOI18N
        btncarisuplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncarisuplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncarisuplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncarisuplierMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btncarisuplierMousePressed(evt);
            }
        });
        jPanel1.add(btncarisuplier);
        btncarisuplier.setBounds(1180, 560, 140, 40);

        btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel1.png"))); // NOI18N
        btnhapustable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapustableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhapustableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhapustableMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnhapustableMousePressed(evt);
            }
        });
        jPanel1.add(btnhapustable);
        btnhapustable.setBounds(1090, 470, 130, 40);

        btnprosestransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnprosestransaksi1.png"))); // NOI18N
        btnprosestransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnprosestransaksiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnprosestransaksiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnprosestransaksiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnprosestransaksiMousePressed(evt);
            }
        });
        jPanel1.add(btnprosestransaksi);
        btnprosestransaksi.setBounds(650, 690, 280, 60);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/bg Transaksi Pembelian.png"))); // NOI18N
        jPanel1.add(bg);
        bg.setBounds(0, 0, 1366, 768);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1370, 770);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        main main = (main) SwingUtilities.getWindowAncestor(this);
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

    private void btnPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseClicked
        main main = (main) SwingUtilities.getWindowAncestor(this);
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

    private void btnLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseClicked
        main main = (main) SwingUtilities.getWindowAncestor(this);
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

    private void btnObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMouseClicked
        main main = (main) SwingUtilities.getWindowAncestor(this);
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

    private void btnDasboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDasboardMouseClicked
        main main = (main) SwingUtilities.getWindowAncestor(this);
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

    private void btnSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMouseClicked
        main main = (main) SwingUtilities.getWindowAncestor(this);
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

    private void btnpenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpenjualanMouseClicked

        btnpembelianstok.setVisible(true);
        btnpembelianstok1.setVisible(false);
        btnpenjualan.setVisible(false);
        btnpenjualan1.setVisible(true);

    }//GEN-LAST:event_btnpenjualanMouseClicked

    private void btnpembelianstokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpembelianstokMouseClicked
        btnpembelianstok.setVisible(false);
        btnpembelianstok1.setVisible(true);
        btnpenjualan.setVisible(true);
        btnpenjualan1.setVisible(false);


    }//GEN-LAST:event_btnpembelianstokMouseClicked

    private void btncariobatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncariobatMouseClicked
        jPanel2.setVisible(true);
    }//GEN-LAST:event_btncariobatMouseClicked

    private void btncariobatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncariobatMouseEntered
        btncariobat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncariobat2.png")));
    }//GEN-LAST:event_btncariobatMouseEntered

    private void btncariobatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncariobatMouseExited
        btncariobat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncariobat1.png")));
    }//GEN-LAST:event_btncariobatMouseExited

    private void btncariobatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncariobatMousePressed
        btncariobat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncariobat3.png")));
    }//GEN-LAST:event_btncariobatMousePressed

    private void btnprosestransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprosestransaksiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnprosestransaksiMouseClicked

    private void btnhapustableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapustableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhapustableMouseClicked

    private void btnresetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnresetMouseClicked

    private void btnprosestransaksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprosestransaksiMouseEntered
        btnprosestransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnprosestransaksi2.png")));
    }//GEN-LAST:event_btnprosestransaksiMouseEntered

    private void btnresetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseEntered
        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnreset2.png")));
    }//GEN-LAST:event_btnresetMouseEntered

    private void btnresetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseExited
        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnreset1.png")));
    }//GEN-LAST:event_btnresetMouseExited

    private void btnresetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMousePressed
        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnreset3.png")));
    }//GEN-LAST:event_btnresetMousePressed

    private void btnhapustableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapustableMouseEntered
        btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel2.png")));
    }//GEN-LAST:event_btnhapustableMouseEntered

    private void btnhapustableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapustableMouseExited
        btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel1.png")));
    }//GEN-LAST:event_btnhapustableMouseExited

    private void btnhapustableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapustableMousePressed
        btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel3.png")));
    }//GEN-LAST:event_btnhapustableMousePressed

    private void btnprosestransaksiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprosestransaksiMouseExited
        btnprosestransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnprosestransaksi1.png")));
    }//GEN-LAST:event_btnprosestransaksiMouseExited

    private void btnprosestransaksiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprosestransaksiMousePressed
        btnprosestransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnprosestransaksi3.png")));
    }//GEN-LAST:event_btnprosestransaksiMousePressed

    private void btnsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseClicked

        //        kode = Integer.valueOf(txt_kodeobat.getText());
        //        jumlah = Integer.valueOf(txt_jumlah.getText());
        //        subtotal = Integer.valueOf(txt_subtotal.getText());
        tambahData(Integer.valueOf(txt_kodeobat.getText()), txt_tanggalbeli.getText(), Integer.valueOf(txt_jumlah.getText()), Integer.valueOf(txt_subtotal.getText()));
        //Transaksi.tambahData(Integer.valueOf(txt_kodeobat.getText()),txt_namaobat.getText(),Integer.valueOf(txt_hargasatuan.getText()),Integer.valueOf(txt_jumlah.getText().getText()));
        jPanel2.setVisible(false);
    }//GEN-LAST:event_btnsimpanMouseClicked

    private void btnsimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseEntered
        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsimpan2.png")));
    }//GEN-LAST:event_btnsimpanMouseEntered

    private void btnsimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseExited
        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsimpan1.png")));
    }//GEN-LAST:event_btnsimpanMouseExited

    private void btnsimpanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMousePressed
        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsimpan3.png")));
    }//GEN-LAST:event_btnsimpanMousePressed

    private void btnbatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatalMouseClicked
        jPanel2.setVisible(false);
    }//GEN-LAST:event_btnbatalMouseClicked

    private void btnbatalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatalMouseEntered
        btnbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatal2.png")));
    }//GEN-LAST:event_btnbatalMouseEntered

    private void btnbatalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatalMouseExited
        btnbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatal1.png")));
    }//GEN-LAST:event_btnbatalMouseExited

    private void btnbatalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatalMousePressed
        btnbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatal3.png")));
    }//GEN-LAST:event_btnbatalMousePressed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int baris = table.rowAtPoint(evt.getPoint());
        String idd = table.getValueAt(baris, 0).toString();
        id = Integer.valueOf(idd);
        System.out.println(id);
        if (id != 0) {
            txt_namaobat7.setText(obat.get(id).getNama_obat());
//            txt_hargasatuan.setText(String.valueOf(obat.get(id).getHarga_obat()));
            txt_kodeobat.setText(String.valueOf(obat.get(id).getId()));
        } else {
            System.out.println("haloo");
        }

    }//GEN-LAST:event_tableMouseClicked

    private void txt_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyReleased
//        updateTextField2(txt_jumlah.getText());
    }//GEN-LAST:event_txt_jumlahKeyReleased

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        jPanel2.setVisible(true);
    }//GEN-LAST:event_jPanel2MouseEntered

    private void btncarisuplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncarisuplierMouseClicked
        jPanel3.setVisible(true);
    }//GEN-LAST:event_btncarisuplierMouseClicked

    private void btncarisuplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncarisuplierMouseEntered
        btncarisuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncarisupplier2.png")));
    }//GEN-LAST:event_btncarisuplierMouseEntered

    private void btncarisuplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncarisuplierMouseExited
        btncarisuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncarisupplier1.png")));
    }//GEN-LAST:event_btncarisuplierMouseExited

    private void btncarisuplierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncarisuplierMousePressed
        btncarisuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncarisupplier3.png")));
    }//GEN-LAST:event_btncarisuplierMousePressed

    private void btnsimpan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpan1MouseClicked
        txt_kodesuplier.setText(kodesuplier1.getText());
        txt_namasuplier.setText(txt_namasuplier1.getText());
        jPanel3.setVisible(false);
    }//GEN-LAST:event_btnsimpan1MouseClicked

    private void btnsimpan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpan1MouseEntered
        btnsimpan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsimpan2.png")));
    }//GEN-LAST:event_btnsimpan1MouseEntered

    private void btnsimpan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpan1MouseExited
        btnsimpan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsimpan1.png")));
    }//GEN-LAST:event_btnsimpan1MouseExited

    private void btnsimpan1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpan1MousePressed
        btnsimpan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsimpan3.png")));
    }//GEN-LAST:event_btnsimpan1MousePressed

    private void btnbatal1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatal1MouseClicked
        jPanel3.setVisible(false);
    }//GEN-LAST:event_btnbatal1MouseClicked

    private void btnbatal1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatal1MouseEntered
        btnbatal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatal2.png")));
    }//GEN-LAST:event_btnbatal1MouseEntered

    private void btnbatal1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatal1MouseExited
        btnbatal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatal1.png")));
    }//GEN-LAST:event_btnbatal1MouseExited

    private void btnbatal1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatal1MousePressed
        btnbatal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatal3.png")));
    }//GEN-LAST:event_btnbatal1MousePressed

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
        int baris = table.rowAtPoint(evt.getPoint());
        String idd = table.getValueAt(baris, 0).toString();
        id = Integer.valueOf(idd);
        System.out.println(id);
        if (id != 0) {
            kodesuplier1.setText(String.valueOf(supp.get(id).getId()));
//            txt_hargasatuan.setText(String.valueOf(obat.get(id).getHarga_obat()));
            txt_namasuplier1.setText(supp.get(id).getNama_supplier());
        } else {
            System.out.println("haloo");
        }
    }//GEN-LAST:event_table3MouseClicked

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jPanel3MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JLabel bg2;
    private javax.swing.JLabel btnDasboard;
    private javax.swing.JLabel btnLaporan;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnObat;
    private javax.swing.JLabel btnPegawai;
    private javax.swing.JLabel btnSuplier;
    private javax.swing.JLabel btnSupplier;
    private javax.swing.JLabel btnbatal;
    private javax.swing.JLabel btnbatal1;
    private javax.swing.JLabel btncariobat;
    private javax.swing.JLabel btncarisuplier;
    private javax.swing.JLabel btnhapustable;
    private javax.swing.JLabel btnpembelianstok;
    private javax.swing.JLabel btnpembelianstok1;
    private javax.swing.JLabel btnpenjualan;
    private javax.swing.JLabel btnpenjualan1;
    private javax.swing.JLabel btnprosestransaksi;
    private javax.swing.JLabel btnreset;
    private javax.swing.JLabel btnsimpan;
    private javax.swing.JLabel btnsimpan1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField kodesuplier1;
    private view.swing.Table table;
    public static view.swing.Table table23;
    private view.swing.Table table3;
    private javax.swing.JTextField txt_bayartunai;
    private javax.swing.JTextField txt_idtransaksi;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_kembali;
    private javax.swing.JTextField txt_kodeobat;
    private javax.swing.JTextField txt_kodesuplier;
    private javax.swing.JTextField txt_namaobat7;
    private javax.swing.JTextField txt_namasuplier;
    private javax.swing.JTextField txt_namasuplier1;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_tanggalbeli;
    private javax.swing.JTextField txt_totalharga;
    // End of variables declaration//GEN-END:variables
}
