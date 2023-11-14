/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panel;

import javax.swing.SwingUtilities;
import main.main;
import view.dialog.Validasilogout1;

/**
 *
 * @author RESCOM-1
 */
public class Transaksi extends javax.swing.JPanel {

    /**
     * Creates new form Transaksi
     */
    public Transaksi() {
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

        btnLogout = new javax.swing.JLabel();
        btnPegawai = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JLabel();
        btnSuplier = new javax.swing.JLabel();
        btnObat = new javax.swing.JLabel();
        btnDasboard = new javax.swing.JLabel();
        btnSupplier = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new view.swing.Table();
        bg = new javax.swing.JLabel();

        setLayout(null);

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

        btnPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnpegawai2.png"))); // NOI18N
        btnPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPegawaiMousePressed(evt);
            }
        });
        add(btnPegawai);
        btnPegawai.setBounds(10, 520, 230, 60);

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
        btnLaporan.setBounds(10, 445, 230, 60);

        btnSuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btntransaksi1.png"))); // NOI18N
        add(btnSuplier);
        btnSuplier.setBounds(10, 370, 230, 60);

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

        btnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsupplier2.png"))); // NOI18N
        btnSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSupplierMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSupplierMousePressed(evt);
            }
        });
        add(btnSupplier);
        btnSupplier.setBounds(10, 295, 230, 60);

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table1);

        add(jScrollPane1);
        jScrollPane1.setBounds(300, 200, 1000, 240);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/bg Transaksi Pembelian.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1366, 768);
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseClicked
    main main = (main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showPegawai();
    }//GEN-LAST:event_btnPegawaiMouseClicked

    private void btnPegawaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseEntered
        btnPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnpegawai3.png")));
    }//GEN-LAST:event_btnPegawaiMouseEntered

    private void btnPegawaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseExited
        btnPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnpegawai2.png")));
    }//GEN-LAST:event_btnPegawaiMouseExited

    private void btnPegawaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMousePressed
        btnPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnpegawai4.png")));
    }//GEN-LAST:event_btnPegawaiMousePressed

    private void btnLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseClicked
    main main = (main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showLaporan();
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

    private void btnObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMouseClicked
        main main = (main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showObat();
    }//GEN-LAST:event_btnObatMouseClicked

    private void btnObatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMouseEntered
        btnObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnobat3.png")));
    }//GEN-LAST:event_btnObatMouseEntered

    private void btnObatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMouseExited
        btnObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnobat2.png")));
    }//GEN-LAST:event_btnObatMouseExited

    private void btnObatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMousePressed
        btnObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnobat4.png")));
    }//GEN-LAST:event_btnObatMousePressed

    private void btnDasboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDasboardMouseClicked
        main main =(main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showDasboardOwner();
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

    private void btnSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMouseClicked
        main main = (main)SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        main.showSuplier();
    }//GEN-LAST:event_btnSupplierMouseClicked

    private void btnSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMouseEntered
        btnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsupplier3.png")));
    }//GEN-LAST:event_btnSupplierMouseEntered

    private void btnSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMouseExited
        btnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsupplier2.png")));
    }//GEN-LAST:event_btnSupplierMouseExited

    private void btnSupplierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMousePressed
        btnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnsupplier4.png")));
    }//GEN-LAST:event_btnSupplierMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btnDasboard;
    private javax.swing.JLabel btnLaporan;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnObat;
    private javax.swing.JLabel btnPegawai;
    private javax.swing.JLabel btnSuplier;
    private javax.swing.JLabel btnSupplier;
    private javax.swing.JScrollPane jScrollPane1;
    private view.swing.Table table1;
    // End of variables declaration//GEN-END:variables
}
