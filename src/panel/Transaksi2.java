/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panel;
import entity.detail_penjualan;
import entity.obat;
import entity.penjualan;
import java.awt.Color;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;
import java.util.HashMap;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import main.main;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import repository.detail_penjualanRepository;
import repository.obatRepository;
import repository.penjualanRepository;
import util.Conn;
import view.dialog.Validasilogout1;
import view.dialog.validasiberhasil;
import view.dialog.validasiberhasil1;
import view.glasspanel.GlassPanePopup;

/**
 *
 * @author RESCOM-1
 */
public class Transaksi2 extends javax.swing.JPanel {

    /**
     * Creates new form Transaksi
     */
    private int id;
    obatRepository obat = new obatRepository();
    penjualanRepository penjualan = new penjualanRepository();
    detail_penjualanRepository detailpenjualan1 = new detail_penjualanRepository();
    private String kodeterakhir = penjualan.getlastid().getKodepenjulan();
    public Transaksi2() {
        initComponents();
        DefaultCellEditor cellEditor = new DefaultCellEditor(new JTextField()) {
    @Override
    public boolean isCellEditable(EventObject e) {
        return false;
    }
};
        table.setDefaultEditor(Object.class, cellEditor);
        table1.setDefaultEditor(Object.class, cellEditor);
        if(kodeterakhir == null){
            txt_idtransaksi.setText("TRJ1");
        } else {
            
            String angkaString = kodeterakhir.replaceAll("[^0-9]", "");
            int jadiangka = Integer.valueOf(angkaString);
            jadiangka++;
            txt_idtransaksi.setText("TRJ" + Integer.toString(jadiangka));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date hayo = new Date();
        txt_tanggal.setText(sdf.format(hayo));
        load_tabel();
        jPanel2.setVisible(false);
        main main = (main)SwingUtilities.getWindowAncestor(this);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Obat");
        model.addColumn("Nama Obat");
        model.addColumn("Harga Obat");
        model.addColumn("Jumlah Beli");
        model.addColumn("Sub Total");
        table1.setModel(model);
    }
public void load_tabel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAMA_OBAT");
        model.addColumn("HARGA_OBAT");
        model.addColumn("JUMLAH_STOK");
    
        try {
            for(obat apa:obat.get()){
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
    public void tambahData(int col1, String col2,int col3, int col4, int col5) {

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        boolean kodeExists = false;

        // Iterasi untuk memeriksa apakah nilai kolom kode sudah ada dalam tabel
        for (int row = 0; row < model.getRowCount(); row++) {
            int kode = (int) model.getValueAt(row, 0);
            if (kode == col1) {
                // Jika sudah ada, ubah nilai kolom ke-4
                main main = (main)SwingUtilities.getWindowAncestor(this);
                validasiberhasil apa = new validasiberhasil(main, "obat ini sudah dipilih sebelumnya\n maka Jumlah dan subtotal akan diubah");
                apa.showPopUp();
                int nilaiSebelumnya = (int) model.getValueAt(row, 3);
                int nilaiSebelumnya1 = (int) model.getValueAt(row, 4);
                int nilaibanyakstok = (int) model1.getValueAt(row, 3);
                int nilaiBaru = nilaiSebelumnya + col4;
                int nilaiBaru1 = nilaiSebelumnya1 + col5;
                
                    model.setValueAt(col4, row, 3);
                model.setValueAt(col5,row, 4);
                
                kodeExists = true;
                break;  // Keluar dari loop karena nilai kode sudah ditemukan
            }
        }

        // Jika nilai kode belum ada dalam tabel, tambahkan baris baru
        if (!kodeExists) {
            Object[] data = {col1, col2,col3, col4, col5};
            model.addRow(data);
        }
    }
    private void updateTextField2(String apa) {
        try {
            // Get the value from textField1
            int value = Integer.parseInt(apa);
            int value2 = Integer.parseInt(txt_hargasatuan.getText());
            
            
            // Multiply by 10000
            int result = value * value2;
            
            // Set the result in textField2
            txt_subtotal.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            txt_subtotal.setText("Invalid input");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnsimpan = new javax.swing.JLabel();
        btnbatal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new view.swing.Table();
        txt_subtotal = new javax.swing.JTextField();
        txt_jumlah = new javax.swing.JTextField();
        txt_hargasatuan = new javax.swing.JTextField();
        txt_namaobat = new javax.swing.JTextField();
        txt_kodeobat = new javax.swing.JTextField();
        bg1 = new javax.swing.JLabel();
        txt_jumlahstokkk = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JLabel();
        btnPegawai = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JLabel();
        btnSuplier = new javax.swing.JLabel();
        btnObat = new javax.swing.JLabel();
        btnDasboard = new javax.swing.JLabel();
        btnSupplier = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new view.swing.Table();
        txt_idtransaksi = new javax.swing.JTextField();
        txt_tanggal = new javax.swing.JTextField();
        txt_bayartunai = new javax.swing.JTextField();
        txt_totalharga = new javax.swing.JTextField();
        txt_kembalian = new javax.swing.JTextField();
        btncariobat = new javax.swing.JLabel();
        btnreset = new javax.swing.JLabel();
        btnhapustable = new javax.swing.JLabel();
        btnprosestransaksi = new javax.swing.JLabel();
        btnpenjualan1 = new javax.swing.JLabel();
        btnpembelianstok = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setLayout(null);

        jPanel2.setBackground(new Color(0,0,0,80));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
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
        btnsimpan.setBounds(700, 620, 190, 51);

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
        btnbatal.setBounds(470, 620, 190, 51);

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
        jScrollPane2.setBounds(270, 220, 770, 200);

        txt_subtotal.setBorder(null);
        jPanel2.add(txt_subtotal);
        txt_subtotal.setBounds(720, 560, 220, 30);

        txt_jumlah.setBorder(null);
        txt_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyReleased(evt);
            }
        });
        jPanel2.add(txt_jumlah);
        txt_jumlah.setBounds(420, 560, 220, 30);

        txt_hargasatuan.setBorder(null);
        jPanel2.add(txt_hargasatuan);
        txt_hargasatuan.setBounds(830, 480, 220, 30);

        txt_namaobat.setBorder(null);
        jPanel2.add(txt_namaobat);
        txt_namaobat.setBounds(550, 480, 230, 30);

        txt_kodeobat.setBorder(null);
        jPanel2.add(txt_kodeobat);
        txt_kodeobat.setBounds(280, 480, 220, 30);

        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/form pilih obat.png"))); // NOI18N
        jPanel2.add(bg1);
        bg1.setBounds(200, 70, 891, 620);

        txt_jumlahstokkk.setBorder(null);
        jPanel2.add(txt_jumlahstokkk);
        txt_jumlahstokkk.setBounds(550, 480, 230, 30);

        add(jPanel2);
        jPanel2.setBounds(0, 0, 1370, 770);

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

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(280, 200, 1020, 240);

        txt_idtransaksi.setBackground(new java.awt.Color(245, 241, 241));
        txt_idtransaksi.setBorder(null);
        jPanel1.add(txt_idtransaksi);
        txt_idtransaksi.setBounds(570, 550, 210, 30);

        txt_tanggal.setBackground(new java.awt.Color(245, 241, 241));
        txt_tanggal.setBorder(null);
        jPanel1.add(txt_tanggal);
        txt_tanggal.setBounds(840, 550, 210, 30);

        txt_bayartunai.setBackground(new java.awt.Color(245, 241, 241));
        txt_bayartunai.setBorder(null);
        txt_bayartunai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bayartunaiKeyReleased(evt);
            }
        });
        jPanel1.add(txt_bayartunai);
        txt_bayartunai.setBounds(700, 625, 210, 30);
        txt_bayartunai.getAccessibleContext().setAccessibleName("");

        txt_totalharga.setBackground(new java.awt.Color(245, 241, 241));
        txt_totalharga.setBorder(null);
        jPanel1.add(txt_totalharga);
        txt_totalharga.setBounds(440, 625, 210, 30);
        txt_totalharga.getAccessibleContext().setAccessibleName("");

        txt_kembalian.setBackground(new java.awt.Color(245, 241, 241));
        txt_kembalian.setBorder(null);
        jPanel1.add(txt_kembalian);
        txt_kembalian.setBounds(970, 625, 210, 30);
        txt_kembalian.getAccessibleContext().setAccessibleName("");

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

        btnpenjualan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/Pilih penjualan.png"))); // NOI18N
        btnpenjualan1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnpenjualan1);
        btnpenjualan1.setBounds(500, 120, 220, 38);

        btnpembelianstok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/Pembelian.png"))); // NOI18N
        btnpembelianstok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpembelianstok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpembelianstokMouseClicked(evt);
            }
        });
        jPanel1.add(btnpembelianstok);
        btnpembelianstok.setBounds(320, 130, 130, 19);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/bg Transaksi Penjualan.png"))); // NOI18N
        jPanel1.add(bg);
        bg.setBounds(0, 0, 1366, 768);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1370, 770);
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnpembelianstokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpembelianstokMouseClicked
        main main = (main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showTransaksi();
        

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
    Date harii = new Date();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        penjualan penn = new penjualan(txt_idtransaksi.getText(), harii, timestamp,
                Integer.valueOf(txt_totalharga.getText()), Integer.valueOf(txt_bayartunai.getText()),
                        Integer.valueOf(txt_kembalian.getText()));
        boolean cobak = penjualan.add(penn);
        if (cobak) {
            System.out.println("berhasil");
        } else {
            System.out.println("gagal");
        }
        DefaultTableModel model = (DefaultTableModel) table1.getModel();    
        for (int row = 0; row < model.getRowCount(); row++) {
            int kode = penjualan.getlastid().getId();
            int idobat =Integer.valueOf(model.getValueAt(row, 0).toString());
            int jumlahawal = obat.get(idobat).getJumlah_stok();
            int jumlahakhir = jumlahawal - Integer.valueOf(model.getValueAt(row, 3).toString());
            obat obat1 = new obat(idobat,jumlahakhir);
            boolean cobak3 = obat.updatestok(obat1);
            if (cobak3) {
               System.out.println("berhasil update stok" + row);
            } else {
                System.out.println("gagal" + row);
            }
            obat obat = new obat(idobat);
            penjualan hayo = new penjualan(kode);
            detail_penjualan detailpenjualan = new detail_penjualan(hayo, obat,
                    model.getValueAt(row, 1).toString(),
                    Integer.valueOf(model.getValueAt(row, 2).toString()),
                    Integer.valueOf(model.getValueAt(row, 3).toString()),
                    Integer.valueOf(model.getValueAt(row, 4).toString()));
            boolean cobak2 = detailpenjualan1.add(detailpenjualan);
            if(cobak2){
                System.out.println("berhasil" + row);
            } else {
                System.out.println("gagal" + row);
            }
            
        }
        int idfinalrekap = penjualan.getlastid().getId();
            InputStream struk = getClass().getResourceAsStream("/jasper_report/reportpenjualan.jrxml");
            String query = "SELECT * FROM detail_penjualan JOIN penjualan ON detail_penjualan.id_penjualan = penjualan.id WHERE penjualan.id = "+idfinalrekap;
//        String path = "E:/SEMUA FOLDER/imam/kuliah/semester 3/joki/SIsiloam/SIsiloam/SISILOAM/src/jasper_report/no_antrian.jrxml";

        try {
               Connection koneksi = (Connection) Conn.configDB();
            Statement pstCek = koneksi.createStatement();
            ResultSet res = pstCek.executeQuery(query);
            JasperDesign design = JRXmlLoader.load(struk);
            JasperReport jr = JasperCompileManager.compileReport(design);
            JRResultSetDataSource rsDataSource = new JRResultSetDataSource(res);
            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap<>(), rsDataSource);

            JasperViewer viewer = new JasperViewer(jp, false); // argumen 'false' mencegah aplikasi keluar
            viewer.setVisible(true);
            main main =(main)SwingUtilities.getWindowAncestor(this);
    this.setVisible(false);
    validasiberhasil ac = new validasiberhasil(main, "Data Berhasil Ditambahkan");
            ac.showPopUp();
            main.showDasboardOwner();
            
            txt_hargasatuan.setText("");
            txt_totalharga.setText("");
            txt_kembalian.setText("");
        } catch(Exception e) { 
            System.out.println(e.getMessage());
            e.printStackTrace(); }
    }//GEN-LAST:event_btnprosestransaksiMouseClicked

    private void btnhapustableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapustableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhapustableMouseClicked

    private void btnresetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseClicked
    DefaultTableModel model = (DefaultTableModel) table1.getModel();
    model.setRowCount(0);
    int sum = 0;
         for(int i = 0; i<table1.getRowCount(); i++){
             sum = sum + Integer.parseInt(table1.getValueAt(i, 4).toString());;
         }
         txt_totalharga.setText(Integer.toString(sum));
    }//GEN-LAST:event_btnresetMouseClicked

    private void btnprosestransaksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprosestransaksiMouseEntered
    btnprosestransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnprosestransaksi2.png")));
    }//GEN-LAST:event_btnprosestransaksiMouseEntered

    private void btnresetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseEntered
    btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel2.png")));
    }//GEN-LAST:event_btnresetMouseEntered

    private void btnresetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseExited
    btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel1.png")));
    }//GEN-LAST:event_btnresetMouseExited

    private void btnresetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMousePressed
    btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel3.png")));
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
tambahData(Integer.valueOf(txt_kodeobat.getText()), txt_namaobat.getText(),Integer.valueOf(txt_hargasatuan.getText()), Integer.valueOf(txt_jumlah.getText()), Integer.valueOf(txt_subtotal.getText()));
        int sum = 0;
         for(int i = 0; i<table1.getRowCount(); i++){
             sum = sum + Integer.parseInt(table1.getValueAt(i, 4).toString());;
         }
         txt_totalharga.setText(Integer.toString(sum));
         txt_jumlah.setText("");
         txt_subtotal.setText("");
        //        kode = Integer.valueOf(txt_kodeobat.getText());
        //        jumlah = Integer.valueOf(txt_jumlah.getText());
        //        subtotal = Integer.valueOf(txt_subtotal.getText());
        
        //Transaksi.tambahData(Integer.valueOf(txt_kodeobat.getText()),txt_namaobat.getText(),Integer.valueOf(txt_hargasatuan.getText()),Integer.valueOf(txt_jumlah.getText().getText()));
        jPanel2.setVisible(false);
        txt_bayartunai.setText("");
        txt_kembalian.setText("");
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
        if(id != 0){
            txt_namaobat.setText(obat.get(id).getNama_obat());
            txt_hargasatuan.setText(String.valueOf(obat.get(id).getHarga_obat()));
            txt_kodeobat.setText(String.valueOf(obat.get(id).getId()));
            txt_jumlahstokkk.setText(String.valueOf(obat.get(id).getJumlah_stok()));
            
        } else {
            System.out.println("haloo");
        }
        
    }//GEN-LAST:event_tableMouseClicked

    private void txt_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyReleased
    if(Integer.valueOf(txt_jumlah.getText()) > Integer.valueOf(txt_jumlahstokkk.getText())){
                    main main =(main)SwingUtilities.getWindowAncestor(this);
                validasiberhasil1 apa23 = new validasiberhasil1(main, "jumlah stok tidak mencukupi");
                apa23.showPopUp();
                txt_jumlah.setText("");
                    txt_subtotal.setText("");
    }else {
        updateTextField2(txt_jumlah.getText());
    }
                    
        
    }//GEN-LAST:event_txt_jumlahKeyReleased

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
    
    }//GEN-LAST:event_table1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
    jPanel2.setVisible(true);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void txt_bayartunaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bayartunaiKeyReleased
    int hasilkembalian = Integer.valueOf(txt_bayartunai.getText()) - Integer.valueOf(txt_totalharga.getText());
    txt_kembalian.setText(Integer.toString(hasilkembalian));
    }//GEN-LAST:event_txt_bayartunaiKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JLabel btnDasboard;
    private javax.swing.JLabel btnLaporan;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnObat;
    private javax.swing.JLabel btnPegawai;
    private javax.swing.JLabel btnSuplier;
    private javax.swing.JLabel btnSupplier;
    private javax.swing.JLabel btnbatal;
    private javax.swing.JLabel btncariobat;
    private javax.swing.JLabel btnhapustable;
    private javax.swing.JLabel btnpembelianstok;
    private javax.swing.JLabel btnpenjualan1;
    private javax.swing.JLabel btnprosestransaksi;
    private javax.swing.JLabel btnreset;
    private javax.swing.JLabel btnsimpan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static view.swing.Table table;
    public static view.swing.Table table1;
    private javax.swing.JTextField txt_bayartunai;
    private javax.swing.JTextField txt_hargasatuan;
    private javax.swing.JTextField txt_idtransaksi;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_jumlahstokkk;
    private javax.swing.JTextField txt_kembalian;
    private javax.swing.JTextField txt_kodeobat;
    private javax.swing.JTextField txt_namaobat;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_tanggal;
    private javax.swing.JTextField txt_totalharga;
    // End of variables declaration//GEN-END:variables
}
