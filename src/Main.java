import dao.AppointmentDAO;
import dao.DoctorDAO;
import dao.PatientDAO;
import model.Appointment;
import model.Doctor;
import model.Patient;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Book Appointment");
            System.out.println("4. List Appointments");
            System.out.println("5. Update Appointment Status");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Doctor Name: ");
                    String name = sc.nextLine();
                    System.out.print("Specialization: ");
                    String specialization = sc.nextLine();
                    DoctorDAO.addDoctor(new Doctor(name, specialization));
                    System.out.println("Doctor added.");
                }
                case 2 -> {
                    System.out.print("Patient Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Disease: ");
                    String disease = sc.nextLine();
                    System.out.print("Doctor ID: ");
                    int did = Integer.parseInt(sc.nextLine());
                    PatientDAO.addPatient(new Patient(pname, disease, did));
                    System.out.println("Patient added.");
                }
                case 3 -> {
                    System.out.print("Patient ID: ");
                    int pid = Integer.parseInt(sc.nextLine());
                    System.out.print("Doctor ID: ");
                    int did = Integer.parseInt(sc.nextLine());
                    System.out.print("Date (yyyy-MM-dd): ");
                    String dateStr = sc.nextLine();
                    System.out.print("Time (e.g. 10:30 AM): ");
                    String time = sc.nextLine();
                    System.out.print("Status (e.g. CONFIRMED): ");
                    String status = sc.nextLine();

                    Date date = Date.valueOf(dateStr);
                    Appointment appt = new Appointment(pid, did, date, time, status);
                    AppointmentDAO.bookAppointment(appt);
                    System.out.println("Appointment booked successfully.");
                }
                case 4 -> {
                    AppointmentDAO.listAppointments();
                }
                case 5 -> {
                    System.out.print("Appointment ID to update: ");
                    int apptId = Integer.parseInt(sc.nextLine());
                    System.out.print("New Status: ");
                    String newStatus = sc.nextLine();
                    AppointmentDAO.updateAppointmentStatus(apptId, newStatus);
                    System.out.println("Appointment status updated.");
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }
    }
}
