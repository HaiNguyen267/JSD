package tut8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddContactWindow {
    private JTextField name;
    private JTextField phoneNumber;
    private JTable jtable;
    public AddContactWindow(JTable jTable) {
        this.jtable = jTable;
        JFrame frame = new JFrame("Add Contact");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Name");
        name = new JTextField();
        JLabel phoneNumberLabel = new JLabel("Phone Number");
        phoneNumber = new JTextField();

        // i want the label name and the input are on the same line
        // so i add them to a panel
        panel.add(nameLabel);
        panel.add(name);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumber);

        JButton add = new JButton("Add");
        add.addActionListener(e -> {
            DefaultTableModel model = (DefaultTableModel) jtable.getModel();
            String nameString = name.getText();
            String phoneNumberString  = phoneNumber.getText();
            model.addRow(new String[]{nameString, phoneNumberString});

            // close this window
            frame.dispose();
        });

        panel.add(add);

        frame.add(panel);
        frame.setVisible(true);
    }


}
