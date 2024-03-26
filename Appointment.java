package Online_Medical_Management_System;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Appointment {
    private Patient patientid;
    private Doctor doctorid;
    private String problem;

    List<Appointment> appointmentList;

    public Appointment(Patient patientid ,Doctor doctorid,  String problem) {
        this.patientid = patientid;
        this.doctorid = doctorid;
        this.problem = problem;
        appointmentList = new ArrayList<>();
    }

    public Patient getPatientid() {
        return patientid;
    }

    public void setPatientid(Patient patientid) {
        this.patientid = patientid;
    }

    // Getters and setters for all fields


    public String getProblem() {
        return problem;
    }

    public Doctor getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Doctor doctorid) {
        this.doctorid = doctorid;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patientid =" + patientid +
                ", doctorid =" + doctorid +
                ", appintment id  =" + problem +
                '}';
    }

}
