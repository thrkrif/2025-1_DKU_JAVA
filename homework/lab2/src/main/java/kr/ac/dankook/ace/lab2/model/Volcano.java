package kr.ac.dankook.ace.lab2.model;

public class Volcano {
    private String date;
    private String name;
    private String colorCode;
    private String link;

    public Volcano() {}

    public Volcano(String date, String name, String colorCode, String link) {
        this.date = date;
        this.name = name;
        this.colorCode = colorCode;
        this.link = link;
    }

    public String getDate() { return date; }
    public String getName() { return name; }
    public String getColorCode() { return this.colorCode; }
    public String getLink() { return link; }

    public void setDate(String date) { this.date = date; }
    public void setName(String name) { this.name = name; }
    public void setColorCode(String colorCode) { this.colorCode = colorCode; }
    public void setLink(String link) { this.link = link; }
    
}