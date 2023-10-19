package tut9;

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


        JMenuBar menuBar = initMenuBar();
        gui.setJMenuBar(menuBar);

        // add a label with text "Phone Book Application" centered in yellow background to the top of the jframe
        JLabel label = initLabel();
        gui.add(label, BorderLayout.NORTH);

        JPanel bottom = initTablePanel();

        gui.add(bottom, BorderLayout.SOUTH);
        gui.setVisible(true);
    }

    private static JLabel initLabel() {
        JLabel label = new JLabel("Phone Book Application");
        label.setHorizontalAlignment(JLabel.CENTER);
        // set font size to 30px
        label.setFont(new Font("Verdana", Font.BOLD, 20));
        label.setOpaque(true);
        label.setBackground(Color.YELLOW);
        return label;
    }

    private JPanel initTablePanel() {
        initTable();

        JScrollPane tableScrollPane = new JScrollPane();
        tableScrollPane.setViewportView(jtable);
        gui.add(tableScrollPane, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        JButton addContact = new JButton("Add");
        JButton checkAll = new JButton("Check All");
        JButton delete = new JButton("Delete");

        addContact.addActionListener(this::actionAddContact);
        checkAll.addActionListener(this::actionCheckAll);
        delete.addActionListener(this::actionDelete);

        bottom.add(addContact);
        bottom.add(checkAll);
        bottom.add(delete);
        return bottom;
    }



    private void initTable() {
        Object[][] data = new Object[][]{
                {"Nguyễn Hoàng Vỹ","0231525157", false},
                {"Nguyễn Mạnh Hải","0381723149", false},
                {"Nguyễn Quang Nam","0581251224", false},
                {"HO QUANG HIU","0851251172", false},
                {"Linh Tran","0501293210", false},
                {"Quân Đỗ","0128421065", false},

        };
        String[] headers  = new String[]{"Name","Phone Number", "Select"};


        Font font = new Font("Verdana", Font.PLAIN, 15);

        DefaultTableModel model = new DefaultTableModel(data, headers) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }

        };


        jtable = new JTable(model);
        jtable.setFont(font);
        JTableHeader tableHeader = jtable.getTableHeader();
        tableHeader.setFont(font);
    }

    private static JMenuBar initMenuBar() {
        // add the menu bar
        JMenuBar menuBar = new JMenuBar();
        // add menu to menu bar
        JMenu menu = new JMenu("File");
        // add a menu item to the menu
        JMenuItem menuItem = new JMenuItem("Exit");
        menuItem.addActionListener(e -> System.exit(0));
        menu.add(menuItem);
        menuBar.add(menu);
        return menuBar;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }


    private void actionAddContact(ActionEvent e) {
        AddContactWindow addContactWindow = new AddContactWindow(jtable);

    }

    private void actionDelete(ActionEvent actionEvent) {


        // count the number of selected rows
        int count = countSelectedRows();

        if (count == 0) {
            JOptionPane.showMessageDialog(gui, "Please select at least 1 row to delete");
            return;
        }

        String message = String.format("Are you sure you want to delete %d rows?", count);

        // show a confirm dialog to ask user if they want to delete the selected rows
        int result = JOptionPane.showConfirmDialog(gui, message, "Delete", JOptionPane.YES_NO_OPTION);
        // 0 == confirm
        if (result == 0) {
            DefaultTableModel model = (DefaultTableModel) jtable.getModel();

            for (int i = 0; i < model.getRowCount(); i++) {
                Boolean selected = (Boolean) model.getValueAt(i, 2);
                if (selected) {
                    model.removeRow(i);
                    i--;
                }
            }
        }


    }

    private int countSelectedRows() {
        int count = 0;
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            Boolean selected = (Boolean) model.getValueAt(i, 2);
            if (selected) {
                count++;
            }
        }
        return count;
    }

    private void actionCheckAll(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        boolean allAreChecked = true;
        // check there are any unchecked rows, check them
        for (int i = 0; i < model.getRowCount(); i++) {
            Boolean isChecked = (Boolean) model.getValueAt(i, 2);
            if (!isChecked) {
                model.setValueAt(true, i, 2);
                allAreChecked = false;
            }
        }

        // but if all rows are checked, uncheck all
        if (allAreChecked) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(false, i, 2);
            }
        }

    }
}
