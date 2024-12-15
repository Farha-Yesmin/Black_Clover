package org.studentproject.student_project;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private int id;
    private String name, major, gender, skills;
    private float cgpa;
    private LocalDate dob;

    public Student() {
    }

    public Student(int id, String name, String major, String gender, String skills, float cgpa, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.gender = gender;
        this.skills = skills;
        this.cgpa = cgpa;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", gender='" + gender + '\'' +
                ", skills='" + skills + '\'' +
                ", cgpa=" + cgpa +
                ", dob=" + dob +
                '}';
    }

    public int calculateAge(){
        Period period = Period.between(this.dob, LocalDate.now());
        return period.getYears();
    }
}
