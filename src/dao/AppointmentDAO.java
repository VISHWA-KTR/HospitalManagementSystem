package dao;

import model.Appointment;
import util.DBConnection;

import java.sql.*;

public class AppointmentDAO {

    public static boolean doctorExists(int doctorId) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Doctor WHERE id=?");
        ps.setInt(1, doctorId);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        con.close();
        return exists;
    }

    public static boolean patientExists(int patientId) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Patient WHERE id=?");
        ps.setInt(1, patientId);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        con.close();
        return exists;
    }

    public static void bookAppointment(Appointment appt) throws Exception {
        if (!doctorExists(appt.doctorId) || !patientExists(appt.patientId)) {
            System.out.println("Doctor or Patient not found.");
            return;
        }

        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO Appointment (patient_id, doctor_id, appointment_date, time_slot, status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, appt.patientId);
        ps.setInt(2, appt.doctorId);
        ps.setDate(3, appt.date);
        ps.setString(4, appt.timeSlot);
        ps.setString(5, appt.status);
        ps.executeUpdate();
        System.out.println("Appointment booked successfully.");
        con.close();
    }

    public static void updateAppointmentStatus(int id, String newStatus) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE Appointment SET status=? WHERE id=?");
        ps.setString(1, newStatus);
        ps.setInt(2, id);
        ps.executeUpdate();
        con.close();
    }

    public static void deleteAppointment(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM Appointment WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

    public static void listAppointments() throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT a.id, p.name, d.name, a.appointment_date, a.time_slot, a.status " +
                     "FROM Appointment a " +
                     "JOIN Patient p ON a.patient_id = p.id " +
                     "JOIN Doctor d ON a.doctor_id = d.id";
        ResultSet rs = con.createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt(1) +
                    ", Patient: " + rs.getString(2) +
                    ", Doctor: " + rs.getString(3) +
                    ", Date: " + rs.getDate(4) +
                    ", Time: " + rs.getString(5) +
                    ", Status: " + rs.getString(6));
        }
        con.close();
    }
}
