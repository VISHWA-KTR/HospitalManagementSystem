
# 🏥 Hospital Management System

A **Java console application** that manages hospital operations such as doctor and patient registration, appointment booking, and status tracking using **JDBC with MySQL**. This lightweight system demonstrates CRUD operations and relational database management without a GUI.

---

## 💡 Features

- 👨‍⚕️ Add and manage **Doctors**
- 🧑‍🦽 Register **Patients** and link them with doctors
- 📅 Book and list **Appointments**
- 🔄 Update appointment **status**
- 🗄️ Uses relational tables with **foreign key constraints**

---

## 🛠️ Technologies Used

- **Java** (Console-based UI)  
- **JDBC** for database connectivity  
- **MySQL** for data storage  
- **IDE:** IntelliJ / Eclipse / NetBeans

---

## 📂 Project Structure

```
HospitalManagementSystem/
├── src/
│   ├── dao/
│   │   ├── DoctorDAO.java
│   │   ├── PatientDAO.java
│   │   └── AppointmentDAO.java
│   ├── model/
│   │   ├── Doctor.java
│   │   ├── Patient.java
│   │   └── Appointment.java
│   ├── sql/
│   │   └── schema.sql       
│   └── Main.java
├── README.md

```

---

## 🗃️ Database Schema (MySQL)

```sql
CREATE DATABASE IF NOT EXISTS HospitalDB;
USE HospitalDB;

CREATE TABLE Doctor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    specialization VARCHAR(100)
);

CREATE TABLE Patient (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    disease VARCHAR(100),
    doctor_id INT,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(id)
);

CREATE TABLE Appointment (
    id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    time_slot VARCHAR(20),
    status VARCHAR(20) DEFAULT 'PENDING',
    FOREIGN KEY (patient_id) REFERENCES Patient(id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(id)
);
```

---

## 📦 How to Run the Application

1. **Set up the database**
   - Import `HospitalDB.sql` into MySQL.
2. **Update DB credentials**
   - Edit your DB connection file (e.g. `DBConnection.java`) with your MySQL username and password.
3. **Compile and run**
   - Compile all `.java` files and run `Main.java`.

---

## 🖥️ Console Interaction Example

```
--- Hospital Management System ---
1. Add Doctor
2. Add Patient
3. Book Appointment
4. List Appointments
5. Update Appointment Status
6. Exit
Choose option: 1
Doctor Name: Dr. Smith
Specialization: Cardiology
Doctor added.
```

```
Choose option: 3
Patient ID: 1
Doctor ID: 2
Date (yyyy-MM-dd): 2025-06-01
Time (e.g. 10:30 AM): 11:00 AM
Status (e.g. CONFIRMED): CONFIRMED
Appointment booked successfully.
```

---

## 🙋‍♂️ Author

**VISHWA S**  
[GitHub](https://github.com/VISHWA_KTR)

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
