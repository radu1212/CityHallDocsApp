/*
 * Created by JFormDesigner on Sat Mar 21 10:54:14 EET 2020
 */

package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class AdminMainPage extends JFrame {
    public AdminMainPage() {
        String column_names[]= {"Document requested", "Date/time of request", "Status", "Address*"};
        DefaultTableModel table_model = new DefaultTableModel(column_names,0);
        table1=new JTable(table_model);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();
        scrollPane2 = new JScrollPane();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        buttonBar = new JPanel();
        label2 = new JLabel();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Administrator");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //---- label1 ----
                label1.setText("List of all users:");
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
                contentPanel.add(label1);
                label1.setBounds(60, 10, 125, 30);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(list1);
                }
                contentPanel.add(scrollPane1);
                scrollPane1.setBounds(30, 50, 155, 260);

                //---- button1 ----
                button1.setText("Delete user");
                contentPanel.add(button1);
                button1.setBounds(55, 320, 105, 30);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(table1);
                }
                contentPanel.add(scrollPane2);
                scrollPane2.setBounds(215, 50, 705, 260);

                //---- button2 ----
                button2.setText("Approve request");
                contentPanel.add(button2);
                button2.setBounds(220, 320, 140, 30);

                //---- button3 ----
                button3.setText("Decline request");
                contentPanel.add(button3);
                button3.setBounds(370, 320, 140, 30);

                //---- button4 ----
                button4.setText("Add new documents");
                contentPanel.add(button4);
                button4.setBounds(555, 320, 170, 30);

                //---- button5 ----
                button5.setText("Remove documents");
                contentPanel.add(button5);
                button5.setBounds(740, 320, 170, 30);

                //---- button6 ----
                button6.setText("View selected users requests");
                contentPanel.add(button6);
                button6.setBounds(195, 10, 225, 30);

                //---- button7 ----
                button7.setText("Only pending");
                contentPanel.add(button7);
                button7.setBounds(430, 10, 150, 30);

                //---- button8 ----
                button8.setText("Sort by date ALL");
                contentPanel.add(button8);
                button8.setBounds(595, 10, 150, 30);

                //---- button9 ----
                button9.setText("Sort by date only pending");
                contentPanel.add(button9);
                button9.setBounds(755, 10, 185, 30);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- label2 ----
                label2.setText("Current time: ");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
                buttonBar.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Exit");
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(990, 500);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JPanel buttonBar;
    private JLabel label2;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public JList getList1() {
        return list1;
    }

    public void setList1(JList list1) {
        this.list1 = list1;
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

    public void addDeleteUserButtonActionListener(final ActionListener actionListener){
        button1.addActionListener(actionListener);
    }
    public void addApproveRequestButtonActionListener(final ActionListener actionListener){
        button2.addActionListener(actionListener);
    }
    public void addDeclineRequestButtonActionListener(final ActionListener actionListener){
        button3.addActionListener(actionListener);
    }
    public void addNewDocumentButtonActionListener(final ActionListener actionListener){
        button4.addActionListener(actionListener);
    }
    public void addDeleteDocumentButtonActionListener(final ActionListener actionListener){
        button5.addActionListener(actionListener);
    }
    public void addExitButtonActionListener(final ActionListener actionListener){
        cancelButton.addActionListener(actionListener);
    }
    public void addViewSelectedUsersRequestsButtonActionListener(final ActionListener actionListener){
        button6.addActionListener(actionListener);
    }
    public void addFilterPendingButtonActionListener(final ActionListener actionListener){
        button7.addActionListener(actionListener);
    }
    public void addSortByDateButtonActionListener(final ActionListener actionListener){
        button8.addActionListener(actionListener);
    }
    public void addSortByDateAndFilterButtonActionListener(final ActionListener actionListener){
        button9.addActionListener(actionListener);
    }

    public void yourAddRow(String str1, String str2, String str3,String str4){
        DefaultTableModel yourModel = (DefaultTableModel) table1.getModel();
        yourModel.insertRow(0, new Object[]{str1, str2, str3, str4});
    }


}
