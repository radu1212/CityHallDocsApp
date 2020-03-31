/*
 * Created by JFormDesigner on Thu Mar 12 20:46:34 EET 2020
 */

package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class RegisterWindow extends JFrame {
    public RegisterWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        passwordField1.setEchoChar('*');
        passwordField2.setEchoChar('*');
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        button1 = new JButton();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Registration Window");
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
                label1.setBounds(30, 0, 165, label1.getPreferredSize().height);
                contentPanel.add(textField1);
                textField1.setBounds(30, 20, 165, 25);

                //---- label2 ----
                label2.setText("Email:");
                contentPanel.add(label2);
                label2.setBounds(30, 50, 165, 16);
                contentPanel.add(textField2);
                textField2.setBounds(30, 70, 165, 25);

                //---- label3 ----
                label3.setText("Password:");
                contentPanel.add(label3);
                label3.setBounds(30, 100, 165, 16);

                //---- label4 ----
                label4.setText("Confirm password:");
                contentPanel.add(label4);
                label4.setBounds(30, 150, 165, 16);
                contentPanel.add(passwordField1);
                passwordField1.setBounds(30, 120, 165, 25);
                contentPanel.add(passwordField2);
                passwordField2.setBounds(30, 170, 165, 25);

                //---- button1 ----
                button1.setText("Show pass");
                contentPanel.add(button1);
                button1.setBounds(215, 145, 100, 30);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("Register");
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Back");
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(455, 325);
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
    private JTextField textField2;
    private JLabel label3;
    private JLabel label4;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton button1;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public String getTextField1() {
        return textField1.getText();
    }

    public String getTextField2() {
        return textField2.getText();
    }

    public String getPasswordField1() {
        return String.valueOf(passwordField1.getPassword());
    }

    public String getPasswordField2() {
        return String.valueOf(passwordField2.getPassword());
    }

    public JPasswordField getPasswordField1Obj() {
        return passwordField1;
    }

    public JPasswordField getPasswordField2Obj() {
        return passwordField2;
    }


    public void resetUsername() {
        textField1.setText("");
        resetPasswords();
    }

    public void resetEmail() {
        textField2.setText("");
        resetPasswords();
    }

    public void resetPasswords() {
        passwordField1.setText("");
        passwordField2.setText("");
    }

    public void addOkButtonActionListener(final ActionListener actionListener){
        okButton.addActionListener(actionListener);
    }

    public void addCancelButtonActionListener(final ActionListener actionListener){
        cancelButton.addActionListener(actionListener);
    }

    public void addDisplayButtonActionListener(final MouseAdapter mouseAdapter){
        button1.addMouseListener(mouseAdapter);
    }


    public static void main(String[] args) {
        new RegisterWindow().setVisible(true);
    }

}
