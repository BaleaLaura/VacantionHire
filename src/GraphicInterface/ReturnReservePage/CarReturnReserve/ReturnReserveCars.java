package GraphicInterface.ReturnReservePage.CarReturnReserve;

import GraphicInterface.Frame;
import GraphicInterface.ReturnReservePage.OptionHire;
import GraphicInterface.ReturnReservePage.CarReturnReserve.CarReservePage.CarsReserved;
import GraphicInterface.ReturnReservePage.CarReturnReserve.CarReturnPage.CarsReturn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnReserveCars implements Frame {

    private String mType;

    public ReturnReserveCars(String type)
    {
        this.mType = type;
    }

    @Override
    public void createGui() {

        JFrame frame=new JFrame();
        frame.setTitle("Cars");
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
                OptionHire frame3=new OptionHire("Reserve");
                frame3.createGui();
                frame.dispose();

            }
        });

        JButton truck = new JButton("Truck");
        truck.setBounds(40, 100, 400, 60);
        frame.add(truck);
        truck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mType.equals("Return")){
                    CarsReturn carsReturn=new CarsReturn("Truck");
                    carsReturn.createGui();
                    frame.dispose();
                }else {
                    CarsReserved carsReserved = new CarsReserved("Truck");
                    carsReserved.createGui();
                    frame.dispose();
                }

            }
        });

        JButton minivan = new JButton("Minivan");
        minivan.setBounds(40, 200, 400, 60);
        frame.add(minivan);
        minivan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mType.equals("Return")){
                    CarsReturn carsReturn=new CarsReturn("Minivan");
                    carsReturn.createGui();
                    frame.dispose();
                }else {
                    CarsReserved carsReserved = new CarsReserved("Minivan");
                    carsReserved.createGui();
                    frame.dispose();
                }
            }
        });

        JButton sedan = new JButton("Sedan");
        sedan.setBounds(40, 300, 400, 60);
        frame.add(sedan);
        sedan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mType.equals("Return")){
                    CarsReturn carsReturn=new CarsReturn("Sedan");
                    carsReturn.createGui();
                    frame.dispose();
                }else {
                    CarsReserved carsReserved = new CarsReserved("Sedan");
                    carsReserved.createGui();
                    frame.dispose();
                }
            }
        });
    }
}


