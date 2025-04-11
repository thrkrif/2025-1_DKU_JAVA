package kr.ac.dankook.ace.lab2.model;

public class Earthquake {
    private String place;
    private String time;
    private double magnitude;
    private String url;

    public Earthquake() {}

    public Earthquake(String place, String time, double magnitude, String url) {
        this.place = place;
        this.time = time;
        this.magnitude = magnitude;
        this.url = url;
    }

    public String getPlace() { return place; }
    public String getTime() { return time; }
    public double getMagnitude() { return magnitude; }
    public String getUrl() { return url; }

    public void setPlace(String place) { this.place = place; }
    public void setTime(String time) { this.time = time; }
    public void setMagnitude(double magnitude) { this.magnitude = magnitude; }
    public void setUrl(String url) { this.url = url; }
}

