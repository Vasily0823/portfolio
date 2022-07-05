package Classes.Units;

import Classes.Infantry;
import Classes.MordorUnit;

public class UrukHai extends Orc implements MordorUnit, Infantry {
    public UrukHai(String name) {
        super(name);
        this.setPower(createPower(10,12));
    }
}
