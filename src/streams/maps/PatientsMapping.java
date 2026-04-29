package streams.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientsMapping {
    public static void main(String[] args) throws IOException {
        List<Patient> patients = Files.lines(Path.of("data/streams/maps/patients.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(t -> new Patient(
                        Integer.parseInt(t[0]),
                        t[1],
                        Integer.parseInt(t[2]),
                        t[3].equals("Female")
                        )).toList();
        List<PatientRecord> patientRecords = Files.lines(Path.of("data/streams/maps/patients_records.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(t -> new PatientRecord(
                        Integer.parseInt(t[0]),
                        Integer.parseInt(t[1]),
                        LocalDate.parse(t[2]),
                        t[3],
                        t[4],
                        Integer.parseInt(t[5]),
                        Double.parseDouble(t[6]),
                        t[7]
                ))
                .toList();
        HashMap<Integer, Patient> refMap = new HashMap<>();
        for(Patient p : patients){
            refMap.put(p.getId(), p);
        }

        patientRecords.stream()
                .forEach(patientRecord -> refMap.get(patientRecord.getPatientId()).getRecords().add(patientRecord));

        for(PatientRecord r : refMap.get(17).getRecords()){
            System.out.println(r.getDiagnosis());
        }

        List<Patient> oldAsses = patients.stream()
                .filter(patient -> {
                    for(PatientRecord r : patient.getRecords()){
                        if(r.getDiagnosis().equals("Back pain")) return true;
                    }
                    return false;
                })
                .toList();
    }

}

class Patient{
    int id;
    String name;
    int age;
    boolean isFemoid;
    List<PatientRecord> records;

    public Patient(int id, String name, int age, boolean isFemoid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isFemoid = isFemoid;
        this.records = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isFemoid=" + isFemoid +
                '}';
    }

    public List<PatientRecord> getRecords() {
        return records;
    }

    public void setRecords(List<PatientRecord> records) {
        this.records = records;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFemoid() {
        return isFemoid;
    }

    public void setFemoid(boolean femoid) {
        isFemoid = femoid;
    }
}

class PatientRecord{
    int recordId;
    int patientId;
    LocalDate visitDate;
    String bloodPressure;
    String bloodType;
    int BPM;
    double temperature;
    String diagnosis;

    public PatientRecord(int recordId, int patientId, LocalDate visitDate, String bloodPressure, String bloodType, int BPM, double temperature, String diagnosis) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.visitDate = visitDate;
        this.bloodPressure = bloodPressure;
        this.bloodType = bloodType;
        this.BPM = BPM;
        this.temperature = temperature;
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "PatientsMapping{" +
                "recordId=" + recordId +
                ", patientId=" + patientId +
                ", visitDate=" + visitDate +
                ", bloodPressure='" + bloodPressure + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", BPM=" + BPM +
                ", temperature=" + temperature +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public int getBPM() {
        return BPM;
    }

    public void setBPM(int BPM) {
        this.BPM = BPM;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}