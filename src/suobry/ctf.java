package suobry;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ctf {
    /*public static void tree(File root){
        ArrayList<String> keys = new ArrayList<>();
        if (!root.exists()){
            return;
        }
        if (!root.isDirectory()){
            System.out.println(root.getPath());
        }
        else{
            //System.out.println(root.getPath());
            File[] content = root.listFiles();
            for(File file : content){
                if (!file.isDirectory()){
                    try (FileReader fr = new FileReader(file)) {
                        int input;
                        StringBuilder readText = new StringBuilder();
                        while((input = fr.read()) != -1){
                            if(input != '\n'){
                                readText.append(input);
                            }
                            else{
                                String finalText = readText.toString();
                                String[] textParsed = finalText.split(";");
                                if (textParsed[0].length() != Integer.parseInt(textParsed[1])){
                                    keys.add(textParsed[2]);
                                }
                                readText.delete();
                            }
                        }
                    } catch (IOException e){
                        System.out.println("ahoj");
                    }

                }
                tree(file);
            }
        }
        System.out.println(keys);
    }
    public static void main(String[] args) {
        tree(new File("data/ctf"));
    }*/
}
