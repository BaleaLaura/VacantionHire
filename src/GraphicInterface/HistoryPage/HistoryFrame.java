package GraphicInterface.HistoryPage;

import GraphicInterface.Frame;
import GraphicInterface.FirstPage.FirstFrame;
import GraphicInterface.HistoryPage.HistoryReturnReserve.HistoryReservReturn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryFrame implements Frame {

    @Override
    public void createGui() {

        JFrame frame=new JFrame();
        frame.setTitle("History");
        frame.setLocation(200,200);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        JButton back = new JButton("Back");
        back.setBounds(10, 10,70,20);
        frame.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstFrame back=new FirstFrame();
                back.createGui();
                frame.dispose();

            }
        });

        JButton returns = new JButton("Return");
        returns.setBounds(40, 100, 400, 60);
        frame.add(returns);
        returns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HistoryReservReturn historyReturn=new HistoryReservReturn("ReturnCars.txt", "History Return Cars");
                historyReturn.createGui();
                frame.dispose();
            }
        });

        JButton reserve = new JButton("Reserve");
        reserve.setBounds(40, 200, 400, 60);
        frame.add(reserve);
        reserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HistoryReservReturn historyReserve=new HistoryReservReturn("ReservationCars.txt","History Reserve Cars");
                historyReserve.createGui();
                frame.dispose();
            }
        });


    }
}
