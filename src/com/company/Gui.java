package com.company;

import com.company.util.ArrayUtils;
import com.company.util.JTableUtils;
import com.company.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


class GUI extends JFrame {
    private JButton addElementToBackButton;
    private JButton addElementToFrontButton;
    private JButton deleteElementButton;
    private JButton findLocaleExtremumButton;
    private JPanel panelMain;
    private JTable table1;
    private JTextField textField1;
    private JLabel extremumData;
    private JLabel extremumData2;
    private JButton loadButton;
    private JTextArea textArea1;

    private JFileChooser fileChooserSave;
    private JFileChooser fileChooserOpen;

    public GUI() {

        List list = new List();

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);
        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);

        addElementToBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                list.addBack((int) (0 + Math.random() * 15));
                list.toArray();
                com.company.util.JTableUtils.initJTableForArray(table1, 40, true, true, true, true);
                JTableUtils.writeArrayToJTable(table1, list.myArray);
            }
        });

        addElementToFrontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                list.addFront((int) (0 + Math.random() * 15));
                list.toArray();
                com.company.util.JTableUtils.initJTableForArray(table1, 40, true, true, true, true);
                JTableUtils.writeArrayToJTable(table1, list.myArray);
            }
        });

        deleteElementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                for (int i = 0; i < list.myArray.length; i++) {

                    if (list.myArray[i] == (int) (Double.parseDouble(textField1.getText()))) {
                        list.delEl((int) (Double.parseDouble(textField1.getText())));
                        list.toMinusArray();
                    }

                }

                com.company.util.JTableUtils.initJTableForArray(table1, 40, true, true, true, true);
                JTableUtils.writeArrayToJTable(table1, list.myArray);
            }
        });

        findLocaleExtremumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                extremumData2.setText(String.valueOf(list.findLocaleExtremum()));
                com.company.util.JTableUtils.initJTableForArray(table1, 40, true, true, true, true);
                JTableUtils.writeArrayToJTable(table1, list.myArray);
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    list.toArray();

                    if (list.myArray.length != 0)
                        for (int i = 0; i < list.myArray.length; i++) {
                            list.delEl(list.myArray[i]);
                        }

                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        list.myArray = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(table1, list.myArray);
                    }

                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }

                try {

                    for (int i = 0; i < list.myArray.length; i++) {
                        list.addBack(list.myArray[i]);
                        list.setSize();
                    }

                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new GUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}