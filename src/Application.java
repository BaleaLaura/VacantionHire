
import GraphicInterface.FirstPage.FirstFrame;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FirstFrame().createGui();
            }
        });





    }

}
