package com.sahland;

import Util.ArrayUtils;
import Util.JTableUtils;
import Util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class MainFrame {
    private JButton buttonLoadTableInput1;
    private JButton buttonEx1;
    private JTable tableInput1;
    private JTable tableOutput1;
    private JPanel MainFrame;
    private JTable tableInput2;
    private JTable tableOutput2;
    private JButton buttonLoadTableInput2;
    private JButton buttonEx2;

    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;

    public MainFrame() {
        JFrame jfrm = new JFrame();

        jfrm.setTitle("Task_3");
        jfrm.setContentPane(MainFrame);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.pack();

        JTableUtils.initJTableForArray(tableInput1, 100, true, true, false, false);
        JTableUtils.initJTableForArray(tableInput2, 100, true, true, false, false);
        JTableUtils.initJTableForArray(tableOutput1, 100, true, true, false, false);
        JTableUtils.initJTableForArray(tableOutput2, 100, true, true, false, false);

        tableInput1.setRowHeight(25);
        tableInput2.setRowHeight(25);
        tableOutput1.setRowHeight(25);
        tableOutput2.setRowHeight(25);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        menuBarMain = new JMenuBar();
        jfrm.setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        jfrm.pack();
        jfrm.setVisible(true);

        buttonLoadTableInput1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(MainFrame) == JFileChooser.APPROVE_OPTION) {
                        int[] dataArr = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(tableInput1, dataArr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }

            }
        });

        buttonLoadTableInput2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    if (fileChooserOpen.showOpenDialog(MainFrame) == JFileChooser.APPROVE_OPTION) {
                        int[] dataArr = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(tableInput2, dataArr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }

            }
        });


        buttonEx1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int[] inputArr = JTableUtils.readIntArrayFromJTable(tableInput1);

                    Queue<Integer> x = new ArrayDeque<>();
                    Queue<Integer> result;

                    for (int i = 0; i < inputArr.length; i++) {
                        x.add(inputArr[i]);
                    }

                    System.out.println("Очередь чисел до изменений: ");
                    System.out.println(x.toString());

                    System.out.println("Очередь чисел после изменений: ");
                    result = Main.newQueue(x);
                    System.out.println(result.toString());

                    int[] outArr = new int[inputArr.length];

                    for (int i = 0; i < outArr.length; i++) {
                        outArr[i] = result.poll();
                    }

                    JTableUtils.writeArrayToJTable(tableOutput1, outArr);

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

            }
        });


        buttonEx2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int[] inputArr = JTableUtils.readIntArrayFromJTable(tableInput1);

                    MyQueue<Integer> y = new MyQueue<>();
                    MyQueue<Integer> resultSecond;

                    for (int i = 0; i < inputArr.length; i++) {
                        y.add(inputArr[i]);
                    }

                    System.out.println("Массив чисел до изменений: ");
                    for (int i = 0; i < y.size(); i++) {
                        System.out.print(y.get(i) + " ");
                    }
                    System.out.println();

                    System.out.println("Массив чисел после изменений: ");
                    resultSecond = MainCustom.newQueue(y);

                    int[] outArr = new int[inputArr.length];

                    for (int i = 0; i < y.size(); i++) {
                        System.out.print(resultSecond.get(i) + " ");
                    }

                    for (int i = 0; i < outArr.length; i++) {
                        outArr[i] = resultSecond.get(i);
                    }

                    JTableUtils.writeArrayToJTable(tableOutput2, outArr);

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
