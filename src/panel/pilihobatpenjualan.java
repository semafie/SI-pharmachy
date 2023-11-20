/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panel;

import entity.obat;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import repository.obatRepository;
import util.Conn;
import view.glasspanel.GlassPanePopup;

/**
 *
 * @author RESCOM-1
 */
public class pilihobatpenjualan extends javax.swing.JPanel {
    private int id = 0;
    public static int jumlah,subtotal;
//    public static String nama,kode, harga,jumlah,subtotal; 
obatRepository datamaster = new obatRepository();
    public pilihobatpenjualan() {
        initComponents();
        load_tabel();
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
    private static void tambahData(DefaultTableModel model, String col1, String col2, int col3, int col4, int col5) {
        Object[] data = {col1, col2, col3, col4, col5};
        model.addRow(data);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnsimpan = new javax.swing.JLabel();
        btnbatal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new view.swing.Table();
        txt_subtotal = new javax.swing.JTextField();
        txt_jumlah = new javax.swing.JTextField();
        txt_hargasatuan = new javax.swing.JTextField();
        txt_namaobat = new javax.swing.JTextField();
        txt_kodeobat = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, -1, 60));

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
        add(btnbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 550, -1, 60));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 780, 200));

        txt_subtotal.setBorder(null);
        add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 220, 30));

        txt_jumlah.setBorder(null);
        txt_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyReleased(evt);
            }
        });
        add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, 220, 30));

        txt_hargasatuan.setBorder(null);
        add(txt_hargasatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 220, 30));

        txt_namaobat.setBorder(null);
        add(txt_namaobat, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 230, 30));

        txt_kodeobat.setBorder(null);
        add(txt_kodeobat, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 220, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/form pilih obat.png"))); // NOI18N
        add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseClicked
        tambahData(txt_kodeobat, TOOL_TIP_TEXT_KEY, ABORT, ABORT, ABORT, TOOL_TIP_TEXT_KEY);
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

        GlassPanePopup.closePopupLast();
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

    private void txt_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyReleased
        updateTextField2(txt_jumlah.getText());
    }//GEN-LAST:event_txt_jumlahKeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
    int baris = table.rowAtPoint(evt.getPoint());
        String idd = table.getValueAt(baris, 0).toString();
        id = Integer.valueOf(idd);
        System.out.println(id);
            if(id != 0){
            txt_namaobat.setText(datamaster.get(id).getNama_obat());
            txt_hargasatuan.setText(String.valueOf(datamaster.get(id).getHarga_obat()));
            txt_kodeobat.setText(String.valueOf(datamaster.get(id).getId()));
        } else {
            System.out.println("haloo");
        }
            
    }//GEN-LAST:event_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btnbatal;
    private javax.swing.JLabel btnsimpan;
    private javax.swing.JScrollPane jScrollPane1;
    private view.swing.Table table;
    private javax.swing.JTextField txt_hargasatuan;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_kodeobat;
    private javax.swing.JTextField txt_namaobat;
    private javax.swing.JTextField txt_subtotal;
    // End of variables declaration//GEN-END:variables
}
