package Classes.Units;

import Classes.Infantry;
import Classes.MordorUnit;

public class Orc extends AbstractUnit implements MordorUnit, Infantry {

    public Orc(String name) {
        super(name, 8, 10);
    }


}
