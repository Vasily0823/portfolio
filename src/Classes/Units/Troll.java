package Classes.Units;

import Classes.Infantry;
import Classes.MordorUnit;

public class Troll extends AbstractUnit implements MordorUnit, Infantry {

    public Troll(String name) {
        super(name, 11, 15);
    }

}
