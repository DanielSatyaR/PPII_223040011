package Latihan1;


import java.awt.event.*;
import javax.swing.*;

public class BiodataApp extends JFrame {

    // Constructor
    public BiodataApp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label dan TextField untuk Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(50, 30, 100, 30);
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(150, 30, 200, 30);

        // Label dan TextField untuk Nomor Telepon
        JLabel labelTelepon = new JLabel("Nomor Telepon:");
        labelTelepon.setBounds(50, 70, 100, 30);
        JTextField textFieldTelepon = new JTextField();
        textFieldTelepon.setBounds(150, 70, 200, 30);

        // CheckBox untuk menandai apakah teman ini adalah favorit
        JCheckBox checkBoxFavorit = new JCheckBox("Tambahkan ke Favorit");
        checkBoxFavorit.setBounds(150, 110, 200, 30);

        // Tombol untuk menambahkan biodata
        JButton buttonTambah = new JButton("Tambah Biodata");
        buttonTambah.setBounds(150, 150, 200, 30);

        // TextArea untuk menampilkan biodata yang disimpan
        JTextArea textAreaBiodata = new JTextArea();
        textAreaBiodata.setBounds(50, 200, 300, 150);
        textAreaBiodata.setEditable(false); // Non-editable oleh pengguna

        // ScrollPane untuk JTextArea
        JScrollPane scrollPane = new JScrollPane(textAreaBiodata);
        scrollPane.setBounds(50, 200, 300, 150);

        // Event Listener untuk tombol "Tambah Biodata"
        buttonTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String telepon = textFieldTelepon.getText();
                
                // Cek apakah nama dan telepon sudah diisi
                if (nama.isEmpty() || telepon.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nama dan Nomor Telepon harus diisi!");
                    return;
                }

                // Tambahkan data ke JTextArea
                String favorit = checkBoxFavorit.isSelected() ? " (Favorit)" : "";
                String biodata = "Nama: " + nama + "\nNomor: " + telepon + favorit + "\n" + "------------------------\n";
                textAreaBiodata.append(biodata);

                // Kosongkan TextField setelah menambahkan data
                textFieldNama.setText("");
                textFieldTelepon.setText("");
            }
        });

        // Tambahkan komponen ke JFrame
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelTelepon);
        this.add(textFieldTelepon);
        this.add(checkBoxFavorit);
        this.add(buttonTambah);
        this.add(scrollPane);

        // Pengaturan ukuran dan layout JFrame
        this.setSize(400, 400);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataApp app = new BiodataApp();
                app.setVisible(true);
            }
        });
    }
}