package Classes;

import java.util.ArrayList;

public class Army <T extends Unit> {
    private ArrayList<Cavalry> cavalries=new ArrayList<>();
    private ArrayList<Infantry> infantries=new ArrayList<>();

    public void setCavalries(ArrayList<Cavalry> cavalries) {
        this.cavalries = cavalries;
    }

    public void setInfantries(ArrayList<Infantry> infantries) {
        this.infantries = infantries;
    }

    public ArrayList<Cavalry> getCavalries() {
        return cavalries;
    }

    public ArrayList<Infantry> getInfantries() {
        return infantries;
    }


    public ArrayList<Unit> getArmy(){
        ArrayList<Unit> army= new ArrayList<>();
        army.addAll(cavalries);
        army.addAll(infantries);
        return army;
    }


    public boolean recruit(T o){
        if(o instanceof Cavalry){
            cavalries.add((Cavalry) o);
            return true;
        } else if(o instanceof Infantry){
            infantries.add((Infantry) o);
            return true;
        } else
            return false;
    }


    public boolean release(T o){
        if(o instanceof Cavalry&&cavalries.size()!=0) {
            cavalries.remove((Cavalry) o);
            return true;
        }else if(o instanceof Infantry&&infantries.size()!=0){
            infantries.remove((Infantry) o);
            return true;
        } else
            return false;
    }


    public Unit getRandomUnit(){
        ArrayList<Unit> army= new ArrayList<>();
        army=getArmy();
        if(army.size()!=0) {
            int a = (int) (Math.random() * army.size());
            return army.get(a);
        } else return null;
    }


    public Unit getRandomUnit(T o){
        if(o instanceof Cavalry&&cavalries.size()!=0){
            return cavalries.get((int)(Math.random()*cavalries.size()));
        } else if(o instanceof Infantry&&infantries.size()!=0) {
            return infantries.get((int) (Math.random() * infantries.size()));
        }else return null;
        }


    public Cavalry getRandomCavalry(){
        return cavalries.get((int)(Math.random()*cavalries.size()));
    }

    public Infantry getRandomInfantry(){
        return infantries.get((int)(Math.random()*infantries.size()));
    }


    public void print(){
        System.out.println(toString());
        System.out.println("Classes.Army:\n");
        System.out.println("Classes.Cavalry\n");
        for(Cavalry cavalry:cavalries){
            System.out.println(cavalry.toString()+" \n");
        }
        System.out.println("Classes.Infantry\n");
        for(Infantry infantry:infantries){
            System.out.println(infantry.toString()+" \n");
        }
    }


}
