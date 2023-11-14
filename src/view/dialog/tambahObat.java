/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import entity.obat;
import javax.swing.JFrame;
import panel.Obat;
import repository.obatRepository;
import repository.userRepository;

public class tambahObat extends Dialog {
    userRepository pegawai = new userRepository();
    obatRepository apa = new obatRepository();
    public tambahObat(JFrame frame) {
        super(frame);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_jumlahstok = new javax.swing.JTextField();
        txt_namaobat = new javax.swing.JTextField();
        txt_hargaobat = new javax.swing.JTextField();
        btntambah = new javax.swing.JLabel();
        btnbatal = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        txt_jumlahstok.setBorder(null);
        getContentPane().add(txt_jumlahstok);
        txt_jumlahstok.setBounds(50, 370, 480, 40);

        txt_namaobat.setBorder(null);
        getContentPane().add(txt_namaobat);
        txt_namaobat.setBounds(50, 165, 480, 40);

        txt_hargaobat.setBorder(null);
        getContentPane().add(txt_hargaobat);
        txt_hargaobat.setBounds(50, 264, 490, 40);

        btntambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btntambah1.png"))); // NOI18N
        btntambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntambahMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btntambahMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btntambahMousePressed(evt);
            }
        });
        getContentPane().add(btntambah);
        btntambah.setBounds(370, 500, 190, 60);

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
        btnbatal.setBounds(160, 500, 190, 60);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/formtambahobat.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 600, 580);

        setSize(new java.awt.Dimension(610, 584));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntambahMouseClicked
        obat obat = new obat(txt_namaobat.getText(), Integer.valueOf(txt_hargaobat.getText()),Integer.valueOf(txt_jumlahstok.getText()));
        boolean cobanambah = apa.add(obat);
        if(cobanambah){
            Obat iyu = new Obat();
            System.out.println("berhasil");
            closeMessage();
            iyu.load_tabel();
        } else {
            System.out.println("gagal");
        }
    }//GEN-LAST:event_btntambahMouseClicked

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

    private void btntambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntambahMouseEntered
        btntambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btntambah2.png")));
    }//GEN-LAST:event_btntambahMouseEntered

    private void btntambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntambahMouseExited
        btntambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btntambah1.png")));
    }//GEN-LAST:event_btntambahMouseExited

    private void btntambahMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntambahMousePressed
        btntambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btntambah3.png")));
    }//GEN-LAST:event_btntambahMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btnbatal;
    private javax.swing.JLabel btntambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_hargaobat;
    private javax.swing.JTextField txt_jumlahstok;
    private javax.swing.JTextField txt_namaobat;
    // End of variables declaration//GEN-END:variables
}
