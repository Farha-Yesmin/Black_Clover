package org.studentproject.student_project;

import java.io.Serializable;

public class Course implements Serializable {
    private String courseID, title, type;
    private int noOfCredits;

    public Course() {
    }

    public Course(String courseID, String title, String type, int noOfCredits) {
        this.courseID = courseID;
        this.title = title;
        this.type = type;
        this.noOfCredits = noOfCredits;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNoOfCredits() {
        return noOfCredits;
    }

    public void setNoOfCredits(int noOfCredits) {
        this.noOfCredits = noOfCredits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", noOfCredits=" + noOfCredits +
                '}';
    }
    public String toString(String reason){
        return courseID+","+title+","+type+","+noOfCredits+'\n';
    }
}

