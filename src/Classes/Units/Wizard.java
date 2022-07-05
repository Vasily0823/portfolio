package Classes.Units;


import Classes.Cavalry;
import Classes.MiddleEarthUnit;

public class Wizard extends AbstractCavalryUnit implements MiddleEarthUnit, Cavalry {

    public Wizard(String name) {
        super(name, 20, 20);
        this.horse=new Horse();
    }



}
