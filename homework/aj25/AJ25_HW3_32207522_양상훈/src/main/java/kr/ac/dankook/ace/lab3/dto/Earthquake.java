package kr.ac.dankook.ace.lab3.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Earthquake {
    private int year;
    private int month;
    private int day;
    private String locationName;
    private double latitude;
    private double longitude;
    private double depth;
    private double magnitude;

    // 정확한 날짜 출력을 위함.
    public String getDate() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
