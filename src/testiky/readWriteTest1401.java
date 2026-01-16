package testiky;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class readWriteTest1401 {
    public static void main(String[] args) {
        String path = "data\\textInput.txt";
        try(FileReader fr = new FileReader(path)){
            int[] amountOf = {0, 0, 0}; //0 = znaku, 1= vet, 2 = radek
            int input;
            int previousInput = 0;
            while((input = fr.read()) != -1){
                amountOf[0]++; //pridej dalsi do poctu znaku
                if((char)input == '.' || (char)input == '?' || (char)input == '!'){
                    amountOf[1]++; //pridej dalsi do poctu vet
                }
                if((char)input == '\n'){
                    amountOf[2]++; //pridej dalsi do poctu radku
                }
                previousInput = input; //pomocna promenna pro kontrolu posledniho znaku
                System.out.print((char) input);
            }
            if ((char)previousInput != '\n'){ //predpokladam, ze posledni charakter nebude break line, ale pokud ano, tak by tohle melo zajistit, aby byl zpravnej pocet znaku
                amountOf[2]++; //pripocti 1 k poctu radku pokud posledni znak neni breakline
            }
            System.out.println("---------------"); //oddelovac pro citelnost
            System.out.println("pocet znaku je: " + amountOf[0]);
            System.out.println("pocet vet je: " + amountOf[1]);
            System.out.println("pocet radek je: " + amountOf[2]);

        } catch (IOException e){
            System.out.println("Nastala vyjimka pri cteni souboru " + path);
        }

    }
}
