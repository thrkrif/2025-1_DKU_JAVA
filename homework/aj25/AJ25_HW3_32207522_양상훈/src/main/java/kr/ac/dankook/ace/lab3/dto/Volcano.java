package kr.ac.dankook.ace.lab3.dto;

import lombok.Getter;
import lombok.Setter;

// Lombok 사용하여 getters and setters 생략
@Getter @Setter
public class Volcano {
    private int year;
    private int month;
    private int day;
    private String name;
    private String location;
    private String country;
    private int vei;

    // 정확한 날짜 출력을 위함.
    public String getDate() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
