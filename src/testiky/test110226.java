package testiky;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

public class test110226 {

    public static ArrayList<File> returnExtension(File folder, String Extension){
        if(!folder.exists() || !folder.isDirectory()){
            System.out.println("invalid directory");
            return null;
        }
        File[] files = folder.listFiles();
        ArrayList<File> returnFiles = new ArrayList<>();
        for(File i : files){
            String[] fileNameParsed = i.getName().split("\\.");
            System.out.println(fileNameParsed[1]);
            if(("." + fileNameParsed[fileNameParsed.length - 1]).equals(Extension) && i.length() < 2000000){
                returnFiles.add(i);
            }
        }
        final Comparator<File> BY_SIZE = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return Long.compare(o1.length(), o2.length());
            }
        };
        returnFiles.sort(BY_SIZE);
        return returnFiles;
    }
//ups
//    public static ArrayList<File> return2MB(File folder){
//        if(!folder.exists() || !folder.isDirectory()){
//            System.out.println("invalid directory");
//            return null;
//        }
//        ArrayList<File> returnFiles = new ArrayList<>();
//        File[] files = folder.listFiles();
//        for(File i : files){
//            if(i.length() < 2000000){
//                returnFiles.add(i);
//            }
//        }
//        return returnFiles;
//    }
//
//    public static ArrayList<File> sortFiles(File folder){
//        if(!folder.exists() || !folder.isDirectory()){
//            System.out.println("invalid directory");
//            return null;
//        }
//        ArrayList<File> returnFiles = new ArrayList<>();
//        File[] files = folder.listFiles();
//        for(File i : files){
//            returnFiles.add(i);
//        }
//        final Comparator<File> BY_SIZE = new Comparator<File>() {
//            @Override
//            public int compare(File o1, File o2) {
//                return Long.compare(o1.length(), o2.length());
//            }
//        };
//        returnFiles.sort(BY_SIZE);
//        return returnFiles;
//    }

    public static void main(String[] args) {
        ArrayList<File> txtFiles = returnExtension(new File("data/poetry"), ".txt");

    }
}
