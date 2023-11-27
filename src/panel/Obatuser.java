
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
import entity.obat;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import main.main;
import repository.obatRepository;
import util.Conn;
import view.dialog.Validasilogout1;
import view.dialog.editObat;
import view.dialog.editstokObat;
import view.dialog.tambahObat;

public class Obatuser extends javax.swing.JPanel {
private String pilih = "semua stok";
    obatRepository datamaster = new obatRepository();
    public static int id;
    
    public Obatuser() {
        initComponents();
        
        btnCetak.setVisible(false);
//        if(pilih.equals("semua stok")){
        load_tabel();
//        }
        int rowCount = table.getRowCount();
        total.setText(String.valueOf(rowCount));
        DefaultCellEditor cellEditor = new DefaultCellEditor(new JTextField()) {
    @Override
    public boolean isCellEditable(EventObject e) {
        return false;
    }
};
        table.setDefaultEditor(Object.class, cellEditor);
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
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnObat = new javax.swing.JLabel();
        btnDasboard = new javax.swing.JLabel();
        btnTransaksi = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new view.swing.Table();
        total = new javax.swing.JLabel();
        btnCetak = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setLayout(null);

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
        btnTransaksi.setBounds(10, 295, 230, 60);

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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        add(jScrollPane1);
        jScrollPane1.setBounds(300, 250, 1000, 402);
        add(total);
        total.setBounds(430, 730, 30, 30);

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
        btnLaporan.setBounds(10, 370, 230, 60);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/bg Obat stok menipis user.png"))); // NOI18N
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bgMouseEntered(evt);
            }
        });
        add(bg);
        bg.setBounds(0, 0, 1366, 768);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseClicked
    main main = (main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showTransaksiuser();
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

    private void btnDasboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDasboardMouseClicked
    main main =(main)SwingUtilities.getWindowAncestor(this);
    this.setVisible(false);
    main.showDasboard();
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

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        load_tabel(search.getText());
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

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
    int baris = table.rowAtPoint(evt.getPoint());
        String idd = table.getValueAt(baris, 0).toString();
        id = Integer.valueOf(idd);
    }//GEN-LAST:event_tableMouseClicked

    private void bgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseEntered
//    load_tabel();
    }//GEN-LAST:event_bgMouseEntered

    private void tableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseEntered
//    load_tabel();
    }//GEN-LAST:event_tableMouseEntered

    private void btnLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseClicked
        main main = (main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showLaporanuser();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btnCetak;
    private javax.swing.JLabel btnDasboard;
    private javax.swing.JLabel btnLaporan;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnObat;
    private javax.swing.JLabel btnTransaksi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    public static view.swing.Table table;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
