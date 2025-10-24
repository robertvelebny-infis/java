package mam_hlad_smutny_smajlik;

import fileworks.DataExport;
import fileworks.DataImport;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*DataImport dataImport = new DataImport("konfigurace_k_zaverce - kopie.txt");
        String amogus = dataImport.readLine(4);
        System.out.println(amogus);
        dataImport.finishImport();
        dataImport.reinitializeRead();*/

        DataExport dataExport = new DataExport("♀←┤∟.txt");
        dataExport.writeLine("♂");


        
        dataExport.finishExport();
    }
}
