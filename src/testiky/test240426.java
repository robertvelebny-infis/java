package testiky;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class test240426 {
    public static void main(String[] args) throws IOException {
        List<TestResult> testResults = Files.lines(Paths.get("data/testy/scores.csv"))
                .map(lines -> lines.split(","))
                .skip(1)
                .map(tokens -> new TestResult(tokens[0], tokens[1], Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3])))
                .toList();

        System.out.println(testResults.stream().collect(Collectors.groupingBy(TestResult::getSubject, Collectors.counting())));

        HashMap<String, String> uniqueStudents = new HashMap<>();

        for(TestResult tr : testResults){
            uniqueStudents.put(tr.getStudent_name(), "this is terribly inefficient :D");
        }

        System.out.println(uniqueStudents.size());
        Map<String, List<TestResult>> bySubject = testResults.stream()
                        .collect(Collectors.groupingBy(TestResult::getSubject));

        int inefficientCounter = 0;
        int amountPassed = 0;
        for(TestResult tr : bySubject.get("Chemistry")){
            inefficientCounter++;
            if(tr.getScore() > 70){
                amountPassed++;
            }
        }
        System.out.println("z chemie proslo: " + (((double)amountPassed / (double)inefficientCounter) * 100) + "%");

        for(TestResult tr : bySubject.get("IT")){
            inefficientCounter++;
            if(tr.getScore() > 70){
                amountPassed++;
            }
        }
        System.out.println("z it proslo: " + (((double)amountPassed / (double)inefficientCounter) * 100) + "%");


        Map<String, Double> avgGrade = testResults.stream()
                .collect(Collectors.groupingBy(TestResult::getSubject, Collectors.averagingDouble(TestResult::getScore)));

        System.out.println();

        for(String subject : avgGrade.keySet()){
            System.out.println(subject + " average: " + avgGrade.get(subject));
        }

        HashMap<String, ArrayList> studentsTime = new HashMap<>();

        for(TestResult tr : testResults){
            if (studentsTime.containsKey(tr.getStudent_name())){
                studentsTime.get(tr.getStudent_name()).add(tr.timeSpent);
            }
            else{
                studentsTime.put(tr.getStudent_name(), new ArrayList<>());
                studentsTime.get(tr.getStudent_name()).add(tr.timeSpent);
            }
        }
        //dosel cas :D, predem se omlouvam za tento odporny kod a preji hezky zbytek vecera
    }
}

class TestResult{
    String student_name, subject;
    double score;
    int timeSpent;

    public TestResult(String student_name, String subject, double score, int timeSpent) {
        this.student_name = student_name;
        this.subject = subject;
        this.score = score;
        this.timeSpent = timeSpent;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "student_name='" + student_name + '\'' +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                ", timeSpent=" + timeSpent +
                '}';
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }
}