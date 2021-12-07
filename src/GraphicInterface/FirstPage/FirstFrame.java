package GraphicInterface.FirstPage;

import GraphicInterface.Frame;
import GraphicInterface.HistoryPage.HistoryFrame;
import GraphicInterface.ReturnReservePage.OptionHire;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


public class FirstFrame implements Frame {

    public void createGui() {

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLocation(200, 200);
        frame.setTitle("Vacantion Hire");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        JButton retur = new JButton("Return");
        retur.setBounds(40, 100, 400, 60);
        frame.add(retur);

        retur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OptionHire optionReturn =new OptionHire("Return");
                optionReturn.createGui();
                frame.dispose();
            }
        });

        JButton reserved = new JButton("Reserve");
        reserved.setBounds(40, 200, 400, 60);
        frame.add(reserved);
        reserved.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OptionHire optionReserve =new OptionHire("Reserve");
                optionReserve.createGui();
                frame.dispose();
            }
        });

        JButton history = new JButton("History");
        history.setBounds(40, 300, 400, 60);
        frame.add(history);
        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HistoryFrame historyFrame=new HistoryFrame();
                historyFrame.createGui();
                frame.dispose();
            }
        });

        JButton delete = new JButton("Clear history");
        delete.setBounds(20, 400, 150, 20);
        frame.add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new FileWriter("ReservationCars.txt", false).close();
                    new FileWriter("ReturnCars.txt", false).close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}



