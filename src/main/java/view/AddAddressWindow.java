/*
 * Created by JFormDesigner on Wed Mar 18 18:41:21 EET 2020
 */

package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class AddAddressWindow extends JFrame {
    public AddAddressWindow( String name) {
        initComponents(name);
        addCountysToComboBox();

    }

    private void initComponents(String name) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        textField4 = new JTextField();
        label6 = new JLabel();
        comboBox1 = new JComboBox();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
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
                label1.setText(name);
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 1f));
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                contentPanel.add(label1);
                label1.setBounds(-10, 10, 395, 30);
                contentPanel.add(textField1);
                textField1.setBounds(85, 60, 255, 25);

                //---- label2 ----
                label2.setText("Street:");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
                contentPanel.add(label2);
                label2.setBounds(20, 60, 50, label2.getPreferredSize().height);

                //---- label3 ----
                label3.setText("Number:");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
                contentPanel.add(label3);
                label3.setBounds(20, 95, 60, label3.getPreferredSize().height);
                contentPanel.add(textField2);
                textField2.setBounds(85, 95, 65, 25);

                //---- label4 ----
                label4.setText("Appartment:");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));
                contentPanel.add(label4);
                label4.setBounds(180, 95, 95, 20);
                contentPanel.add(textField3);
                textField3.setBounds(275, 95, 65, 25);

                //---- label5 ----
                label5.setText("City:");
                label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));
                contentPanel.add(label5);
                label5.setBounds(20, 130, 45, label5.getPreferredSize().height);
                contentPanel.add(textField4);
                textField4.setBounds(85, 130, 255, 25);

                //---- label6 ----
                label6.setText("County:");
                label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 2f));
                contentPanel.add(label6);
                label6.setBounds(20, 165, 55, 20);
                contentPanel.add(comboBox1);
                comboBox1.setBounds(85, 165, 120, 25);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("Submit address");
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
        setSize(410, 330);
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
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JTextField textField4;
    private JLabel label6;
    private JComboBox comboBox1;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void addOkButtonActionListener(final ActionListener actionListener){
        okButton.addActionListener(actionListener);
    }

    public void addCancelButtonActionListener(final ActionListener actionListener){
        cancelButton.addActionListener(actionListener);
    }

    public void addCountysToComboBox(){
        comboBox1.addItem("Alba");
        comboBox1.addItem("Arad");
        comboBox1.addItem("Arges");
        comboBox1.addItem("Bacau");
        comboBox1.addItem("Bihor");
        comboBox1.addItem("Bistrita-Nasaud");
        comboBox1.addItem("Botosani");
        comboBox1.addItem("Brasov");
        comboBox1.addItem("Braila");
        comboBox1.addItem("Bucuresti");
        comboBox1.addItem("Buzau");
        comboBox1.addItem("Caras-Severin");
        comboBox1.addItem("Calarasi");
        comboBox1.addItem("Cluj");
        comboBox1.addItem("Constanta");
        comboBox1.addItem("Covasna");
        comboBox1.addItem("Dambovita");
        comboBox1.addItem("Dolj");
        comboBox1.addItem("Galati");
        comboBox1.addItem("Giurgiu");
        comboBox1.addItem("Gorj");
        comboBox1.addItem("Harghita");
        comboBox1.addItem("Hunedoara");
        comboBox1.addItem("Ialomita");
        comboBox1.addItem("Iasi");
        comboBox1.addItem("Ilfov");
        comboBox1.addItem("Maramures");
        comboBox1.addItem("Mehedinti");
        comboBox1.addItem("Mures");
        comboBox1.addItem("Neamt");
        comboBox1.addItem("Olt");
        comboBox1.addItem("Prahova");
        comboBox1.addItem("Satu-Mare");
        comboBox1.addItem("Salaj");
        comboBox1.addItem("Sibiu");
        comboBox1.addItem("Suceava");
        comboBox1.addItem("Teleorman");
        comboBox1.addItem("Timis");
        comboBox1.addItem("Tulcea");
        comboBox1.addItem("Vaslui");
        comboBox1.addItem("Valcea");
        comboBox1.addItem("Vrancea");

    }

    public String getTextField1() {
        return textField1.getText();
    }

    public String getTextField2() {
        return textField2.getText();
    }

    public String getTextField3() {
        return textField3.getText();
    }

    public String getTextField4() {
        return textField4.getText();
    }

    public String getComboBox1() {
        return Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
    }


}
