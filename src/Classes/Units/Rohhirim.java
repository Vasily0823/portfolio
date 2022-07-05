package Classes.Units;

import Classes.Cavalry;
import Classes.MiddleEarthUnit;

public class Rohhirim extends AbstractCavalryUnit implements MiddleEarthUnit, Cavalry {

    public Rohhirim(String name) {
        super(name, 7, 8);
        this.horse=new Horse();
    }

}
