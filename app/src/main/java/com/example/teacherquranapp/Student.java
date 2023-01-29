package com.example.teacherquranapp;

public class Student {
    private String name;
    private String rollNo;
    private String sabq;
    private String sabqi;
    private String manzil;
    public Student(String name, String rollNo, String sabq,String sabqi,
     String manzil) {
        this.name = name;
        this.rollNo=rollNo;
        this.sabq = sabq;
        this.sabqi=sabqi;
        this.manzil=manzil;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getSabq() {
        return sabq;
    }

    public void setSabq(String sabq) {
        this.sabq = sabq;
    }

    public String getSabqi() {
        return sabqi;
    }

    public void setSabqi(String sabqi) {
        this.sabqi = sabqi;
    }

    public String getManzil() {
        return manzil;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", sabq=" + sabq + ", sabqi=" + sabqi +", manzil=" + manzil+ "]";
    }
}
