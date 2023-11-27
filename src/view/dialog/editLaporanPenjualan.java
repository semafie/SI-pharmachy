/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import entity.penjualan;import javax.swing.JFrame;
import panel.Laporan;
import repository.penjualanRepository;
import repository.userRepository;

/**
 *
 * @author Be Mine
 */
public class editLaporanPenjualan extends Dialog {
    penjualanRepository penjualan = new penjualanRepository();
    private int id = Laporan.id;
    public editLaporanPenjualan(JFrame frame) {
        super(frame);
        initComponents();
        txt_jumlahbayar.setText(String.valueOf(penjualan.get(id).getJumlahbayar()));
        txt_kembalian.setText(String.valueOf(penjualan.get(id).getKembalian()));
        txt_totalharga.setText(String.valueOf(penjualan.get(id).getTotal_harga()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnedit = new javax.swing.JLabel();
        btnbatal = new javax.swing.JLabel();
        txt_kembalian = new javax.swing.JTextField();
        txt_jumlahbayar = new javax.swing.JTextField();
        txt_totalharga = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnedit1.png"))); // NOI18N
        btnedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btneditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btneditMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btneditMousePressed(evt);
            }
        });
        getContentPane().add(btnedit);
        btnedit.setBounds(310, 540, 190, 60);

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
        btnbatal.setBounds(100, 540, 190, 60);

        txt_kembalian.setBorder(null);
        txt_kembalian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_kembalian.setFocusable(false);
        getContentPane().add(txt_kembalian);
        txt_kembalian.setBounds(50, 448, 520, 40);

        txt_jumlahbayar.setBorder(null);
        txt_jumlahbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jumlahbayarKeyReleased(evt);
            }
        });
        getContentPane().add(txt_jumlahbayar);
        txt_jumlahbayar.setBounds(50, 358, 520, 40);

        txt_totalharga.setBorder(null);
        getContentPane().add(txt_totalharga);
        txt_totalharga.setBounds(50, 268, 520, 40);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/formeditlaporanpenjualan.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 620, 690);

        setSize(new java.awt.Dimension(632, 699));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btneditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseClicked
    penjualan apa = new penjualan(id, Integer.valueOf(txt_totalharga.getText()), Integer.valueOf(txt_jumlahbayar.getText()),
            Integer.valueOf(txt_kembalian.getText()));
    boolean cobak = penjualan.update(apa);
    if(cobak){
        System.out.println("berhasil edit");
    }else {
        System.out.println("gagal edit");
    }
    }//GEN-LAST:event_btneditMouseClicked

    private void btnbatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatalMouseClicked
    
        closeMessage();
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

    private void btneditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseEntered
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnedit2.png")));
    }//GEN-LAST:event_btneditMouseEntered

    private void btneditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseExited
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnedit1.png")));
    }//GEN-LAST:event_btneditMouseExited

    private void btneditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMousePressed
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnedit3.png")));
    }//GEN-LAST:event_btneditMousePressed

    private void txt_jumlahbayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahbayarKeyReleased
    txt_kembalian.setText(String.valueOf(Integer.valueOf(txt_jumlahbayar.getText()) - Integer.valueOf(txt_totalharga.getText())));
    }//GEN-LAST:event_txt_jumlahbayarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btnbatal;
    private javax.swing.JLabel btnedit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_jumlahbayar;
    private javax.swing.JTextField txt_kembalian;
    private javax.swing.JTextField txt_totalharga;
    // End of variables declaration//GEN-END:variables
}
