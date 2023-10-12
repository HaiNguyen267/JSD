package tut8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends WindowAdapter implements ActionListener {

    private JFrame gui;
    private JTable jtable;
    public MainWindow() {
        createAndShowUI();
    }


    private void createAndShowUI() {
        gui = new JFrame("Phone Book");
        gui.setSize(360, 360);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
        gui.addWindowListener(this);

        String[][] data = new String[][]{
                {"Nguyễn Hoàng Vỹ","0231525125"},
                {"Nguyễn Mạnh Hải","0381723145"}
        };
        String[] headers  = new String[]{"Name","Phone Number"};


        Font font = new Font("Verdana", Font.PLAIN, 15);

        DefaultTableModel model = new DefaultTableModel(data, headers);
        jtable = new JTable(model);
        // set font for table content
        jtable.setFont(font);
        // set font for table header
        JTableHeader tableHeader = jtable.getTableHeader();
        tableHeader.setFont(font);

        JScrollPane tableScrollPane = new JScrollPane();
        tableScrollPane.setViewportView(jtable);
        gui.add(tableScrollPane, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        JButton addContact = new JButton("Add Contact");

        addContact.addActionListener(this);
        bottom.add(addContact);

        gui.add(bottom, BorderLayout.SOUTH);
        gui.setVisible(true);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // add row to table

        // please create variable for the new row here
        // and pass it to the constructor of AddContactWindow

        AddContactWindow addContactWindow = new AddContactWindow(jtable);
    }
}
