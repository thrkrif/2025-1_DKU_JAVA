package kr.ac.dankook.ace.lab3.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Tsunami {
    private int year;
    private int month;
    private int day;
    private String eventValidity;
    private String causeCode;
    private String country;
    private String locationName;
    private double latitude;
    private double longitude;
    private double maximumWaterHeight;
    private int numberOfRunups;

    // 정확한 날짜 출력을 위함.
    public String getDate() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
