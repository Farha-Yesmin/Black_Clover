package org.complexnum.complexnumber;

public class ComplexNo {
    int real,img;

    public ComplexNo(int real, int img) {
        this.real = real;
        this.img = img;
    }

    public ComplexNo() {
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "ComplexNo: " +
                real + " + " +
                img + " i";
    }

    ComplexNo add(ComplexNo c){
        ComplexNo resultComplexNo = new ComplexNo();
        resultComplexNo.real = this.real + c.real;
        resultComplexNo.img = this.img + c.img;
        return resultComplexNo;
    }

    ComplexNo subtract(ComplexNo c){
        ComplexNo resultComplexNo = new ComplexNo();
        if (this.img< c.img) {
            resultComplexNo.real = this.real - c.real;
            resultComplexNo.img = c.img - this.img;
        }
        else {
            resultComplexNo.real = this.real - c.real;
            resultComplexNo.img = this.img - c.img;
        }
        return resultComplexNo;
    }
}
