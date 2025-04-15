package kr.ac.dankook.ace.lab3.form;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchForm {
    private String disasterType; // volcano, earthquake, tsunami 구분

    // 공통 필드
    private Integer minYear;
    private Integer maxYear;

    // volcano, tsunami 공통 필드
    private String country;
    private String location;
    private String name;

    // earthquake, tsunami 공통 필드
    private String locationName;

    // volcano 전용 필드
    private Integer minVei;
    private Integer maxVei;

    // earthquake 전용 필드
    private Double minMagnitude;
    private Double maxMagnitude;
    private Double maxDepth;

    // tsunami 전용 필드
    private Double maximumWaterHeight;
}

