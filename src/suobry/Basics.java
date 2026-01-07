package suobry;

import java.io.File;

public class Basics {
    static void tree(File root){ //rekurzivni algorytmus pro vypisovani stromecku souboru (jakoze vsechny soubory co tam jsou)
        if (!root.exists()){
            return;
        }
        if (!root.isDirectory()){
            System.out.println(root.getPath());
        }
        else{
            System.out.println(root.getPath());
            File[] content = root.listFiles();
            for(File file : content){
                tree(file);
            }
        }
    }
    public static void main(String[] args) {
        File f = new File("tracks.txt"); // vytvorim novy objekt s odkazem na soubor
        System.out.println(f.isFile()); //je to soubor (ne adresar)
        System.out.println(f.exists()); //existuje to (soubor nebo adresar)
        System.out.println(f.isDirectory()); //je to adresar?
        System.out.println(f.length()); //vyprintne velikost v bytech

        new File("dirExample").mkdir(); //vytvor adresar. vraci true false (povedlo nepovedlo)
        new File("ahoj\\jakJe").mkdirs(); //vytvori slozku a podslozku. jenom s mkdir by tohle neslo.

        System.out.println(f.getName());
        System.out.println(f.getPath());

        System.out.println("oddelovac--------------------------------------------");
        tree(new File("src"));
    }
}
