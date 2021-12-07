package Code.HistoryApp.TypeReturnReservation;

import Code.HistoryApp.ReturnReservation;
import Code.TypesCar.Car;

import java.io.*;

/*
This method add the registration for returns and reservation
 */

public class CarReserveReturn implements ReturnReservation {
    Car car;

    public CarReserveReturn(Car car) {
        this.car = car;
    }

    @Override
    public void addLine(String format, String path) {
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(format);
            bw.newLine();
            bw.newLine();
            bw.close();
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
