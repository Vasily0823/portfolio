package Classes.Units;

import Classes.Infantry;
import Classes.MiddleEarthUnit;

public class Elf extends  AbstractUnit implements MiddleEarthUnit, Infantry {

    public Elf(String name) {
        super(name, 4 , 7);
    }


}
