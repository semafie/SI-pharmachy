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
public class Transaksi2 extends javax.swing.JPanel {

    /**
     * Creates new form Transaksi
     */
    public Transaksi2() {
        initComponents();
        btnpembelianstok.setVisible(false);
        btnpenjualan1.setVisible(false);
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
        btnpembelianstok1 = new javax.swing.JLabel();
        btnpenjualan1 = new javax.swing.JLabel();
        btnpenjualan = new javax.swing.JLabel();
        btnpembelianstok = new javax.swing.JLabel();
        txt_namaobat1 = new javax.swing.JTextField();
        txt_namaobat2 = new javax.swing.JTextField();
        txt_namaobat3 = new javax.swing.JTextField();
        txt_namaobat4 = new javax.swing.JTextField();
        txt_namaobat5 = new javax.swing.JTextField();
        txt_namaobat6 = new javax.swing.JTextField();
        txt_namaobat = new javax.swing.JTextField();
        btncariobat = new javax.swing.JLabel();
        btnreset = new javax.swing.JLabel();
        btnhapustable = new javax.swing.JLabel();
        btnprosestransaksi = new javax.swing.JLabel();
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
        jScrollPane1.setBounds(280, 200, 1020, 240);

        btnpembelianstok1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/pilih pemebelian.png"))); // NOI18N
        btnpembelianstok1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(btnpembelianstok1);
        btnpembelianstok1.setBounds(280, 120, 220, 38);

        btnpenjualan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/Pilih penjualan.png"))); // NOI18N
        btnpenjualan1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnpenjualan1);
        btnpenjualan1.setBounds(510, 120, 220, 38);

        btnpenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/Penjualan.png"))); // NOI18N
        btnpenjualan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpenjualanMouseClicked(evt);
            }
        });
        add(btnpenjualan);
        btnpenjualan.setBounds(560, 125, 130, 30);

        btnpembelianstok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/Pembelian.png"))); // NOI18N
        btnpembelianstok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpembelianstok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpembelianstokMouseClicked(evt);
            }
        });
        add(btnpembelianstok);
        btnpembelianstok.setBounds(330, 130, 140, 19);

        txt_namaobat1.setBackground(new java.awt.Color(245, 241, 241));
        txt_namaobat1.setBorder(null);
        add(txt_namaobat1);
        txt_namaobat1.setBounds(420, 565, 210, 30);

        txt_namaobat2.setBackground(new java.awt.Color(245, 241, 241));
        txt_namaobat2.setBorder(null);
        add(txt_namaobat2);
        txt_namaobat2.setBounds(680, 565, 210, 30);

        txt_namaobat3.setBackground(new java.awt.Color(245, 241, 241));
        txt_namaobat3.setBorder(null);
        add(txt_namaobat3);
        txt_namaobat3.setBounds(950, 565, 210, 30);

        txt_namaobat4.setBackground(new java.awt.Color(245, 241, 241));
        txt_namaobat4.setBorder(null);
        add(txt_namaobat4);
        txt_namaobat4.setBounds(690, 640, 210, 30);

        txt_namaobat5.setBackground(new java.awt.Color(245, 241, 241));
        txt_namaobat5.setBorder(null);
        add(txt_namaobat5);
        txt_namaobat5.setBounds(430, 640, 210, 30);

        txt_namaobat6.setBackground(new java.awt.Color(245, 241, 241));
        txt_namaobat6.setBorder(null);
        add(txt_namaobat6);
        txt_namaobat6.setBounds(950, 635, 210, 30);

        txt_namaobat.setBackground(new java.awt.Color(245, 241, 241));
        txt_namaobat.setBorder(null);
        add(txt_namaobat);
        txt_namaobat.setBounds(680, 495, 210, 30);

        btncariobat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncariobat1.png"))); // NOI18N
        btncariobat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncariobatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncariobatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncariobatMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btncariobatMousePressed(evt);
            }
        });
        add(btncariobat);
        btncariobat.setBounds(1140, 120, 210, 47);

        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnreset1.png"))); // NOI18N
        btnreset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnresetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnresetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnresetMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnresetMousePressed(evt);
            }
        });
        add(btnreset);
        btnreset.setBounds(1220, 470, 130, 40);

        btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel1.png"))); // NOI18N
        btnhapustable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapustableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhapustableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhapustableMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnhapustableMousePressed(evt);
            }
        });
        add(btnhapustable);
        btnhapustable.setBounds(1090, 470, 130, 40);

        btnprosestransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnprosestransaksi1.png"))); // NOI18N
        btnprosestransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnprosestransaksiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnprosestransaksiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnprosestransaksiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnprosestransaksiMousePressed(evt);
            }
        });
        add(btnprosestransaksi);
        btnprosestransaksi.setBounds(650, 690, 280, 60);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/bg Transaksi Penjualan.png"))); // NOI18N
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

    private void btnpenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpenjualanMouseClicked
   
        btnpembelianstok.setVisible(true);
        btnpembelianstok1.setVisible(false);
        btnpenjualan.setVisible(false);
        btnpenjualan1.setVisible(true);
        
    }//GEN-LAST:event_btnpenjualanMouseClicked

    private void btnpembelianstokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpembelianstokMouseClicked
        btnpembelianstok.setVisible(false);
        btnpembelianstok1.setVisible(true);
        btnpenjualan.setVisible(true);
        btnpenjualan1.setVisible(false);
        

    }//GEN-LAST:event_btnpembelianstokMouseClicked

    private void btncariobatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncariobatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btncariobatMouseClicked

    private void btncariobatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncariobatMouseEntered
    btncariobat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncariobat2.png")));
    }//GEN-LAST:event_btncariobatMouseEntered

    private void btncariobatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncariobatMouseExited
    btncariobat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncariobat1.png")));
    }//GEN-LAST:event_btncariobatMouseExited

    private void btncariobatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncariobatMousePressed
    btncariobat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btncariobat3.png")));
    }//GEN-LAST:event_btncariobatMousePressed

    private void btnprosestransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprosestransaksiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnprosestransaksiMouseClicked

    private void btnhapustableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapustableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhapustableMouseClicked

    private void btnresetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnresetMouseClicked

    private void btnprosestransaksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprosestransaksiMouseEntered
    btnprosestransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnprosestransaksi2.png")));
    }//GEN-LAST:event_btnprosestransaksiMouseEntered

    private void btnresetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseEntered
    btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel2.png")));
    }//GEN-LAST:event_btnresetMouseEntered

    private void btnresetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseExited
    btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel1.png")));
    }//GEN-LAST:event_btnresetMouseExited

    private void btnresetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMousePressed
    btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel3.png")));
    }//GEN-LAST:event_btnresetMousePressed

    private void btnhapustableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapustableMouseEntered
    btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel2.png")));
    }//GEN-LAST:event_btnhapustableMouseEntered

    private void btnhapustableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapustableMouseExited
    btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel1.png")));
    }//GEN-LAST:event_btnhapustableMouseExited

    private void btnhapustableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapustableMousePressed
    btnhapustable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnhapustabel3.png")));
    }//GEN-LAST:event_btnhapustableMousePressed

    private void btnprosestransaksiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprosestransaksiMouseExited
    btnprosestransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnprosestransaksi1.png")));
    }//GEN-LAST:event_btnprosestransaksiMouseExited

    private void btnprosestransaksiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprosestransaksiMousePressed
    btnprosestransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnprosestransaksi3.png")));
    }//GEN-LAST:event_btnprosestransaksiMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btnDasboard;
    private javax.swing.JLabel btnLaporan;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnObat;
    private javax.swing.JLabel btnPegawai;
    private javax.swing.JLabel btnSuplier;
    private javax.swing.JLabel btnSupplier;
    private javax.swing.JLabel btncariobat;
    private javax.swing.JLabel btnhapustable;
    private javax.swing.JLabel btnpembelianstok;
    private javax.swing.JLabel btnpembelianstok1;
    private javax.swing.JLabel btnpenjualan;
    private javax.swing.JLabel btnpenjualan1;
    private javax.swing.JLabel btnprosestransaksi;
    private javax.swing.JLabel btnreset;
    private javax.swing.JScrollPane jScrollPane1;
    private view.swing.Table table1;
    private javax.swing.JTextField txt_namaobat;
    private javax.swing.JTextField txt_namaobat1;
    private javax.swing.JTextField txt_namaobat2;
    private javax.swing.JTextField txt_namaobat3;
    private javax.swing.JTextField txt_namaobat4;
    private javax.swing.JTextField txt_namaobat5;
    private javax.swing.JTextField txt_namaobat6;
    // End of variables declaration//GEN-END:variables
}
