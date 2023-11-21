/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dede {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("Contoh Tabel Java");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat tabel dengan 5 kolom
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        // Menambahkan kolom ke dalam tabel
        model.addColumn("Kolom 1");
        model.addColumn("Kolom 2");
        model.addColumn("Kolom 3");
        model.addColumn("Kolom 4");
        model.addColumn("Kolom 5");

        // Menambahkan tabel ke dalam frame
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);

        // Membuat JButton untuk menambahkan baris baru
        JButton addButton = new JButton("Tambah Baris");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahData(model, "Data Baru", 0, 0, 0, "Data Baru");
            }
        });

        // Menambahkan JButton ke dalam frame
        frame.getContentPane().add(addButton, "South");

        // Menampilkan frame
        frame.setSize(500, 200);
        frame.setVisible(true);
    }

    // Metode untuk menambahkan data ke dalam tabel
    private static void tambahData(DefaultTableModel model, String col1, int col2, int col3, int col4, String col5) {
        Object[] data = {col1, col2, col3, col4, col5};
        model.addRow(data);
    }
}

