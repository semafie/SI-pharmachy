
package panel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingUtilities;
import main.main;
import main.mainlogin;
import service.Auth;

public class login_konfirmasinik extends javax.swing.JPanel {

    public login_konfirmasinik() {
        initComponents();
        Font font = new Font("Quicksand", Font.PLAIN, 22);
        txt_nik.setFont(font);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_kirimkode = new javax.swing.JLabel();
        btn_batal = new javax.swing.JLabel();
        txt_nik = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setLayout(null);

        btn_kirimkode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnkonfirmasi1.png"))); // NOI18N
        btn_kirimkode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kirimkodeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_kirimkodeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_kirimkodeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_kirimkodeMousePressed(evt);
            }
        });
        add(btn_kirimkode);
        btn_kirimkode.setBounds(560, 460, 430, 75);

        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatalubahpass1.png"))); // NOI18N
        btn_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_batalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_batalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_batalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_batalMousePressed(evt);
            }
        });
        add(btn_batal);
        btn_batal.setBounds(10, 550, 80, 30);

        txt_nik.setBackground(new Color(0,0,0,0));
        txt_nik.setText("Input Nik Anda");
        txt_nik.setBorder(null);
        txt_nik.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nikFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nikFocusLost(evt);
            }
        });
        add(txt_nik);
        txt_nik.setBounds(590, 290, 290, 40);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/bg konfirmasi nik.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1044, 587);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batalMouseClicked
    mainlogin main = (mainlogin)SwingUtilities.getWindowAncestor(this);
    this.setVisible(false);
    main.showlogin();
    }//GEN-LAST:event_btn_batalMouseClicked

    private void btn_batalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batalMouseEntered
    btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatalubahpass2.png")));
    }//GEN-LAST:event_btn_batalMouseEntered

    private void btn_batalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batalMouseExited
    btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatalubahpass1.png")));
    }//GEN-LAST:event_btn_batalMouseExited

    private void btn_batalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batalMousePressed
    btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnbatalubahpass3.png")));
    }//GEN-LAST:event_btn_batalMousePressed

    private void btn_kirimkodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kirimkodeMouseClicked
    Auth apa = new Auth();
    boolean wow = apa.konfirmasinik(txt_nik.getText());
    if (wow){
        mainlogin main =(mainlogin)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showlupapassword();
    } else {
        System.out.println("NIK TIDAK DITEMUKAN");
    }
    
    }//GEN-LAST:event_btn_kirimkodeMouseClicked

    private void btn_kirimkodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kirimkodeMouseEntered
    btn_kirimkode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnkonfirmasi2.png")));
    }//GEN-LAST:event_btn_kirimkodeMouseEntered

    private void btn_kirimkodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kirimkodeMouseExited
    btn_kirimkode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnkonfirmasi1.png")));
    }//GEN-LAST:event_btn_kirimkodeMouseExited

    private void btn_kirimkodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kirimkodeMousePressed
    btn_kirimkode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnkonfirmasi3.png")));
    }//GEN-LAST:event_btn_kirimkodeMousePressed

    private void txt_nikFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nikFocusGained
        if (txt_nik.getText().equals("Input Nik Anda")) {
            txt_nik.setText("");
            txt_nik.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_nikFocusGained

    private void txt_nikFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nikFocusLost
        if (txt_nik.getText().isEmpty()) {
            txt_nik.setText("Input Nik Anda");
            txt_nik.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txt_nikFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btn_batal;
    private javax.swing.JLabel btn_kirimkode;
    private javax.swing.JTextField txt_nik;
    // End of variables declaration//GEN-END:variables
}
