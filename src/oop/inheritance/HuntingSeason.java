package oop.inheritance;

import java.util.ArrayList;
import java.util.Random;

public class HuntingSeason {

    static void doRandomJob(Hunter hunter){
        Random rng = new Random();

        switch(rng.nextInt(1, 4)){
            case 1:
                hunter.hunt();
                break;
            case 2:
                ((Soldier) hunter).killBandits();
                break;
            case 3:
                ((Netanjahu) hunter).commitGenocide();
                break;
        }
    }


    public static void main(String[] args) {
        Hunter hunter = new Hunter("Ted Kaczinski");
        hunter.hunt();

        Soldier soldier = new Soldier("Shaman");
        soldier.hunt();
        soldier.killBandits();

        Netanjahu netanjahu = new Netanjahu("Benjamin Netanjahu");
        netanjahu.hunt();
        netanjahu.killBandits();
        netanjahu.commitGenocide();

        ArrayList<Hunter> hunters = new ArrayList<>();
        hunters.add(new Hunter("Tommy Angelo"));
        hunters.add(soldier);
        hunters.add(netanjahu);

        for(Hunter hunter1 : hunters){
            doRandomJob(hunter1);
        }
    }
}
