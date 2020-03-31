/*
 * Created by JFormDesigner on Tue Mar 17 17:22:12 EET 2020
 */

package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author unknown
 */
public class StartWindow extends JFrame {
    public StartWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Welcome on the Cluj-Napoca City-Hall website!");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
        contentPane.add(label1);
        label1.setBounds(15, 15, 345, 40);

        //---- button1 ----
        button1.setText("Login");
        contentPane.add(button1);
        button1.setBounds(40, 70, 115, 35);

        //---- button2 ----
        button2.setText("Register");
        contentPane.add(button2);
        button2.setBounds(230, 70, 115, 35);

        contentPane.setPreferredSize(new Dimension(385, 165));
        setSize(385, 165);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void addLoginButtonActionListener(final ActionListener actionListener){
        button1.addActionListener(actionListener);
    }

    public void addRegisterButtonActionListener(final ActionListener actionListener){
        button2.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        new StartWindow().setVisible(true);
    }
}
