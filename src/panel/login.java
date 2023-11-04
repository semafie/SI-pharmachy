
package panel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingUtilities;
import main.main;
import main.mainlogin;
import service.Auth;

public class login extends javax.swing.JPanel {
private static boolean isHidden = true;


    public login() {
        initComponents();
        Font font = new Font("Quicksand", Font.PLAIN, 22);
        txt_username.setFont(font);
        txt_password.setFont(font);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnlupa_password = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        btneye = new javax.swing.JLabel();
        btn_login = new javax.swing.JLabel();
        btn_keluar = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setLayout(null);

        btnlupa_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Lupa password_1.png"))); // NOI18N
        btnlupa_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlupa_passwordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlupa_passwordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlupa_passwordMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnlupa_passwordMousePressed(evt);
            }
        });
        add(btnlupa_password);
        btnlupa_password.setBounds(800, 370, 190, 40);

        txt_username.setBackground(new Color(0,0,0,0));
        txt_username.setBorder(null);
        add(txt_username);
        txt_username.setBounds(630, 240, 290, 40);

        txt_password.setBackground(new Color(0,0,0,0));
        txt_password.setBorder(null);
        add(txt_password);
        txt_password.setBounds(630, 320, 290, 40);

        btneye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/eye1.png"))); // NOI18N
        btneye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneyeMouseClicked(evt);
            }
        });
        add(btneye);
        btneye.setBounds(930, 325, 50, 30);

        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlogin1.png"))); // NOI18N
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_loginMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_loginMousePressed(evt);
            }
        });
        add(btn_login);
        btn_login.setBounds(620, 460, 310, 75);

        btn_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsilang1.png"))); // NOI18N
        btn_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_keluarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_keluarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_keluarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_keluarMousePressed(evt);
            }
        });
        add(btn_keluar);
        btn_keluar.setBounds(1010, 15, 19, 19);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/bg Login.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1044, 587);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
    String user = txt_username.getText();
    String pass = txt_password.getText();
        Auth ap = new Auth();
        System.out.println(pass);
        System.out.println(user);
    if(ap.login(user, pass)){
        
            main wow = (main)SwingUtilities.getWindowAncestor(this);
            mainlogin wow1 = (mainlogin)SwingUtilities.getWindowAncestor(this);
        wow.setVisible(true);  
    }else{
        System.out.println("gagal login");
    }
    }//GEN-LAST:event_btn_loginMouseClicked

    private void btnlupa_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlupa_passwordMouseClicked
    mainlogin apa =(mainlogin)SwingUtilities.getWindowAncestor(this);
    this.setVisible(false);
    apa.showkonfirmasi();
    }//GEN-LAST:event_btnlupa_passwordMouseClicked

    private void btn_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_keluarMouseClicked
    mainlogin apa =(mainlogin)SwingUtilities.getWindowAncestor(this);
    apa.dispose();
    }//GEN-LAST:event_btn_keluarMouseClicked

    private void btn_loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseEntered
    btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlogin2.png")));
    }//GEN-LAST:event_btn_loginMouseEntered

    private void btn_loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseExited
    btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlogin1.png")));
    }//GEN-LAST:event_btn_loginMouseExited

    private void btn_loginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMousePressed
    btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlogin3.png")));
    }//GEN-LAST:event_btn_loginMousePressed

    private void btnlupa_passwordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlupa_passwordMouseEntered
    btnlupa_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Lupa password_2.png")));
    }//GEN-LAST:event_btnlupa_passwordMouseEntered

    private void btnlupa_passwordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlupa_passwordMouseExited
    btnlupa_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Lupa password_1.png")));
    }//GEN-LAST:event_btnlupa_passwordMouseExited

    private void btnlupa_passwordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlupa_passwordMousePressed
    btnlupa_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Lupa password_3.png")));
    }//GEN-LAST:event_btnlupa_passwordMousePressed

    private void btn_keluarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_keluarMouseEntered
    btn_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsilang2.png")));
    }//GEN-LAST:event_btn_keluarMouseEntered

    private void btn_keluarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_keluarMouseExited
    btn_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsilang1.png")));
    }//GEN-LAST:event_btn_keluarMouseExited

    private void btn_keluarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_keluarMousePressed
    btn_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsilang3.png")));
    }//GEN-LAST:event_btn_keluarMousePressed

    private void btneyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneyeMouseClicked
    if (isHidden) {
           txt_password.setEchoChar((char) 0);
//            toggleButton.setText("Hide Password");
            btneye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagetxt/eye2.png")));
            isHidden = false;
        } else {
            txt_password.setEchoChar('*');
            btneye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagetxt/eye1.png")));
//            toggleButton.setText("Show Password");
            isHidden = true;
    }
    }//GEN-LAST:event_btneyeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btn_keluar;
    private javax.swing.JLabel btn_login;
    private javax.swing.JLabel btneye;
    private javax.swing.JLabel btnlupa_password;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
