package Classes.Units;

import Classes.Infantry;
import Classes.MordorUnit;

public class Goblin extends AbstractUnit implements MordorUnit, Infantry {
    public Goblin(String name) {
        super(name, 2, 5);
    }
}
