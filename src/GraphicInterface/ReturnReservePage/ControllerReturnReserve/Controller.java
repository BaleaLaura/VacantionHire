package GraphicInterface.ReturnReservePage.ControllerReturnReserve;

import GraphicInterface.Frame;
import GraphicInterface.ReturnReservePage.CarReturnReserve.ReturnReserveCars;

public class Controller {


    public static Frame createOption(String type) {


        switch (type) {

            case "Return":

                ReturnReserveCars carReturnFrame = new ReturnReserveCars("Return");
                carReturnFrame.createGui();
                break;

            case "Reserve":
                ReturnReserveCars carReserveFrame = new ReturnReserveCars("Reserve");
                carReserveFrame.createGui();
                break;

            default:
                break;

        }
        return null;
    }
}