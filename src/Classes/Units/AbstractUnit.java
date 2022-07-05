package Classes.Units;

import Classes.Unit;

public abstract class AbstractUnit implements Unit {

    private int power;
    private String name;


    public AbstractUnit(String name, int minPower, int maxPower) {
        this.name = setName(name);
        this.power=createPower(minPower, maxPower);
    }

    public boolean isAlive(){
        return this.power > 0;
    }

    public <T extends AbstractUnit> void strike(T unit){
        if(this.isAlive()&&unit.isAlive()){
            unit.setPower(unit.getPower()- this.getPower());
            if(unit.getPower()<0) unit.setPower(0);
        }
    }



    protected int createPower(int a, int b){
         return this.power=a + (int)(Math.random() * ((b - a) + 1));
    }


    public String getName() {
        return name;
    }

    public String setName(String name) {
        if(name == null|| name.equals("")) return super.toString().substring(super.toString().indexOf('@'));
        else {
            this.name = name;
            return name;
        }
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" "+
                this.name+" has power "+this.power;
    }
}
