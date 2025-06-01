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
    time_slot VARCHAR(20), -- e.g. "10:00 AM"
    status VARCHAR(20) DEFAULT 'PENDING',
    FOREIGN KEY (patient_id) REFERENCES Patient(id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(id)
);
