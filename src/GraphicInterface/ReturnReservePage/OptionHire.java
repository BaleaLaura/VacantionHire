package GraphicInterface.ReturnReservePage;

import GraphicInterface.FirstPage.FirstFrame;
import GraphicInterface.Frame;
import GraphicInterface.ReturnReservePage.ControllerReturnReserve.Controller;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionHire implements Frame {

    private String mTypeOp;

    public OptionHire(String type)
    {
        this.mTypeOp = type;
    }

    @Override
    public void createGui() {
        JFrame frame = new JFrame();
        frame.setTitle(mTypeOp);
        frame.setSize(500, 500);
        frame.setLocation(200, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        JButton back = new JButton("Back");
        back.setBounds(10, 10, 70, 20);
        frame.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstFrame firstFrame = new FirstFrame();
                firstFrame.createGui();
                frame.dispose();

            }
        });

        JButton cars = new JButton("Cars");
        cars.setBounds(40, 100, 400, 60);
        frame.add(cars);

        cars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.createOption(mTypeOp);
                frame.dispose();
            }
        });
    }

}

