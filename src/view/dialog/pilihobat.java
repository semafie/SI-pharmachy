/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import entity.obat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import repository.obatRepository;
import repository.userRepository;
import util.Conn;

/**
 *
 * @author Be Mine
 */
public class pilihobat extends Dialog {
    userRepository pegawai = new userRepository();
    obatRepository datamaster = new obatRepository();
    private int id = 0;
    public pilihobat(JFrame frame) {
        super(frame);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
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
        mmm = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

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
        getContentPane().add(btnsimpan);
        btnsimpan.setBounds(500, 550, 190, 60);

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
        getContentPane().add(btnbatal);
        btnbatal.setBounds(280, 550, 190, 60);

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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 150, 780, 210);

        txt_subtotal.setBorder(null);
        getContentPane().add(txt_subtotal);
        txt_subtotal.setBounds(520, 495, 220, 30);

        txt_jumlah.setBorder(null);
        txt_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyReleased(evt);
            }
        });
        getContentPane().add(txt_jumlah);
        txt_jumlah.setBounds(220, 495, 220, 30);

        txt_hargasatuan.setBorder(null);
        txt_hargasatuan.setFocusable(false);
        getContentPane().add(txt_hargasatuan);
        txt_hargasatuan.setBounds(630, 418, 220, 30);

        txt_namaobat.setBorder(null);
        txt_namaobat.setFocusable(false);
        getContentPane().add(txt_namaobat);
        txt_namaobat.setBounds(350, 415, 230, 30);

        txt_kodeobat.setBorder(null);
        txt_kodeobat.setFocusable(false);
        getContentPane().add(txt_kodeobat);
        txt_kodeobat.setBounds(80, 417, 220, 30);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/form pilih obat.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 960, 630);
        getContentPane().add(mmm);
        mmm.setBounds(730, 70, 64, 22);

        setSize(new java.awt.Dimension(906, 635));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbatalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatalMousePressed
        btnbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatal3.png")));
    }//GEN-LAST:event_btnbatalMousePressed

    private void btnbatalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatalMouseExited
        btnbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatal1.png")));
    }//GEN-LAST:event_btnbatalMouseExited

    private void btnbatalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatalMouseEntered
        btnbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatal2.png")));
    }//GEN-LAST:event_btnbatalMouseEntered

    private void btnbatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatalMouseClicked

        closeMessage();
    }//GEN-LAST:event_btnbatalMouseClicked

    private void btnsimpanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMousePressed
        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsimpan3.png")));
    }//GEN-LAST:event_btnsimpanMousePressed

    private void btnsimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseExited
       btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsimpan1.png")));
    }//GEN-LAST:event_btnsimpanMouseExited

    private void btnsimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseEntered
        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsimpan2.png")));
    }//GEN-LAST:event_btnsimpanMouseEntered

    private void btnsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseClicked
        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsimpan1.png")));
    }//GEN-LAST:event_btnsimpanMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
    int baris = table.rowAtPoint(evt.getPoint());
        String idd = table.getValueAt(baris, 0).toString();
        id = Integer.valueOf(idd);
        System.out.println(id);
        if (id != 0){
            txt_kodeobat.setText(String.valueOf(datamaster.get(id).getId()));
            txt_namaobat.setText(String.valueOf(datamaster.get(id).getNama_obat()));
            txt_hargasatuan.setText(String.valueOf(datamaster.get(id).getHarga_obat()));
        } else {
            
        }
    }//GEN-LAST:event_tableMouseClicked

    private void txt_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyReleased
        load_tabel(txt_jumlah.getText());
    }//GEN-LAST:event_txt_jumlahKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btnbatal;
    private javax.swing.JLabel btnsimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mmm;
    private view.swing.Table table;
    private javax.swing.JTextField txt_hargasatuan;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_kodeobat;
    private javax.swing.JTextField txt_namaobat;
    private javax.swing.JTextField txt_subtotal;
    // End of variables declaration//GEN-END:variables
}
