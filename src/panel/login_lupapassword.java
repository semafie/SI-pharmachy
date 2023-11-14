
package panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import main.mainlogin;
import static panel.login.setHintText;
import service.Auth;
public class login_lupapassword extends javax.swing.JPanel {
    
    private static boolean isHidden = true;
    public login_lupapassword() {
        initComponents();
        Font font = new Font("Quicksand", Font.PLAIN, 22);
        setHintText(txt_password1, "Input Password");
        setHintText(txt_password, "Confirm Password");
    }
    
     public static void setHintText(JPasswordField passwordField, String hintText) {
        passwordField.setText(hintText);
        passwordField.setEchoChar((char) 0);
        passwordField.setForeground(Color.GRAY);// Set echo character to '*'
        
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals(hintText)) {
                    passwordField.setEchoChar('*'); // Show '*' for hint text
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("")) {
                    passwordField.setEchoChar((char) 0); // Show actual characters for input
                    passwordField.setText(hintText);
                    passwordField.setForeground(Color.GRAY);
                    
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_gantipassword = new javax.swing.JLabel();
        txt_password1 = new javax.swing.JPasswordField();
        txt_password = new javax.swing.JPasswordField();
        btneye2 = new javax.swing.JLabel();
        btneye = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setLayout(null);

        btn_gantipassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnubahpassword1.png"))); // NOI18N
        btn_gantipassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_gantipasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_gantipasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_gantipasswordMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_gantipasswordMousePressed(evt);
            }
        });
        add(btn_gantipassword);
        btn_gantipassword.setBounds(620, 460, 310, 75);

        txt_password1.setBackground(new Color(0,0,0,0));
        txt_password1.setBorder(null);
        add(txt_password1);
        txt_password1.setBounds(630, 240, 290, 40);

        txt_password.setBackground(new Color(0,0,0,0));
        txt_password.setBorder(null);
        add(txt_password);
        txt_password.setBounds(630, 320, 290, 40);

        btneye2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/eye1.png"))); // NOI18N
        btneye2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneye2MouseClicked(evt);
            }
        });
        add(btneye2);
        btneye2.setBounds(930, 250, 50, 30);

        btneye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/eye1.png"))); // NOI18N
        btneye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneyeMouseClicked(evt);
            }
        });
        add(btneye);
        btneye.setBounds(930, 325, 50, 30);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/bg gantipassword.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1044, 590);
    }// </editor-fold>//GEN-END:initComponents

    private void btneyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneyeMouseClicked
        if (isHidden) {
            txt_password.setEchoChar((char) 0);
            //            toggleButton.setText("Hide Password");
            btneye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/eye2.png")));
            isHidden = false;
        } else {
            txt_password.setEchoChar('*');
            btneye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/eye1.png")));
            //            toggleButton.setText("Show Password");
            isHidden = true;
        }
    }//GEN-LAST:event_btneyeMouseClicked

    private void btneye2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneye2MouseClicked
        if (isHidden) {
            txt_password1.setEchoChar((char) 0);
            //            toggleButton.setText("Hide Password");
            btneye2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/eye2.png")));
            isHidden = false;
        } else {
            txt_password1.setEchoChar('*');
            btneye2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/eye1.png")));
            //            toggleButton.setText("Show Password");
            isHidden = true;
        }
    }//GEN-LAST:event_btneye2MouseClicked

    private void btn_gantipasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gantipasswordMouseEntered
    btn_gantipassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnubahpassword2.png")));
    }//GEN-LAST:event_btn_gantipasswordMouseEntered

    private void btn_gantipasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gantipasswordMouseClicked
    String hayo = txt_password.getText();
    String hayo1 = txt_password1.getText();
    Auth apa = new Auth();
    String nikyo = apa.nik;
        System.out.println(nikyo);
    if(hayo.equals(hayo1)){
        boolean uwow = apa.changePass(hayo, nikyo);
        if(uwow){
            mainlogin main =(mainlogin)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showlogin();
        } else {
            System.out.println("gagal ubah pass");
        }
    }else{
        
    }
    }//GEN-LAST:event_btn_gantipasswordMouseClicked

    private void btn_gantipasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gantipasswordMouseExited
    btn_gantipassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnubahpassword1.png")));
    }//GEN-LAST:event_btn_gantipasswordMouseExited

    private void btn_gantipasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gantipasswordMousePressed
    btn_gantipassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnubahpassword3.png")));
    }//GEN-LAST:event_btn_gantipasswordMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btn_gantipassword;
    private javax.swing.JLabel btneye;
    private javax.swing.JLabel btneye2;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JPasswordField txt_password1;
    // End of variables declaration//GEN-END:variables
}
