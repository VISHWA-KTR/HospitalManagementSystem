package dao;

import model.Doctor;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorDAO {
    public static void addDoctor(Doctor doctor) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO Doctor (name, specialization) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, doctor.name);
        ps.setString(2, doctor.specialization);
        ps.executeUpdate();
        con.close();
    }

    public static void listDoctors() throws Exception {
        Connection con = DBConnection.getConnection();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Doctor");
        while (rs.next()) {
            System.out.println("Doctor ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Specialization: " + rs.getString("specialization"));
        }
        con.close();
    }
}
