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

public class editstokObat extends Dialog {
    Obat apa= new Obat();
    obatRepository obat = new obatRepository();
    private int id = apa.id;
    userRepository pegawai = new userRepository();
    
    public editstokObat(JFrame frame) {
        super(frame);
        initComponents();
        txt_namaObat.setText(obat.get(id).getNama_obat());
        txt_jumlahstokawal.setText(String.valueOf(obat.get(id).getJumlah_stok()));
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
        txt_jumlahstokbaru = new javax.swing.JTextField();
        txt_jumlahstokawal = new javax.swing.JTextField();
        txt_namaObat = new javax.swing.JTextField();
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
        btnedit.setBounds(370, 380, 190, 60);

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
        btnbatal.setBounds(160, 380, 190, 60);

        txt_jumlahstokbaru.setBorder(null);
        getContentPane().add(txt_jumlahstokbaru);
        txt_jumlahstokbaru.setBounds(340, 273, 210, 40);

        txt_jumlahstokawal.setBorder(null);
        txt_jumlahstokawal.setFocusable(false);
        getContentPane().add(txt_jumlahstokawal);
        txt_jumlahstokawal.setBounds(40, 273, 180, 40);

        txt_namaObat.setBorder(null);
        txt_namaObat.setFocusable(false);
        getContentPane().add(txt_namaObat);
        txt_namaObat.setBounds(50, 167, 490, 40);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/formeditstokobat.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 590, 470);

        setSize(new java.awt.Dimension(607, 475));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btneditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseClicked
    int stokbaru = Integer.valueOf(txt_jumlahstokbaru.getText());
    int stoklama = Integer.valueOf(txt_jumlahstokawal.getText());
//    if(stokbaru <= stoklama ){
        obat editya = new obat(id,stokbaru);
    boolean cobak = obat.updatestok(editya);
    if(cobak){
        apa.load_tabel();
        closeMessage();
        System.out.println("berhasil tambah tok");
    }else{
        System.out.println("gagal tambah stok");
    }
//    } else{
//        System.out.println("tidak boleh kurang dari stok lama");
//    }
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btnbatal;
    private javax.swing.JLabel btnedit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_jumlahstokawal;
    private javax.swing.JTextField txt_jumlahstokbaru;
    private javax.swing.JTextField txt_namaObat;
    // End of variables declaration//GEN-END:variables
}
