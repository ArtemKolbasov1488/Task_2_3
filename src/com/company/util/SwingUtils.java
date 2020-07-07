package com.company.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;


/**
 * Набор функций для работы с оконными приложениями с ипользованием Swing
 * @author Дмитрий Соломатин (кафедра ПиИТ ФКН ВГУ)
 */
public class SwingUtils {

    public static void showErrorMessageBox(String message, String title, Throwable ex) {
        StringBuilder sb = new StringBuilder(ex.toString());
        if (message != null) {
            sb.append(message);
        }
        if (ex != null) {
            sb.append("\n");
            for (StackTraceElement ste : ex.getStackTrace()) {
                sb.append("\n\tat ");
                sb.append(ste);
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString(), title, JOptionPane.ERROR_MESSAGE);
    }

    public static void showErrorMessageBox(String message, Throwable ex) {
        showErrorMessageBox(message, "Ошибка", ex);
    }

    public static void showErrorMessageBox(Throwable ex) {
        showErrorMessageBox(null, ex);
    }
}