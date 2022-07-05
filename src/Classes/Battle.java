package Classes;

import Classes.Units.*;

import java.util.ArrayList;
import java.util.Collection;

public class Battle{
    private static final int size=10;
    private static int phase=0;
    private static Army<MordorUnit> armyOfMordor;
    private static Army<MiddleEarthUnit> armyOfMiddleEarth;



    public static void fight(){
        armyOfMordor= createMordorArmy();
        armyOfMiddleEarth=createMiddleEarthArmy();
        firstPhase();
        secondPhase();
        if(needThirdPhase()){
            thirdPhase();
        }
        printWinnerBattle();
    }

    public static void fight(Army<MordorUnit> armyOfMordorIn, Army<MiddleEarthUnit> armyOfMiddleEarthIn){
        armyOfMordor= armyOfMordorIn;
        armyOfMiddleEarth=armyOfMiddleEarthIn;
        firstPhase();
        secondPhase();
        if(needThirdPhase()){
            thirdPhase();
        }
        printWinnerBattle();
    }


    public static void firstPhase(){
        phase=phase+1;
        System.out.println("Phase "+phase +":");
        while (armyOfMordor.getCavalries().size()!=0&&armyOfMiddleEarth.getCavalries().size()!=0){
            AbstractCavalryUnit a=(AbstractCavalryUnit) armyOfMordor.getRandomCavalry();
            AbstractCavalryUnit b=(AbstractCavalryUnit) armyOfMiddleEarth.getRandomCavalry();
            if(Math.round(Math.random())==1) {
                duelCavalry(a, b);
            } else{
                duelCavalry(b, a);
            }
            testAlive(a, b);
         }

        if(armyOfMordor.getCavalries().size()!=0){
            System.out.println("Army of Mordor has won the 1 phase. The winners list:");
            printWinnerPhase(armyOfMordor.getCavalries());
        } else{
            System.out.println("Army of MiddleEarth has won the 1 phase. The winners list:");
            printWinnerPhase(armyOfMiddleEarth.getCavalries());
        }
        System.out.println("\n");
    }

    public static void secondPhase(){
        phase=phase+1;
        System.out.println("Phase "+phase +":");
        while (armyOfMordor.getInfantries().size()!=0&&armyOfMiddleEarth.getInfantries().size()!=0) {
            AbstractUnit a=(AbstractUnit) armyOfMordor.getRandomInfantry();
            AbstractUnit b=(AbstractUnit) armyOfMiddleEarth.getRandomInfantry();
            if (Math.round(Math.random()) == 1) {
                duelInfantry(a, b);
            } else {
                duelInfantry(b, a);
            }
            testAlive(a, b);
        }
        if(armyOfMordor.getInfantries().size()!=0){
            System.out.println("Army of Mordor has won the 2 phase. The winners list:");
            printWinnerPhase(armyOfMordor.getInfantries());
        } else{
            System.out.println("Army of MiddleEarth has won the 2 phase. The winners list:");
            printWinnerPhase(armyOfMiddleEarth.getInfantries());
        }
        System.out.println("\n");
    }

    public static void thirdPhase(){
        phase=phase+1;
        System.out.println("Phase "+phase +":");
        ArrayList<Cavalry> cavalries;
        ArrayList<Infantry> infantries;
        int typeArmy;

        if(armyOfMordor.getInfantries().size()!=0){
            infantries=armyOfMordor.getInfantries();
            cavalries=armyOfMiddleEarth.getCavalries();
            typeArmy=0;
        }else{
            infantries=armyOfMiddleEarth.getInfantries();
            cavalries=armyOfMordor.getCavalries();
            typeArmy=1;
        }


        while (cavalries.size()!=0&&infantries.size()!=0) {
            AbstractCavalryUnit a=(AbstractCavalryUnit) cavalries.get((int) (Math.random() * cavalries.size()));
            AbstractUnit b=(AbstractUnit) infantries.get((int) (Math.random() * infantries.size()));
            duelCavalryAndInfantry(a,b);
            if(!a.isAlive()) cavalries.remove(a);
            if(!b.isAlive()) infantries.remove(b);
        }
        if(typeArmy==0){
            armyOfMordor.setInfantries(infantries);
            armyOfMiddleEarth.setCavalries(cavalries);
        }else {
            armyOfMiddleEarth.setInfantries(infantries);
            armyOfMordor.setCavalries(cavalries);
        }
        System.out.println("\n");
    }



    public static void duelCavalry(AbstractCavalryUnit a, AbstractCavalryUnit b){
        System.out.println(a.toString()+" strikes "+b.toString()+" and ");
        a.strike(b);
        if(b.isAlive()){
            System.out.println("does not kill him");
            System.out.println(b.toString()+" strikes "+a.toString()+" and ");
            b.strike(a);
            if(a.isAlive())  System.out.println("does not kill him");
            else System.out.println("kills him");
        }
        else
            System.out.println("kills him");

    }



    public static  void duelInfantry(AbstractUnit a, AbstractUnit b){
        System.out.println(a.toString()+" strikes "+b.toString()+" and ");
        a.strike(b);
        if(b.isAlive()){
            System.out.println("does not kill him");
            System.out.println(b.toString()+" strikes "+a.toString()+" and ");
            b.strike(a);
            if(a.isAlive())  System.out.println("does not kill him");
            else System.out.println("kills him");
        }
        else
            System.out.println("kills him");
    }


    public static  void duelCavalryAndInfantry(AbstractCavalryUnit a, AbstractUnit b){
        System.out.println(a.toString()+" strikes "+b.toString()+" and ");
        a.strike(b);
        if(b.isAlive()){
            System.out.println("does not kill him");
            System.out.println(b.toString()+" strikes "+a.toString()+" and ");
            b.strike(a);
            if(a.isAlive())  System.out.println("does not kill him");
            else System.out.println("kills him");
        }
        else
            System.out.println("kills him");
    }


    public static <T extends AbstractUnit> void testAlive(T unitMordor, T unitMiddleEarth){
        if(!unitMordor.isAlive()){
            armyOfMordor.release((MordorUnit) unitMordor);
        }
        if(!unitMiddleEarth.isAlive()){
            armyOfMiddleEarth.release((MiddleEarthUnit) unitMiddleEarth);
        }
    }


    public static<T extends Unit> void printWinnerPhase(Collection<? extends T> winners) {
        for(T winner:winners){
            System.out.println(winner.toString());
        }
    }




    public static void printWinnerBattle(){
        if(armyOfMordor.getArmy().size()>0){
            System.out.println("Army of Mordor has won the battle. The winners list:");
            printArmy(armyOfMordor);
        } else {
            System.out.println("Army of MiddleEarth has won the battle. The winners list:");
            printArmy(armyOfMiddleEarth);
        }
    }


    public static boolean needThirdPhase(){
        return armyOfMordor.getArmy().size() > 0 && armyOfMiddleEarth.getArmy().size() > 0;
    }

    public static Army<MordorUnit> createMordorArmy(){
        Army<MordorUnit> armyOfMordor= new Army<>();
        int sizeMordor=createSize();
        for(int i=0; i<sizeMordor;i++){
            int typeOfUnits = 1 + (int) (Math.random() * 5);//количество разных юнитов в армии Мордора -5.
            switch (typeOfUnits) {
                case 1 -> armyOfMordor.recruit(new UrukHai(null));
                case 2 -> armyOfMordor.recruit(new Troll(null));
                case 3 -> armyOfMordor.recruit(new OrcOnWarg(null));
                case 4 -> armyOfMordor.recruit(new Orc(null));
                case 5 -> armyOfMordor.recruit(new Goblin(null));
            }
        }
        System.out.println("Army of Mordor consists of:");
        printArmy(armyOfMordor);
        return armyOfMordor;
    }


    public static Army<MiddleEarthUnit> createMiddleEarthArmy(){
        Army<MiddleEarthUnit> armyOfMiddleEarth= new Army<>();
        int sizeMiddleEart=createSize();
        if(Math.round(Math.random())==1) armyOfMiddleEarth.recruit(new Wizard(null));
        for(int i=0; i<sizeMiddleEart;i++){
            int typeOfUnits = 1 + (int) (Math.random() * 4);//количество разных юнитов в армии СЗ - 4.
            switch (typeOfUnits) {
                case 1 -> armyOfMiddleEarth.recruit(new WoodenElf(null));
                case 2 -> armyOfMiddleEarth.recruit(new Human(null));
                case 3 -> armyOfMiddleEarth.recruit(new Elf(null));
                case 4 -> armyOfMiddleEarth.recruit(new Rohhirim(null));
            }
        }
        System.out.println("Army of MiddleEarth consists of:");
        printArmy(armyOfMiddleEarth);
        return armyOfMiddleEarth;
    }


    public static <T extends Unit> void printArmy(Army<T> army){
        ArrayList<Unit> fullArmy= army.getArmy();
        System.out.println("Army size:"+fullArmy.size());
        for (Unit unit : fullArmy) {
            System.out.println(unit.toString());
        }
        System.out.println("\n");
    }

    public static int createSize(){
        return size + (int)(Math.random() * 0.2*size);
    }

}
