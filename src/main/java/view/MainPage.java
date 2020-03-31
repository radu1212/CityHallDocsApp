/*
 * Created by JFormDesigner on Wed Mar 18 22:09:51 EET 2020
 */

package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.ManyToOne;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author unknown
 */
public class MainPage extends JFrame {
    public MainPage() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        String column_names[]= {"Document requested", "Date/time of request", "Status", "Address*"};
        DefaultTableModel table_model = new DefaultTableModel(column_names,0);
        table1=new JTable(table_model);
        button1 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label2 = new JLabel();
        button2 = new JButton();
        button5 = new JButton();
        button6 = new JButton();

        //======== this ========
        setTitle("Online Requests Application");
        setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Welcome");
        contentPane.add(label1);
        label1.setBounds(480, 10, 205, 30);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 80, 695, 260);

        //---- button1 ----
        button1.setText("Create new request");
        contentPane.add(button1);
        button1.setBounds(25, 360, 150, 30);

        //---- button3 ----
        button3.setText("Update request");
        contentPane.add(button3);
        button3.setBounds(215, 360, 130, 30);

        //---- button4 ----
        button4.setText("Delete request");
        contentPane.add(button4);
        button4.setBounds(400, 360, 130, 30);

        //---- label2 ----
        label2.setText("Time:");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        contentPane.add(label2);
        label2.setBounds(45, 25, 290, 30);

        //---- button2 ----
        button2.setText("Update personal info");
        contentPane.add(button2);
        button2.setBounds(425, 40, 160, button2.getPreferredSize().height);

        //---- button5 ----
        button5.setText("Email document");
        contentPane.add(button5);
        button5.setBounds(580, 360, 130, 30);

        //---- button6 ----
        button6.setText("Logout");
        contentPane.add(button6);
        button6.setBounds(620, 40, 105, button6.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(750, 450));
        setSize(750, 450);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button3;
    private JButton button4;
    private JLabel label2;
    private JButton button2;
    private JButton button5;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private static void createAndShowGui() {

    }

    public JLabel getLabel1() {
        return label1;
    }

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }

    public void addCreateNewRequestButtonActionListener(final ActionListener actionListener){
        button1.addActionListener(actionListener);
    }

    public void addUpdatePersonalInoButtonActionListener(final ActionListener actionListener){
        button2.addActionListener(actionListener);
    }

    public void addLogoutButtonActionListener(final ActionListener actionListener){
        button6.addActionListener(actionListener);
    }

    public void addUpdateRequestButtonActionListener(final ActionListener actionListener){
        button3.addActionListener(actionListener);
    }

    public void addDeleteRequestButtonActionListener(final ActionListener actionListener){
        button4.addActionListener(actionListener);
    }

    public void addEmailDocumentButtonActionListener(final ActionListener actionListener){
        button5.addActionListener(actionListener);
    }

    public void yourAddRow(String str1, String str2, String str3){
        DefaultTableModel yourModel = (DefaultTableModel) table1.getModel();
        yourModel.insertRow(0, new Object[]{str1, str2, str3});
    }
    public void yourAddRow(String str1, String str2, String str3,String str4){
        DefaultTableModel yourModel = (DefaultTableModel) table1.getModel();
        yourModel.insertRow(0, new Object[]{str1, str2, str3, str4});
    }
}
