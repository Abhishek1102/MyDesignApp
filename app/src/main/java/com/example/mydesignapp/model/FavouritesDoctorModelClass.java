package com.example.mydesignapp.model;

public class FavouritesDoctorModelClass {
    private String doctorname;
    private String doctorSpeciality;
    private String doctorExperience;
    private String doctorRating;
    private String doctorRatingnumber;
    private String doctordistance;
    private int doctorimage;
    private String btn_bookappointment;

    public FavouritesDoctorModelClass(String doctorname, String doctorSpeciality, String doctorExperience, String doctorRating, String doctorRatingnumber, String doctordistance, int doctorimage, String btn_bookappointment) {
        this.doctorname = doctorname;
        this.doctorSpeciality = doctorSpeciality;
        this.doctorExperience = doctorExperience;
        this.doctorRating = doctorRating;
        this.doctorRatingnumber = doctorRatingnumber;
        this.doctordistance = doctordistance;
        this.doctorimage = doctorimage;
        this.btn_bookappointment = btn_bookappointment;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public String getDoctorExperience() {
        return doctorExperience;
    }

    public void setDoctorExperience(String doctorExperience) {
        this.doctorExperience = doctorExperience;
    }

    public String getDoctorRating() {
        return doctorRating;
    }

    public void setDoctorRating(String doctorRating) {
        this.doctorRating = doctorRating;
    }

    public String getDoctorRatingnumber() {
        return doctorRatingnumber;
    }

    public void setDoctorRatingnumber(String doctorRatingnumber) {
        this.doctorRatingnumber = doctorRatingnumber;
    }

    public String getDoctordistance() {
        return doctordistance;
    }

    public void setDoctordistance(String doctordistance) {
        this.doctordistance = doctordistance;
    }

    public int getDoctorimage() {
        return doctorimage;
    }

    public void setDoctorimage(int doctorimage) {
        this.doctorimage = doctorimage;
    }

    public String getBtn_bookappointment() {
        return btn_bookappointment;
    }

    public void setBtn_bookappointment(String btn_bookappointment) {
        this.btn_bookappointment = btn_bookappointment;
    }
}
