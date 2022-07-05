package Classes.Units;

import Classes.Cavalry;
import Classes.Unit;

public abstract class AbstractCavalryUnit extends AbstractUnit implements Unit{
    Horse horse;
    Warg warg;

    public AbstractCavalryUnit(String name, int minPower, int maxPower) {
        super(name, minPower, maxPower);
    }


    public <T extends AbstractCavalryUnit> void strike(T unit){
        if(unit.horse!=null&&this.isAlive()&&unit.isAlive()) {
            if (unit.horse.getHorsePower() > 0) {
                unit.horse.setHorsePower(unit.horse.getHorsePower() - this.getPower());
                if (unit.horse.getHorsePower() < 0) unit.horse.setHorsePower(0);
            } else{
                unit.setPower(unit.getPower()- this.getPower());
                if(unit.getPower()<0) unit.setPower(0);
            }
        }
        else if(unit.warg!=null&&this.isAlive()&&unit.isAlive()) {
            if (unit.warg.getWargPower() > 0) {
                unit.warg.setWargPower(unit.warg.getWargPower() - this.getPower());
                if (unit.warg.getWargPower() < 0) unit.warg.setWargPower(0);
            } else {
                unit.setPower(unit.getPower()- this.getPower());
                if(unit.getPower()<0) unit.setPower(0);
            }
        }
    }



    public class Horse{
        private int horsePower;
        public Horse() {
            horsePower=4 + (int)(Math.random() * ((5 - 4) + 1));
        }

        public int getHorsePower() {
            return horsePower;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }
    }



    public class Warg{
        private int wargPower;
        public Warg() {
            wargPower=4 + (int)(Math.random() * ((7 - 4) + 1));
        }

        public int getWargPower() {
            return wargPower;
        }

        public void setWargPower(int wargPower) {
            this.wargPower = wargPower;
        }
    }
}
