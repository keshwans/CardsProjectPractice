package org.c4q.cardsprojectpractice.models;

/**
 * Created by keshwans on 6/27/15.
 */
public class WeatherData extends CardData{
    String zip;
    String temperature;

    public WeatherData(String zip, String temperature) {
        this.zip = zip;
        this.temperature = temperature;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
