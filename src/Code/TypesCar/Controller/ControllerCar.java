package Code.TypesCar.Controller;

import Code.TypesCar.Car;
import Code.TypesCar.Minivan;
import Code.TypesCar.Sedan;
import Code.TypesCar.Truck;

public class ControllerCar {
    public static Car createCar(String type)
    {
        switch (type)
        {
            case "Minivan":
                return new Minivan();
            case "Sedan":
                return new Sedan();
            case "Truck":
                return new Truck();
            default:
                System.out.println(type + " not recognised");
                return null;
        }
    }
}
