
package main;

import panel.Dasboarduser;
import panel.DasboardOwner;
import panel.Laporan;
import panel.Laporan1;
import panel.Obat;
import panel.Obatuser;
import panel.Pegawai;
import panel.Suplier;
import panel.Transaksi;
import panel.Transaksi2;
import panel.Transaksiuser;
import service.Auth;
import view.glasspanel.GlassPanePopup;

public class main extends javax.swing.JFrame {

    public main() {
        initComponents();
        if (Auth.level == 1) { 
            showDasboardOwner();
        }else {
            showDasboard();
        }
        
        GlassPanePopup.install(this);
    }
    public void showDasboardOwner(){
        DasboardOwner a = new DasboardOwner();
        a.setSize(1366,768);
        this.add(a);
        this.revalidate();
        this.repaint();
    }
    public void showDasboard(){
        Dasboarduser a = new Dasboarduser();
        
        a.setSize(1366,768);
        this.add(a);
        this.revalidate();
        this.repaint();
    }
    public void showObat(){
        Obat a = new Obat();
        a.load_tabel();
        a.setSize(1366,768);
        this.add(a);
        this.revalidate();
        this.repaint();
    }
    public void showObatuser(){
        Obatuser a = new Obatuser();
        a.load_tabel();
        a.setSize(1366,768);
        this.add(a);
        this.revalidate();
        this.repaint();
    }
    public void showSuplier(){
        Suplier a = new Suplier();
        a.setSize(1366,768);
        this.add(a);
        this.revalidate();
        this.repaint();
    }
    public void showTransaksi(){
        Transaksi a = new Transaksi();
        a.setSize(1366,768);
        this.add(a);
        this.revalidate();
        this.repaint();
    }
    public void showTransaksi2(){
        Transaksi2 a = new Transaksi2();
        a.setSize(1366,768);
        this.add(a);
        this.revalidate();
        this.repaint();
    }
    public void showTransaksiuser(){
        Transaksiuser a = new Transaksiuser();
        a.setSize(1366,768);
        this.add(a);
        this.revalidate();
        this.repaint();
    }
    public void showLaporan(){
        Laporan a = new Laporan();
        a.setSize(1366,768);
        this.add(a);
        this.revalidate();
        this.repaint();
    }
    public void showLaporan1(){
        Laporan1 a = new Laporan1();
        a.setSize(1366,768);
        this.add(a);
        this.revalidate();
        this.repaint();
    }
    public void showPegawai(){
        Pegawai a = new Pegawai();
        a.setSize(1366,768);
        this.add(a);
        this.revalidate();
        this.repaint();
    }
    public void pilihpilih(){
        Pegawai a = new Pegawai();
        a.setSize(1366,768);
        this.add(a);
        this.revalidate();
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
