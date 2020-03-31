package start;

import contoller.StartWindowController;

import javax.swing.*;

public class ApplicationStart {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, UnsupportedLookAndFeelException {

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        new StartWindowController();
    }
}
