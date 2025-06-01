package model;

public class Patient {
    public int id;
    public String name;
    public String disease;
    public int doctorId;

    public Patient(String name, String disease, int doctorId) {
        this.name = name;
        this.disease = disease;
        this.doctorId = doctorId;
    }

    public Patient(int id, String name, String disease, int doctorId) {
        this.id = id;
        this.name = name;
        this.disease = disease;
        this.doctorId = doctorId;
    }
}
