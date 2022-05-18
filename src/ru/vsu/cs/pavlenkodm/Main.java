package ru.vsu.cs.pavlenkodm;


import ru.vsu.cs.pavlenkodm.util.SwingUtils;

import javax.swing.*;
import java.io.PrintStream;

import java.util.Locale;


public class Main {
    public static void main(String[] args) {

        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Times New Roman", 17);

        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }
}