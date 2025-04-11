package kr.ac.dankook.ace.lab2.model;

public class Volcano {
    private String date;
    private String name;
    private String alertLevel;
    private String colorCode;
    private String url;

    public Volcano() {}

    public Volcano(String date, String name, String alertLevel, String colorCode, String url) {
        this.date = date;
        this.name = name;
        this.alertLevel = alertLevel;
        this.colorCode = colorCode;
        this.url = url;
    }

    public String getDate() { return date; }
    public String getName() { return name; }
    public String getAlertLevel() { return alertLevel; }
    public String getColorCode() { return colorCode; }
    public String getUrl() { return url; }

    public void setDate(String date) { this.date = date; }
    public void setName(String name) { this.name = name; }
    public void setAlertLevel(String alertLevel) { this.alertLevel = alertLevel; }
    public void setColorCode(String colorCode) { this.colorCode = colorCode; }
    public void setUrl(String url) { this.url = url; }
    
}