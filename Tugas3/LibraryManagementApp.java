package Tugas3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LibraryManagementApp extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem bookFormItem;

    public LibraryManagementApp() {
        setTitle("Aplikasi Manajemen Perpustakaan");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Membuat menu bar
        menuBar = new JMenuBar();
        menu = new JMenu("Navigasi");

        bookFormItem = new JMenuItem("Form Buku");
        bookFormItem.addActionListener(e -> openBookForm());

        menu.add(bookFormItem);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        setVisible(true);
    }

    // Form Buku
    private void openBookForm() {
        JFrame bookFrame = new JFrame("Form Buku");
        bookFrame.setSize(600, 500);
        bookFrame.setLayout(new BorderLayout());

        // Panel Input Buku
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(25, 10, 25, 10)); // Add padding

        JTextField titleField = new JTextField();
        JTextArea descriptionArea = new JTextArea(3, 20);
        JRadioButton fictionRadio = new JRadioButton("Fiksi");
        JRadioButton nonFictionRadio = new JRadioButton("Non-Fiksi");
        JCheckBox availableCheckBox = new JCheckBox("Tersedia");
        JComboBox<String> genreComboBox = new JComboBox<>(new String[]{"Roman", "Sejarah", "Teknologi", "Sains"});
        JTextField authorField = new JTextField();
        JSpinner publicationYearSpinner = new JSpinner(new SpinnerNumberModel(2024, 1900, 2100, 1));

        ButtonGroup genreGroup = new ButtonGroup();
        genreGroup.add(fictionRadio);
        genreGroup.add(nonFictionRadio);

        inputPanel.add(new JLabel("Judul Buku:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Deskripsi:"));
        inputPanel.add(new JScrollPane(descriptionArea));
        inputPanel.add(new JLabel("Kategori:"));
        JPanel genrePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genrePanel.add(fictionRadio);
        genrePanel.add(nonFictionRadio);
        inputPanel.add(genrePanel);
        inputPanel.add(new JLabel("Tahun Terbit:"));
        inputPanel.add(publicationYearSpinner);
        inputPanel.add(new JLabel("Penulis:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Status:"));
        inputPanel.add(availableCheckBox);
        inputPanel.add(new JLabel("Genre:"));
        inputPanel.add(genreComboBox);

        // Membuat panel input dapat di-scroll
        JScrollPane inputScrollPane = new JScrollPane(inputPanel);
        
        // Tombol Submit dan Hapus
        JButton submitButton = new JButton("Submit");
        JButton deleteButton = new JButton("Hapus"); // Tombol Hapus
        DefaultTableModel bookTableModel = new DefaultTableModel(new Object[]{"Judul", "Deskripsi", "Kategori", "Tahun Terbit", "Status", "Genre", "Penulis"}, 0);
        JTable bookTable = new JTable(bookTableModel);
        
        // Tabel buku ditampung dalam JScrollPane
        JScrollPane tableScrollPane = new JScrollPane(bookTable);

        submitButton.addActionListener(e -> {
            String judul = titleField.getText();
            String deskripsi = descriptionArea.getText();
            String kategori = fictionRadio.isSelected() ? "Fiksi" : nonFictionRadio.isSelected() ? "Non-Fiksi" : "";
            int tahunTerbit = (int) publicationYearSpinner.getValue();
            boolean status = availableCheckBox.isSelected();
            String genre = (String) genreComboBox.getSelectedItem();
            String penulis = authorField.getText();

            // Validasi input
            if (judul.isEmpty() || deskripsi.isEmpty() || kategori.isEmpty() || genre == null || penulis.isEmpty()) {
                JOptionPane.showMessageDialog(bookFrame, "Mohon lengkapi semua data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                bookTableModel.addRow(new Object[]{judul, deskripsi, kategori, tahunTerbit, status ? "Ya" : "Tidak", genre, penulis});
                // Reset form setelah submit
                titleField.setText("");
                descriptionArea.setText("");
                genreGroup.clearSelection();
                availableCheckBox.setSelected(false);
                genreComboBox.setSelectedIndex(0);
                publicationYearSpinner.setValue(2024);
                authorField.setText("");
            }
        });

        // Fungsi tombol Hapus
        deleteButton.addActionListener(e -> {
            int selectedRow = bookTable.getSelectedRow();
            if (selectedRow >= 0) {
                bookTableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(bookFrame, "Pilih baris yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Mengatur tata letak tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(deleteButton);

        // Mengatur tata letak
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(buttonPanel, BorderLayout.NORTH);
        southPanel.add(tableScrollPane, BorderLayout.CENTER);

        bookFrame.add(inputScrollPane, BorderLayout.CENTER);
        bookFrame.add(southPanel, BorderLayout.SOUTH);

        bookFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LibraryManagementApp::new);
    }
}
