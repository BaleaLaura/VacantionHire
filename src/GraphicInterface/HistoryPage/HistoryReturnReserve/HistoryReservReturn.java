package GraphicInterface.HistoryPage.HistoryReturnReserve;

import Code.HistoryApp.ReadHistory.AddHistoryToList;
import GraphicInterface.Frame;
import GraphicInterface.HistoryPage.HistoryFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryReservReturn implements Frame {

    private String path;
    private String name;

    public HistoryReservReturn(String path, String name) {
        this.path = path;
        this.name=name;
    }

    @Override
    public void createGui() {
        JFrame frame = new JFrame();
        frame.setTitle("History");
        frame.setLocation(200, 200);
        frame.setSize(600, 500);
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
                HistoryFrame historyFrame = new HistoryFrame();
                historyFrame.createGui();
                frame.dispose();
            }
        });

        JLabel title = new JLabel(name);
        title.setBounds(10, 30, 200, 30);
        frame.add(title);

        JPanel p = new JPanel();
        p.setBounds(0, 70, 400, 400);

        AddHistoryToList addHistoryToList = new AddHistoryToList();

        JList<String> list = new JList(addHistoryToList.readFile(path).toArray());
        list.setBounds(0, 70, 400, 400);
        p.add(list);
        frame.add(p);

    }
}


