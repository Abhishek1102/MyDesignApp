package com.example.mydesignapp.model;

public class AppointmentModelClass {
    private int doctorimage;
    private String doctorname;
    private String doctoraddress;
    private String doctortime;
    private String doctortimeAmPm;
    private String doctorappointmentdate;
    private String doctorspeciality;
    private int optionicon_image;
    private String appointmenttime;
    private boolean is_selectedMorning = false;
    private boolean is_selectedEvening = false;

    public AppointmentModelClass(int doctorimage, String doctorname, String doctoraddress, String doctortime, String doctortimeAmPm, String doctorappointmentdate, String doctorspeciality, int optionicon_image, String appointmenttime) {
        this.doctorimage = doctorimage;
        this.doctorname = doctorname;
        this.doctoraddress = doctoraddress;
        this.doctortime = doctortime;
        this.doctortimeAmPm = doctortimeAmPm;
        this.doctorappointmentdate = doctorappointmentdate;
        this.doctorspeciality = doctorspeciality;
        this.optionicon_image = optionicon_image;
        this.appointmenttime = appointmenttime;
    }

    public int getDoctorimage() {
        return doctorimage;
    }

    public void setDoctorimage(int doctorimage) {
        this.doctorimage = doctorimage;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDoctoraddress() {
        return doctoraddress;
    }

    public void setDoctoraddress(String doctoraddress) {
        this.doctoraddress = doctoraddress;
    }

    public String getDoctortime() {
        return doctortime;
    }

    public void setDoctortime(String doctortime) {
        this.doctortime = doctortime;
    }

    public String getDoctortimeAmPm() {
        return doctortimeAmPm;
    }

    public void setDoctortimeAmPm(String doctortimeAmPm) {
        this.doctortimeAmPm = doctortimeAmPm;
    }

    public String getDoctorappointmentdate() {
        return doctorappointmentdate;
    }

    public void setDoctorappointmentdate(String doctorappointmentdate) {
        this.doctorappointmentdate = doctorappointmentdate;
    }

    public String getDoctorspeciality() {
        return doctorspeciality;
    }

    public void setDoctorspeciality(String doctorspeciality) {
        this.doctorspeciality = doctorspeciality;
    }

    public int getOptionicon_image() {
        return optionicon_image;
    }

    public void setOptionicon_image(int optionicon_image) {
        this.optionicon_image = optionicon_image;
    }

    public String getAppointmenttime() {
        return appointmenttime;
    }

    public void setAppointmenttime(String appointmenttime) {
        this.appointmenttime = appointmenttime;
    }

    public boolean isIs_selectedMorning() {
        return is_selectedMorning;
    }

    public void setIs_selectedMorning(boolean is_selectedMorning) {
        this.is_selectedMorning = is_selectedMorning;
    }

    public boolean isIs_selectedEvening() {
        return is_selectedEvening;
    }

    public void setIs_selectedEvening(boolean is_selectedEvening) {
        this.is_selectedEvening = is_selectedEvening;
    }
}