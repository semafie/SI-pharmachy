
package view.dialog;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import main.main;

public class validasiberhasil extends Dialog {
    private int aaa;
    

    public validasiberhasil(JFrame fram, String pindahnyakemana) {
        super(fram);
        initComponents();
        Font font = new Font("Quicksand", Font.BOLD, 13);
        txt_peringatan.setFont(font);
        txt_peringatan.setHorizontalAlignment(SwingConstants.CENTER);
        txt_peringatan.setText(pindahnyakemana);
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_peringatan = new javax.swing.JLabel();
        button = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt_peringatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 500, 60));

        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnoke1.png"))); // NOI18N
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonMousePressed(evt);
            }
        });
        getContentPane().add(button, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 120, 40));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebg/Validasi Jamaah ( Tambah ).png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 333));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseClicked
    
    closeMessage();
    
    }//GEN-LAST:event_buttonMouseClicked

    private void buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseEntered
    button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnoke2.png")));
    }//GEN-LAST:event_buttonMouseEntered

    private void buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseExited
    button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnoke1.png")));
    }//GEN-LAST:event_buttonMouseExited

    private void buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMousePressed
    button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagebtn/btnoke3.png")));
    }//GEN-LAST:event_buttonMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel button;
    private javax.swing.JLabel txt_peringatan;
    // End of variables declaration//GEN-END:variables
}
