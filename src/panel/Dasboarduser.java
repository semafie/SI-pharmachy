
package panel;

import javax.swing.SwingUtilities;
import main.main;
import view.dialog.Validasilogout1;

public class Dasboarduser extends javax.swing.JPanel {

    public Dasboarduser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDasboard = new javax.swing.JLabel();
        btn2 = new javax.swing.JLabel();
        btnObat = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        btnTransaksi = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setLayout(null);

        btnDasboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btndashboard1.png"))); // NOI18N
        add(btnDasboard);
        btnDasboard.setBounds(10, 140, 230, 60);
        add(btn2);
        btn2.setBounds(40, 680, 30, 50);

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

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/bg Dashboard_user.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1366, 768);
    }// </editor-fold>//GEN-END:initComponents

    private void btnObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMouseClicked
    main main = (main)SwingUtilities.getWindowAncestor(this);
    this.setVisible(false);
    main.showObatuser();
    }//GEN-LAST:event_btnObatMouseClicked

    private void btnTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseClicked
    main main = (main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showTransaksiuser();
    }//GEN-LAST:event_btnTransaksiMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
    main main = (main)SwingUtilities.getWindowAncestor(this);
    Validasilogout1 apa = new Validasilogout1(main);
        apa.showPopUp();
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnObatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMouseEntered
    btnObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnobat3.png")));
    }//GEN-LAST:event_btnObatMouseEntered

    private void btnObatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMouseExited
    btnObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnobat2.png")));
    }//GEN-LAST:event_btnObatMouseExited

    private void btnObatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMousePressed
    btnObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnobat4.png")));
    }//GEN-LAST:event_btnObatMousePressed

    private void btnTransaksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseEntered
    btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btntransaksi3.png")));
    }//GEN-LAST:event_btnTransaksiMouseEntered

    private void btnTransaksiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseExited
    btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btntransaksi2.png")));
    }//GEN-LAST:event_btnTransaksiMouseExited

    private void btnTransaksiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMousePressed
    btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btntransaksi4.png")));
    }//GEN-LAST:event_btnTransaksiMousePressed

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
    btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlogout2.png")));
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
    btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlogout1.png")));
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnLogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMousePressed
    btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnlogout3.png")));
    }//GEN-LAST:event_btnLogoutMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btn2;
    private javax.swing.JLabel btnDasboard;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnObat;
    private javax.swing.JLabel btnTransaksi;
    // End of variables declaration//GEN-END:variables
}