package kr.ac.dankook.ace.lab2.model;

public class Earthquake {
    private String title;
    private String time;
    private double magnitude;
    private String link;

    public Earthquake() {}

    public Earthquake(String title, String time, double magnitude, String link) {
        this.title = title;
        this.time = time;
        this.magnitude = magnitude;
        this.link = link;
    }

    public String getTitle() { return title; }
    public String getTime() { return time; }
    public double getMagnitude() { return magnitude; }
    public String getLink() { return link; }

    public void setTitle(String title) { this.title = title; }
    public void setTime(String time) { this.time = time; }
    public void setMagnitude(double magnitude) { this.magnitude = magnitude; }
    public void setLink(String link) { this.link = link; }
}

