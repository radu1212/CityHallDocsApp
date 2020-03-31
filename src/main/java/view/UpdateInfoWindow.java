/*
 * Created by JFormDesigner on Thu Mar 19 01:15:11 EET 2020
 */

package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class UpdateInfoWindow extends JFrame {
    public UpdateInfoWindow() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Update personal info");
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
                label1.setText("Username: ");
                contentPanel.add(label1);
                label1.setBounds(20, 10, 70, 20);
                contentPanel.add(label2);
                label2.setBounds(95, 10, 190, 20);

                //---- label3 ----
                label3.setText("Email: ");
                contentPanel.add(label3);
                label3.setBounds(20, 35, 70, 20);
                contentPanel.add(label4);
                label4.setBounds(95, 35, 190, 20);

                //---- label5 ----
                label5.setText("Password:");
                contentPanel.add(label5);
                label5.setBounds(20, 60, 70, 20);
                contentPanel.add(label6);
                label6.setBounds(95, 60, 190, 20);

                //---- label7 ----
                label7.setText("Addresses: ");
                contentPanel.add(label7);
                label7.setBounds(20, 85, 70, 20);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(list1);
                }
                contentPanel.add(scrollPane1);
                scrollPane1.setBounds(100, 90, 325, 95);

                //---- button1 ----
                button1.setText("Update email");
                contentPanel.add(button1);
                button1.setBounds(290, 30, 140, 25);

                //---- button3 ----
                button3.setText("Change password");
                contentPanel.add(button3);
                button3.setBounds(290, 60, 140, 25);

                //---- button4 ----
                button4.setText("<html>Add<br />Address</html>");
                contentPanel.add(button4);
                button4.setBounds(10, 120, 75, 65);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- cancelButton ----
                cancelButton.setText("Done");
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(490, 310);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    private JButton button3;
    private JButton button4;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2.setText(label2);
    }

    public JLabel getLabel4() {
        return label4;
    }

    public void setLabel4(String label4) {
        this.label4.setText(label4);
    }

    public JLabel getLabel6() {
        return label6;
    }

    public void setLabel6(String label6) {
        this.label6.setText(label6);
    }

    public JList getList1() {
        return list1;
    }

    public void setList1(JList list1) {
        this.list1 = list1;
    }

    public void addUpdateEmailButtonActionListener(final ActionListener actionListener){
        button1.addActionListener(actionListener);
    }

    public void addChangePasswordButtonActionListener(final ActionListener actionListener){
        button3.addActionListener(actionListener);
    }

    public void addInsertNewAddressButtonActionListener(final ActionListener actionListener){
        button4.addActionListener(actionListener);
    }


    public void addCancelButtonActionListener(final ActionListener actionListener){
        cancelButton.addActionListener(actionListener);
    }



}
