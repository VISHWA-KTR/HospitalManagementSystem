package dao;

import model.Patient;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDAO {
    public static void addPatient(Patient patient) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO Patient (name, disease, doctor_id) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, patient.name);
        ps.setString(2, patient.disease);
        ps.setInt(3, patient.doctorId);
        ps.executeUpdate();
        con.close();
    }

    public static void listPatients() throws Exception {
        Connection con = DBConnection.getConnection();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Patient");
        while (rs.next()) {
            System.out.println("Patient ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                               ", Disease: " + rs.getString("disease") + ", Doctor ID: " + rs.getInt("doctor_id"));
        }
        con.close();
    }
}
