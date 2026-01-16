package suobry;

import java.io.*;

public class Grades {
    public static void main(String[] args) {
        String path = "data\\znamky.txt";
        String pathOut = "data\\znamky-out.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut));
            String line = "";
            String nameBest = "", nameWorst = "";
            double averageBest = Double.MAX_VALUE;
            double averageWorst = Double.MIN_VALUE;

            while((line = br.readLine()) != null){

                String[] lineParsed = line.split(";");
                System.out.print(lineParsed[0] + " - ");
                bw.write(lineParsed[0] + " - ");
                double gradeSum = 0;

                for (int i = 1; i < lineParsed.length; i++) {
                    gradeSum += Integer.parseInt(lineParsed[i]);
                }

                double gradeResult = (gradeSum / (lineParsed.length - 1));
                System.out.println(gradeResult);
                bw.write(gradeResult + "\n");

                if(gradeResult < averageBest){
                    averageBest = gradeResult;
                    nameBest = lineParsed[0];
                }
                if(gradeResult > averageWorst){
                    averageWorst = gradeResult;
                    nameWorst = lineParsed[0];
                }
            }
            System.out.println("\nBest average: " + nameBest + " - " + averageBest + "\nWorst average: " + nameWorst + " - " + averageWorst);
            bw.write("\nBest average: " + nameBest + " - " + averageBest + "\nWorst average: " + nameWorst + " - " + averageWorst);
            bw.close();
        }
        catch(IOException e){
            System.out.println("An exception occurred while attempting to read the file " + path);
        }
    }
}
