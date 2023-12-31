/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import entity.user;
import javax.swing.JFrame;
import panel.Pegawai;
import repository.userRepository;

/**
 *
 * @author Be Mine
 */
public class tambahPegawai extends Dialog {
    userRepository segawai = new userRepository();
    
    
    public tambahPegawai(JFrame frame) {
        super(frame);
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmb_jeniskelamin = new javax.swing.JComboBox<>();
        txt_notelp = new javax.swing.JTextField();
        txt_nik = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        txt_namaPegawai = new javax.swing.JTextField();
        btntambah = new javax.swing.JLabel();
        btnbatal = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        cmb_jeniskelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki - Laki ", "Perempuan", " " }));
        cmb_jeniskelamin.setBorder(null);
        getContentPane().add(cmb_jeniskelamin);
        cmb_jeniskelamin.setBounds(90, 334, 380, 40);

        txt_notelp.setBorder(null);
        txt_notelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_notelpActionPerformed(evt);
            }
        });
        getContentPane().add(txt_notelp);
        txt_notelp.setBounds(310, 435, 380, 40);

        txt_nik.setBorder(null);
        getContentPane().add(txt_nik);
        txt_nik.setBounds(530, 332, 380, 40);

        txt_password.setBorder(null);
        getContentPane().add(txt_password);
        txt_password.setBounds(530, 230, 330, 40);

        txt_username.setBorder(null);
        getContentPane().add(txt_username);
        txt_username.setBounds(530, 130, 380, 40);

        txt_alamat.setBorder(null);
        getContentPane().add(txt_alamat);
        txt_alamat.setBounds(90, 230, 380, 40);

        txt_namaPegawai.setBorder(null);
        getContentPane().add(txt_namaPegawai);
        txt_namaPegawai.setBounds(90, 130, 380, 40);

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
        btntambah.setBounds(510, 500, 190, 60);

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
        btnbatal.setBounds(300, 500, 190, 60);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/formtambahpegawai.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 960, 580);

        setSize(new java.awt.Dimension(970, 584));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntambahMouseClicked
    Object ses = cmb_jeniskelamin.getSelectedItem();
        String jnk = ses.toString();
        user dede = new user(txt_namaPegawai.getText(), txt_username.getText(), txt_password.getText(), txt_nik.getText(), jnk, txt_alamat.getText(),
                txt_notelp.getText(), 2);
        boolean cobak = segawai.add(dede);
        if(cobak){
            System.out.println("berhasil Menambahkan pegawai");
            closeMessage();
            
        }else {
            System.out.println("Gagal menambahkan pegawai");
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

    private void txt_notelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_notelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_notelpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btnbatal;
    private javax.swing.JLabel btntambah;
    private javax.swing.JComboBox<String> cmb_jeniskelamin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_namaPegawai;
    private javax.swing.JTextField txt_nik;
    private javax.swing.JTextField txt_notelp;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
