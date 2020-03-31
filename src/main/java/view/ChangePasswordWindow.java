/*
 * Created by JFormDesigner on Thu Mar 19 11:23:48 EET 2020
 */

package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class ChangePasswordWindow extends JFrame {
    public ChangePasswordWindow() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        passwordField2 = new JPasswordField();
        passwordField3 = new JPasswordField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Change password");
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
                label1.setText("Please enter your new password: ");
                contentPanel.add(label1);
                label1.setBounds(20, 10, label1.getPreferredSize().width, 25);

                //---- label2 ----
                label2.setText("Confirm your password: ");
                contentPanel.add(label2);
                label2.setBounds(20, 100, label2.getPreferredSize().width, 25);
                contentPanel.add(passwordField2);
                passwordField2.setBounds(20, 130, 170, 30);
                contentPanel.add(passwordField3);
                passwordField3.setBounds(20, 40, 170, 30);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("Confirm");
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(350, 290);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void addConfirmButtonActionListener(final ActionListener actionListener){
        okButton.addActionListener(actionListener);
    }

    public void addCancelButtonActionListener(final ActionListener actionListener){
        cancelButton.addActionListener(actionListener);
    }

    public String getPasswordField2() {
        return String.valueOf(passwordField2.getPassword());
    }

    public void setPasswordField2(JPasswordField passwordField2) {
        this.passwordField2 = passwordField2;
    }

    public String getPasswordField3() {
        return String.valueOf(passwordField3.getPassword());
    }

    public void setPasswordField3(JPasswordField passwordField3) {
        this.passwordField3 = passwordField3;
    }

    public void resetPasswords(){
        passwordField2.setText("");
        passwordField3.setText("");
    }

    public JPasswordField getPasswordField12() {
        return passwordField2;
    }

    public JPasswordField getPasswordField13() {
        return passwordField3;
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JPasswordField passwordField2;
    private JPasswordField passwordField3;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
