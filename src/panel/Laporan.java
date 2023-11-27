/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panel;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import entity.detail_pembelian;
import entity.detail_penjualan;
import entity.pembelian;
import entity.penjualan;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import main.main;
import repository.detail_pembelianRepository;
import repository.detail_penjualanRepository;
import repository.pembelianRepository;
import repository.penjualanRepository;
import util.Conn;
import view.dialog.Validasilogout1;
import view.dialog.editLaporanPembelian;
import view.dialog.editLaporanPenjualan;
import view.dialog.validasiberhasil1;

/**
 *
 * @author RESCOM-1
 */
public class Laporan extends javax.swing.JPanel {

    /**
     * Creates new form Laporan
     */
    private String pilih = "pembelian";
    detail_pembelianRepository detailbeli = new detail_pembelianRepository();
    detail_penjualanRepository detailjual = new detail_penjualanRepository();
    pembelianRepository beli = new pembelianRepository();
    penjualanRepository jual = new penjualanRepository();
    public static int id;
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    public Laporan() {
        initComponents();
        btnpenjualan1.setVisible(false);
        btnpembelianstok.setVisible(false);
        load_tabel();
        DefaultCellEditor cellEditor = new DefaultCellEditor(new JTextField()) {
    @Override
    public boolean isCellEditable(EventObject e) {
        return false;
    }
};
        table.setDefaultEditor(Object.class, cellEditor);
        
    }
    
    public void load_tabel() {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Id Transaksi");
        model.addColumn("Nama Supplier");
        model.addColumn("Tgl Transaksi");
        model.addColumn("Jam");
        model.addColumn("Total Harga");
        model.addColumn("Jumlah Bayar");
        model.addColumn("Kembalian");
        

        try {
            for (pembelian apa : beli.get()) {
                model.addRow(new Object[]{
                    apa.getKodepembelian(),
                    apa.getSupplier().getNama_supplier(),
                    apa.getTanggal(),
                    timeFormat.format(new Date(apa.getJam().getTime())),
                    apa.getTotal_harga(),
                    apa.getBayartunai(),
                    apa.getKembalian()
                        
                });
            }
            table.setModel(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void load_tabel(String search) {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Id Transaksi");
        model.addColumn("Nama Supplier");
        model.addColumn("Tgl Transaksi");
        model.addColumn("Jam");
        model.addColumn("Total Harga");
        model.addColumn("Jumlah Bayar");
        model.addColumn("Kembalian");
        

        try {
    String sql = "SELECT * FROM pembelian " +
                 "JOIN supplier ON pembelian.id_supplier = supplier.id " +
                 "WHERE pembelian.kode LIKE ? OR pembelian.tanggal LIKE ? OR supplier.nama_supplier LIKE ?";

    Connection koneksi = (Connection) Conn.configDB();
    PreparedStatement pst = koneksi.prepareStatement(sql);
    pst.setString(1, "%" + search + "%");
    pst.setString(2, "%" + search + "%");
    pst.setString(3, "%" + search + "%");

    ResultSet res = pst.executeQuery();

    while (res.next()) {
        model.addRow(new Object[]{
            res.getString("pembelian.kode"),
            res.getString("supplier.nama_supplier"),
            res.getString("pembelian.tanggal"),
            res.getString("pembelian.jam"),
            res.getString("pembelian.total_harga"),
            res.getString("pembelian.jumlah_bayar"),
            res.getString("pembelian.kembalian")
        });
    }
    table.setModel(model);
} catch (Exception e) {
    System.out.println(e.getMessage());
}

    }
    public void load_tabel1() {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Id Transaksi");
        model.addColumn("Tgl Transaksi");
        model.addColumn("Jam");
        model.addColumn("Total Harga");
        model.addColumn("Jumlah Bayar");
        model.addColumn("Kembalian");
        

        try {
            for (penjualan apa : jual.get()) {
                model.addRow(new Object[]{
                    apa.getKodepenjulan(),
                     
                    apa.getTanggal(),
                    timeFormat.format(new Date(apa.getJam().getTime())),
                    apa.getTotal_harga(),
                    apa.getJumlahbayar(),
                    apa.getKembalian()
                        
                });
            }
            table.setModel(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void load_tabel1(String search) {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Id Transaksi");
        model.addColumn("Tgl Transaksi");
        model.addColumn("Jam");
        model.addColumn("Total Harga");
        model.addColumn("Jumlah Bayar");
        model.addColumn("Kembalian");
        

        try {
        String sql = "SELECT * FROM penjualan WHERE kode LIKE ? OR tanggal LIKE ?";
        Connection koneksi = (Connection) Conn.configDB();
        PreparedStatement pst = koneksi.prepareStatement(sql);
        pst.setString(1, "%" + search + "%");
        pst.setString(2, "%" + search + "%");

        ResultSet res = pst.executeQuery();

        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("kode"),
                res.getString("tanggal"),
                res.getString("jam"),
                res.getString("total_harga"),
                res.getString("jumlah_bayar"),
                res.getString("kembalian")
            });
        }

        table.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public static boolean convertJTableToPDF(JTable jTable) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Simpan sebagai PDF");
    fileChooser.setFileFilter(new FileNameExtensionFilter("File PDF", "pdf"));

    int userSelection = fileChooser.showSaveDialog(null);
        try {
            
        
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        String filePath = fileChooser.getSelectedFile().getAbsolutePath() + ".pdf";
        Document document = new Document(PageSize.A4.rotate());

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            
            // Tambahkan judul laporan
                Paragraph title = new Paragraph("LAPORAN STOK MENIPIS APOTEK SUKA MAJU", new Font(Font.BOLD, 18, Font.NORMAL));
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);
                
                Paragraph title1 = new Paragraph(" ", new Font(Font.BOLD, 18, Font.NORMAL));
                title1.setAlignment(Element.ALIGN_CENTER);
                document.add(title1);
                
                
                
                
                // Tambahkan tanggal hari ini
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String currentDate = "Tanggal: " + sdf.format(new Date()) ;
                Paragraph date = new Paragraph(currentDate, new Font(Font.BOLD, 12, Font.NORMAL));
                date.setAlignment(Element.ALIGN_RIGHT);
                document.add(date);
                
                Paragraph title2 = new Paragraph(" ", new Font(Font.BOLD, 20, Font.NORMAL));
                title2.setAlignment(Element.ALIGN_CENTER);
                document.add(title2);
                
                date.setSpacingAfter(25);
            
            PdfPTable pdfTable = new PdfPTable(jTable.getColumnCount());
            
            pdfTable.getDefaultCell().setBorderColor(new Color(219,219,219));
            
            pdfTable.setTotalWidth(PageSize.A4.getHeight());

            // Mengisi header tabel PDF dengan nama kolom dari JTable
            for (int i = 0; i < jTable.getColumnCount(); i++) {
//                pdfTable.addCell(jTable.getColumnName(i));
                PdfPCell cell = new PdfPCell(new Phrase(jTable.getColumnName(i)));
                    cell.setBackgroundColor(new Color(140,170,126)); // Warna latar belakang
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER); // Pusatkan teks
                    cell.setPadding(1);
                    cell.setBorderColor(Color.WHITE);
                    pdfTable.addCell(cell);
            }
//            float[] columnWidths = {1f, 1.5f, 2f, 1.5f}; // Sesuaikan lebar kolom sesuai kebutuhan
//                pdfTable.setWidths(columnWidths);


            // Mengisi data dari JTable ke tabel PDF
            for (int i = 0; i < jTable.getRowCount(); i++) {
                for (int j = 0; j < jTable.getColumnCount(); j++) {
                    pdfTable.addCell(jTable.getValueAt(i, j).toString());
                }
            }

            document.add(pdfTable);
            document.close();
            JOptionPane.showMessageDialog(null, "Berhasil menyimpan PDF", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menyimpan PDF", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }   
    }
    return true;
    } catch (Exception e) {
        return false;
        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSupplier = new javax.swing.JLabel();
        btnObat = new javax.swing.JLabel();
        btnDasboard = new javax.swing.JLabel();
        btnSuplier = new javax.swing.JLabel();
        btnPegawai = new javax.swing.JLabel();
        btnTransaksi = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new view.swing.Table();
        btnEdit = new javax.swing.JLabel();
        btnHapus = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        btnCetak = new javax.swing.JLabel();
        btnpembelianstok1 = new javax.swing.JLabel();
        btnpenjualan1 = new javax.swing.JLabel();
        btnpenjualan = new javax.swing.JLabel();
        btnpembelianstok = new javax.swing.JLabel();
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

        btnSuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlaporan1.png"))); // NOI18N
        add(btnSuplier);
        btnSuplier.setBounds(10, 445, 230, 60);

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
        jScrollPane1.setBounds(300, 230, 990, 470);

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
        btnEdit.setBounds(280, 140, 135, 60);

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
        btnHapus.setBounds(420, 140, 170, 60);

        search.setBackground(new Color(0,0,0,0));
        search.setBorder(null);
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });
        add(search);
        search.setBounds(1010, 150, 300, 30);

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
        btnCetak.setBounds(780, 140, 156, 60);

        btnpembelianstok1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/pilih pemebelian.png"))); // NOI18N
        btnpembelianstok1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(btnpembelianstok1);
        btnpembelianstok1.setBounds(290, 86, 220, 38);

        btnpenjualan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/Pilih penjualan.png"))); // NOI18N
        btnpenjualan1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnpenjualan1);
        btnpenjualan1.setBounds(520, 86, 220, 38);

        btnpenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/Penjualan.png"))); // NOI18N
        btnpenjualan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpenjualanMouseClicked(evt);
            }
        });
        add(btnpenjualan);
        btnpenjualan.setBounds(570, 90, 130, 30);

        btnpembelianstok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/Pembelian.png"))); // NOI18N
        btnpembelianstok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpembelianstok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpembelianstokMouseClicked(evt);
            }
        });
        add(btnpembelianstok);
        btnpembelianstok.setBounds(340, 89, 140, 30);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/bg Laporan Pembelian.png"))); // NOI18N
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

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
   if(pilih.equals("pembelian")){
        if(id != 0){
        main main = (main)SwingUtilities.getWindowAncestor(this);
        editLaporanPembelian apa = new editLaporanPembelian(main);
        apa.showPopUp();
        load_tabel();
   } else {
       System.out.println("pilih tabel dulu");
   }
   } else{
       main main = (main)SwingUtilities.getWindowAncestor(this);
        editLaporanPenjualan apa = new editLaporanPenjualan(main);
        apa.showPopUp();
   }
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
    if (pilih.equals("pembelian")){
        if(id != 0){
            
            detail_pembelian gasken = new detail_pembelian();
            boolean cobakdeletedetail = detailbeli.delete(id);
            if(cobakdeletedetail){
                
            }else{
//                main main =(main)SwingUtilities.getWindowAncestor(this);
//            validasiberhasil1 apa = new validasiberhasil1(main, "gagal di delete");
//            apa.showPopUp();
System.out.println("gagal");
            }
            boolean cobak = beli.delete(id);
        if(cobak){
            main main =(main)SwingUtilities.getWindowAncestor(this);
            validasiberhasil1 apa = new validasiberhasil1(main, "berhasil di delete");
            apa.showPopUp();
            load_tabel();
        }else{
            System.out.println("gagal");
        }
        
    }else{
        System.out.println("pilih tabel dulu");   
    }
    }else{
        if(id != 0){
            detail_penjualan gas = new detail_penjualan(id);
            boolean cobakdeletedetai = detailjual.delete(id);
            if (cobakdeletedetai) {
                
            } else {
                System.out.println("gagal");
            }
            boolean cobak2 = jual.delete(id);
            if(cobak2){
                main main = (main) SwingUtilities.getWindowAncestor(this);
                validasiberhasil1 apa = new validasiberhasil1(main, "berhasil di delete");
                apa.showPopUp();
                load_tabel1();
            }else{
                System.out.println("gagal");
            }
            }else{
        System.out.println("pilih tabel dulu");   
            }
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
    if(pilih.equals("pembelian")){
        load_tabel(search.getText());
    }else {
        load_tabel1(search.getText());
    }
    }//GEN-LAST:event_searchKeyReleased

    private void btnCetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseClicked
        convertJTableToPDF(table);
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

    private void btnpenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpenjualanMouseClicked

        btnpembelianstok.setVisible(true);
        btnpembelianstok1.setVisible(false);
        btnpenjualan.setVisible(false);
        btnpenjualan1.setVisible(true);
        pilih = "penjualan";
        load_tabel1();
        id = 0;
    }//GEN-LAST:event_btnpenjualanMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
   if(pilih.equals("pembelian")){
       int baris = table.rowAtPoint(evt.getPoint());
        String idd = table.getValueAt(baris, 0).toString();
        int wow = beli.getidbykode(idd).getId();
        id = wow;
   } else {
       int baris = table.rowAtPoint(evt.getPoint());
        String idd = table.getValueAt(baris, 0).toString();
        int wow = jual.getidbykode(idd).getId();
        id = wow;
        System.out.println(id);
   }
        
    }//GEN-LAST:event_tableMouseClicked

    private void btnpembelianstokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpembelianstokMouseClicked
        btnpembelianstok.setVisible(false);
        btnpembelianstok1.setVisible(true);
        btnpenjualan.setVisible(true);
        btnpenjualan1.setVisible(false);
        pilih = "pembelian";
        load_tabel();
        id = 0;
    }//GEN-LAST:event_btnpembelianstokMouseClicked

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btnCetak;
    private javax.swing.JLabel btnDasboard;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnObat;
    private javax.swing.JLabel btnPegawai;
    private javax.swing.JLabel btnSuplier;
    private javax.swing.JLabel btnSupplier;
    private javax.swing.JLabel btnTransaksi;
    private javax.swing.JLabel btnpembelianstok;
    private javax.swing.JLabel btnpembelianstok1;
    private javax.swing.JLabel btnpenjualan;
    private javax.swing.JLabel btnpenjualan1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    private view.swing.Table table;
    // End of variables declaration//GEN-END:variables
}
