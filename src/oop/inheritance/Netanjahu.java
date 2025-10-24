package oop.inheritance;

public class Netanjahu extends Soldier{
    public Netanjahu(String name){
        super(name);
        gold += 50;
    }

    public void commitGenocide(){
        System.out.println(name + " is commiting a genocide");
        gold += 250;
    }

    @Override
    public void hunt() {
        System.out.println(name + " is hunting palestinian women and children");
        gold += 50;
    }
}
