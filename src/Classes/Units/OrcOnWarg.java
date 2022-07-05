package Classes.Units;

import Classes.Cavalry;
import Classes.MordorUnit;

public class OrcOnWarg extends AbstractCavalryUnit implements MordorUnit, Cavalry {
    public OrcOnWarg(String name) {
        super(name, 8, 10);
        this.warg=new Warg();
    }
}
