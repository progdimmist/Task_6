package ru.vsu.cs.pavlenkodm;

import javax.swing.*;

import ru.vsu.cs.pavlenkodm.util.ArrayUtils;
import ru.vsu.cs.pavlenkodm.util.JTableUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;

public class FrameMain extends JFrame {

    private JPanel panelMain;
    private JButton buttonLoadInputFromFile;
    private JButton buttonRandomInput;
    private JButton buttonSaveInputInfoFile;
    private JButton buttonCreateNewList;
    private JButton buttonSaveOutputIntoFile;
    private JTable tableInput;
    private JTable tableOutput;
    private JButton buttonShiftLine;
    private JTextField numberN;

    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public FrameMain(){
        this.setTitle("Массивы");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput,45,false,true,false,true);
        JTableUtils.initJTableForArray(tableOutput,45,false,true,false,true);
        tableInput.setRowHeight(30);
        tableOutput.setRowHeight(30);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        buttonLoadInputFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[][] arr = ArrayUtils.readIntArray2FromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(tableInput, arr);
                    }
                } catch (Exception e) {
                    ru.vsu.cs.pavlenkodm.util.SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonRandomInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[][] matrix = ru.vsu.cs.pavlenkodm.util.ArrayUtils.createRandomIntMatrix(
                            tableInput.getRowCount(), tableInput.getColumnCount(), 10);
                    JTableUtils.writeArrayToJTable(tableInput, matrix);
                } catch (Exception e) {
                    ru.vsu.cs.pavlenkodm.util.SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonSaveInputInfoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[][] matrix = JTableUtils.readIntMatrixFromJTable(tableInput);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ru.vsu.cs.pavlenkodm.util.ArrayUtils.writeArrayToFile(file, matrix);
                    }
                } catch (Exception e) {
                    ru.vsu.cs.pavlenkodm.util.SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        buttonSaveOutputIntoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[][] matrix = JTableUtils.readIntMatrixFromJTable(tableOutput);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ru.vsu.cs.pavlenkodm.util.ArrayUtils.writeArrayToFile(file, matrix);
                    }
                } catch (Exception e) {
                    ru.vsu.cs.pavlenkodm.util.SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonCreateNewList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] matrix = JTableUtils.readIntArrayFromJTable(tableInput);

                    int[] arr;
                    arr=Task.sortMap(matrix);


                    JTableUtils.writeArrayToJTable(tableOutput, arr);
                } catch (Exception e) {
                    ru.vsu.cs.pavlenkodm.util.SwingUtils.showErrorMessageBox(e);
                }
            }
        });



    }
}

