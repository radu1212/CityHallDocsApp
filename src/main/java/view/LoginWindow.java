/*
 * Created by JFormDesigner on Tue Mar 17 17:05:47 EET 2020
 */

package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class LoginWindow extends JFrame {
    public LoginWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        passwordField1.setEchoChar('*');
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane      = new JPanel();
        contentPanel    = new JPanel();
        label1          = new JLabel();
        textField1      = new JTextField();
        label2          = new JLabel();
        passwordField1  = new JPasswordField();
        button1         = new JButton();
        button2         = new JButton();
        okButton        = new JButton();
        cancelButton    = new JButton();

        //======== this ========
        setTitle("Login");
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
                label1.setText("Username:");
                contentPanel.add(label1);
                label1.setBounds(30, 5, 165, label1.getPreferredSize().height);
                contentPanel.add(textField1);
                textField1.setBounds(30, 30, 165, 25);

                //---- label2 ----
                label2.setText("Password:");
                contentPanel.add(label2);
                label2.setBounds(30, 65, 165, label2.getPreferredSize().height);
                contentPanel.add(passwordField1);
                passwordField1.setBounds(30, 85, 165, 25);

                //---- button1 ----
                button1.setText("Show");
                contentPanel.add(button1);
                button1.setBounds(210, 85, 70, 25);

                //---- button2 ----
                button2.setText("Password forgotten?");
                contentPanel.add(button2);
                button2.setBounds(30, 125, 130, 25);

                //---- okButton ----
                okButton.setText("Login");
                contentPanel.add(okButton);
                okButton.setBounds(195, 185, 81, okButton.getPreferredSize().height);

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                contentPanel.add(cancelButton);
                cancelButton.setBounds(285, 185, 80, cancelButton.getPreferredSize().height);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(400, 260);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public String getTextField1() {
        return textField1.getText();
    }

    public String getPasswordField1() {
        return String.valueOf(passwordField1.getPassword());
    }

    public JPasswordField getPasswordField1Obj() {
        return passwordField1;
    }

    public void addOkButtonActionListener(final ActionListener actionListener){
        okButton.addActionListener(actionListener);
    }

    public void addCancelButtonActionListener(final ActionListener actionListener){
        cancelButton.addActionListener(actionListener);
    }

    public void addPasswordForgottenButtonActionListener(final ActionListener actionListener){
        button2.addActionListener(actionListener);
    }

    public void resetPassword(){
        passwordField1.setText("");
    }

    public void resetUsername(){
        textField1.setText("");
    }

    public void addDisplayButtonActionListener(final MouseAdapter mouseAdapter){
        button1.addMouseListener(mouseAdapter);
    }

}
