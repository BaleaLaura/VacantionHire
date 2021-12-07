package GraphicInterface.ReturnReservePage.CarReturnReserve.CarReservePage;

import Code.HistoryApp.TypeReturnReservation.CarReserveReturn;
import Code.TypesCar.Car;

import Code.TypesCar.Controller.ControllerCar;
import GraphicInterface.Frame;
import GraphicInterface.HistoryPage.HistoryFrame;
import GraphicInterface.ReturnReservePage.CarReturnReserve.ReturnReserveCars;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarsReserved implements Frame {
    private String mType;

    public CarsReserved(String type)
    {
        this.mType = type;
    }

    @Override
    public void createGui() {
        JFrame frame = new JFrame();
        frame.setTitle("Reserved " + mType);
        frame.setSize(500, 500);
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);


        JButton back = new JButton("Back");
        back.setBounds(10, 10,70,20);
        frame.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReturnReserveCars carReserveFrame=new ReturnReserveCars(mType);
                carReserveFrame.createGui();
                frame.dispose();
            }
        });
        JButton history = new JButton("History");
        history.setBounds(380, 10, 90, 20);
        frame.add(history);
        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HistoryFrame historyFrame=new HistoryFrame();
                historyFrame.createGui();
                frame.dispose();
            }
        });

        JLabel request = new JLabel("Complete Personal Data: ");
        request.setBounds(40, 50, 200, 30);
        frame.add(request);


        JLabel name = new JLabel("Name: ");
        name.setBounds(50, 90, 200, 30);
        JTextField field = new JTextField();
        field.setBounds(50, 120, 200, 30);
        frame.add(name);
        frame.add(field);

        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(50, 150, 200, 30);
        JTextField field2 = new JTextField();
        field2.setBounds(50, 180, 200, 30);
        frame.add(phone);
        frame.add(field2);


        JButton b = new JButton("Submit");
        b.setBounds(200, 400, 100, 30);
        frame.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name=field.getText();
                String phone=field2.getText();

                Car car = ControllerCar.createCar(mType);
                assert car != null;
                //Assert the app, most likely the name was typed wrong.

                CarReserveReturn carReserveReturn=new CarReserveReturn(car);
                String formatReserved ="Client: "+name+", Phone: "+phone+", Type Car: "+car.getTypeCar();

                if (name.length()<5) {
                    JOptionPane.showMessageDialog(frame,
                            "Complete Name!");
                } else if (phone.length()!=10) {
                    JOptionPane.showMessageDialog(frame,
                            "Complete Phone!");
                } else {
                    carReserveReturn.addLine(formatReserved,"ReservationCars.txt");
                    JOptionPane.showMessageDialog(frame,
                            "Reserved!");
                }
                field.setText("");
                field2.setText("");

            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }


}
