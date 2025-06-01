package model;

import java.sql.Date;

public class Appointment {
    public int id;
    public int patientId;
    public int doctorId;
    public Date date;
    public String timeSlot;
    public String status;

    public Appointment(int patientId, int doctorId, Date date, String timeSlot, String status) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.timeSlot = timeSlot;
        this.status = status;
    }
}
