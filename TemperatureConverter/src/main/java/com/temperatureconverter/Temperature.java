package com.temperatureconverter;

public class Temperature {
    public double temperature;

    public double convertToFahrenheit(){
        return (temperature*9)/5+32;
    }

    public double convertToCelcius(){
        return ((temperature-32)/9)*5;
    }
}
