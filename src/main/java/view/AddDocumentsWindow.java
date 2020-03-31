/*
 * Created by JFormDesigner on Sat Mar 21 12:52:52 EET 2020
 */

package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class AddDocumentsWindow extends JFrame {
    public AddDocumentsWindow() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Add document");
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
                label1.setText("Document title:");
                contentPanel.add(label1);
                label1.setBounds(25, 15, 190, 20);
                contentPanel.add(textField1);
                textField1.setBounds(20, 40, 185, textField1.getPreferredSize().height);

                //---- label2 ----
                label2.setText("Does the new document require an address?");
                contentPanel.add(label2);
                label2.setBounds(25, 85, 260, 30);

                //---- checkBox1 ----
                checkBox1.setText("Yes");
                contentPanel.add(checkBox1);
                checkBox1.setBounds(30, 120, 80, checkBox1.getPreferredSize().height);

                //---- checkBox2 ----
                checkBox2.setText("No");
                contentPanel.add(checkBox2);
                checkBox2.setBounds(new Rectangle(new Point(30, 150), checkBox2.getPreferredSize()));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("Add");
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
        setSize(400, 300);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void addConfirmButtonActionListener(final ActionListener actionListener){
        okButton.addActionListener(actionListener);
    }

    public void addCancelButtonActionListener(final ActionListener actionListener){
        cancelButton.addActionListener(actionListener);
    }

    public String getTextField1() {
        return textField1.getText();
    }

    public JCheckBox getCheckBox1() {
        return checkBox1;
    }

    public JCheckBox getCheckBox2() {
        return checkBox2;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
