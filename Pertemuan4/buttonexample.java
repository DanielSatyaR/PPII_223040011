package Pertemuan4;

import javax.swing.*;
import java.awt.event.*;

public class buttonexample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example"); // Perbaikan pada constructor JFrame
        JButton button = new JButton("Click Me"); // Perbaikan pada constructor JButton

        // Menambahkan ActionListener ke JButton
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!"); // Perbaikan pada println
            }
        });

        button.setBounds(50, 50, 150, 30); // Menghilangkan label parameter
        frame.add(button);
        frame.setSize(300, 200); // Menghilangkan label parameter
        frame.setLayout(null); // Menghilangkan label parameter
        frame.setVisible(true); // Menghilangkan label parameter
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
