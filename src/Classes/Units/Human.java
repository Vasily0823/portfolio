package Classes.Units;

import Classes.Cavalry;
import Classes.Infantry;
import Classes.MiddleEarthUnit;

public class Human extends AbstractUnit implements MiddleEarthUnit, Infantry{
    public Human(String name) {
        super(name, 7, 8);
    }
}
