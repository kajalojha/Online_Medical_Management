package Online_Medical_Management_System;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Appointment {
    private String patientid;
    private String doctorid;

    private LocalDateTime dateTime;
    List<Appointment> appointmentList;

    public Appointment(String patientid ,String doctorid,  LocalDateTime dateTime) {
        this.patientid = patientid;
        this.doctorid = doctorid;
        this.dateTime = dateTime;
        appointmentList = new ArrayList<>();
    }

    // Getters and setters for all fields

    public String getPatient() {
        return patientid;
    }

    public void setPatient(String patientid) {
        this.patientid = patientid;
    }

    public String getDoctor() {
        return doctorid;
    }

    public void setDoctor(String doctorid) {
        this.doctorid = doctorid;
    }



    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patientid =" + patientid +
                ", doctorid =" + doctorid +
                ", dateTime=" + dateTime +
                '}';
    }

}
