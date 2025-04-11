package kr.ac.dankook.ace.lab2.model;

public class Earthquake {
    private String place;
    private String time;
    private double magnitude;
    private String link;

    public Earthquake() {}

    public Earthquake(String place, String time, double magnitude, String link) {
        this.place = place;
        this.time = time;
        this.magnitude = magnitude;
        this.link = link;
    }

    public String getPlace() { return place; }
    public String getTime() { return time; }
    public double getMagnitude() { return magnitude; }
    public String getLink() { return link; }

    public void setPlace(String place) { this.place = place; }
    public void setTime(String time) { this.time = time; }
    public void setMagnitude(double magnitude) { this.magnitude = magnitude; }
    public void setLink(String link) { this.link = link; }
}

