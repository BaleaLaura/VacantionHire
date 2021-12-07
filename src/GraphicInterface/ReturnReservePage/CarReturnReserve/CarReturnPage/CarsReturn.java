package GraphicInterface.ReturnReservePage.CarReturnReserve.CarReturnPage;

import Code.HistoryApp.TypeReturnReservation.CarReserveReturn;
import Code.HistoryApp.ManagedFile;
import Code.TypesCar.Car;
import Code.TypesCar.Controller.ControllerCar;
import GraphicInterface.Frame;
import GraphicInterface.HistoryPage.HistoryFrame;
import GraphicInterface.ReturnReservePage.CarReturnReserve.ReturnReserveCars;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CarsReturn implements Frame {

    private String mType;

    public CarsReturn( String mType)
    {
        this.mType = mType;

    }

    @Override
    public void createGui() {
        JFrame frame = new JFrame();
        frame.setTitle("Return" + mType);
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
                ReturnReserveCars carReturnFrame=new ReturnReserveCars(mType);
                carReturnFrame.createGui();
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

        JLabel damage = new JLabel("Any Damage: ");
        damage.setBounds(50, 210, 200, 30);
        JTextField field3 = new JTextField();
        field3.setBounds(50, 240, 200, 30);
        frame.add(damage);
        frame.add(field3);

        JLabel gasoline = new JLabel("Gasoline(Yes/No): ");
        gasoline.setBounds(50, 270, 200, 30);
        JTextField field4 = new JTextField();
        field4.setBounds(50, 300, 200, 30);
        frame.add(gasoline);
        frame.add(field4);

       JButton b = new JButton("Submit");
        b.setBounds(200, 400, 100, 30);
        frame.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = field.getText();
                String phone = field2.getText();
                String damage = field3.getText();
                String gasoline = field4.getText();

                Car car = ControllerCar.createCar(mType);
                assert car != null;
                CarReserveReturn carReserveReturn=new CarReserveReturn(car);

                String formatReturn = "Client: " + "\n" + "    Name: " + name + "\n" + "    Phone: " + phone + "\n" + "    Type Car: " + car.getTypeCar() + "\n"
                        + "    Damage: " + damage + "\n" + "    Gasoline(YES/NO): " + gasoline;
                String formatReservation ="Client: "+name+", Phone: "+phone+", Type Car: "+car.getTypeCar();

                try {
                    boolean line= ManagedFile.findLine(formatReservation, "ReservationCars.txt");
                    if(line){

                        carReserveReturn.addLine(formatReturn, "ReturnCars.txt");
                        ManagedFile.deleteLine(formatReservation, "ReservationCars.txt", "Reservation.txt");

                        if (name.length()<5) {
                            JOptionPane.showMessageDialog(frame,
                                    "Complete Name!");
                        } else if (phone.length()!=10) {
                            JOptionPane.showMessageDialog(frame,
                                   "Complete Phone!");
                        }
                    else if (damage.isEmpty()) {
                            JOptionPane.showMessageDialog(frame,
                                    "Complete Damage!");
                        } else if (gasoline.isEmpty()) {
                            JOptionPane.showMessageDialog(frame,
                                    "Complete Gasoline!");
                        } else{
                            JOptionPane.showMessageDialog(frame,
                                    "Returned!");
                        }

                    }else{
                      JOptionPane.showMessageDialog(frame, "The car isn't reserved");
                    }
                    field.setText("");
                    field2.setText("");
                    field3.setText("");
                    field4.setText("");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }

        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

}

