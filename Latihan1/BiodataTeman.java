package Latihan1;

import javax.swing.*;
import java.awt.event.*;

public class BiodataTeman extends JFrame {
    // Komponen form
    private JTextField textFieldNama;
    private JTextField textFieldHP;
    private JRadioButton radioButtonLaki;
    private JRadioButton radioButtonPerempuan;
    private JCheckBox checkBoxWNA;
    private JTextArea txtOutput;

    public BiodataTeman() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Aplikasi Biodata Teman");
        
        // Label Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 40, 100, 25);
        
        // Text Field Nama
        textFieldNama = new JTextField();
        textFieldNama.setBounds(120, 40, 200, 25);
        
        // Label Nomor HP
        JLabel labelHP = new JLabel("Nomor HP:");
        labelHP.setBounds(15, 80, 100, 25);
        
        // Text Field Nomor HP
        textFieldHP = new JTextField();
        textFieldHP.setBounds(120, 80, 200, 25);
        
        // Label Jenis Kelamin
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        labelGender.setBounds(15, 120, 100, 25);
        
        // Radio Button Laki-Laki
        radioButtonLaki = new JRadioButton("Laki-Laki");
        radioButtonLaki.setBounds(120, 120, 100, 25);
        
        // Radio Button Perempuan
        radioButtonPerempuan = new JRadioButton("Perempuan");
        radioButtonPerempuan.setBounds(220, 120, 100, 25);
        
        // ButtonGroup untuk memastikan hanya satu radio button yang bisa dipilih
        ButtonGroup groupGender = new ButtonGroup();
        groupGender.add(radioButtonLaki);
        groupGender.add(radioButtonPerempuan);
        
        // Checkbox WNA
        checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(120, 160, 200, 25);
        
        // Tombol Simpan
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(120, 200, 100, 30);
        
        // TextArea untuk menampilkan output
        txtOutput = new JTextArea();
        txtOutput.setBounds(15, 250, 350, 150);
        txtOutput.setEditable(false); // Output hanya dapat dibaca
        
        // Action Listener untuk tombol Simpan
        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengambil data dari field dan radio button
                String nama = textFieldNama.getText();
                String nomorHP = textFieldHP.getText();
                String jenisKelamin = "";
                if (radioButtonLaki.isSelected()) {
                    jenisKelamin = "Laki-Laki";
                } else if (radioButtonPerempuan.isSelected()) {
                    jenisKelamin = "Perempuan";
                }
                
                // Mengambil status WNA
                String wna = checkBoxWNA.isSelected() ? "Ya" : "Bukan";
                
                // Menampilkan hasil di JTextArea
                txtOutput.setText("");
                txtOutput.append("Nama: " + nama + "\n");
                txtOutput.append("Nomor HP: " + nomorHP + "\n");
                txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
                txtOutput.append("WNA: " + wna + "\n");
                
                // Membersihkan input setelah disimpan
                textFieldNama.setText("");
                textFieldHP.setText("");
                groupGender.clearSelection(); // Reset pilihan radio button
                checkBoxWNA.setSelected(false); // Reset checkbox
            }
        });

        // Menambahkan komponen ke frame
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelHP);
        this.add(textFieldHP);
        this.add(labelGender);
        this.add(radioButtonLaki);
        this.add(radioButtonPerempuan);
        this.add(checkBoxWNA);
        this.add(buttonSimpan);
        this.add(txtOutput);
        
        // Mengatur ukuran frame dan layout
        this.setSize(400, 450);
        this.setLayout(null); // Menggunakan layout null untuk posisi absolut
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataTeman frame = new BiodataTeman();
                frame.setVisible(true);
            }
        });
    }
}
