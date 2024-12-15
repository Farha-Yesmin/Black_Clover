package org.gpa.gpacalculate;

public class Student {
    String name;
    int id;
    int[] creditArr = new int[3];
    double[] gradeArr = new double[3];

    public double gpaCalculate(){
        int totalCredit = 0;
        double qualityPoint = 0;

        for (int i=0; i<3; i++){
           qualityPoint += creditArr[i] * gradeArr[i];
           totalCredit += creditArr[i];
        }
        return qualityPoint/totalCredit;
    }
}
