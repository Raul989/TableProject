package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabel extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public Tabel() {
        setLayout(new BorderLayout());

        String[] columnNames = {"Nume", "Varsta", "Sex"};
        Object[][] data = {};
        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        JButton addButton = new JButton("adaugati");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("introduceti numele:");
                String age = JOptionPane.showInputDialog("introduceti varsta:");
                String gender = JOptionPane.showInputDialog("introduceti sexul:");
                model.addRow(new Object[]{name, age, gender});
            }
        });
        buttonPanel.add(addButton);

        JButton deleteButton = new JButton("stergeti");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "selectati randul care va fi sters.");
                }
            }
        });
        buttonPanel.add(deleteButton);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Tabel();
    }
}