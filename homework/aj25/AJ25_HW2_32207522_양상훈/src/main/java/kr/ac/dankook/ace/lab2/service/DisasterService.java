package kr.ac.dankook.ace.lab2.service;

import kr.ac.dankook.ace.lab2.model.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DisasterService {

    public List<Volcano> fetchVolcanoData() throws IOException {
        List<Volcano> list = new ArrayList<>();
        String csvPath = "src/main/resources/static/data/volcano.csv";
    
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line;
            boolean isFirst = true;
    
            while ((line = br.readLine()) != null) {
                if (isFirst) {
                    isFirst = false; // 헤더 건너뛰기
                    continue;
                }
    
                String[] tokens = line.split(",", -1);
    
                // volcano.csv는 컬럼이 13개임
                if (tokens.length == 13) {
                    String name = tokens[0];
                    String date = tokens[2];
                    String alertLevel = tokens[4];
                    String color = tokens[5];
                    String url = tokens[11]; // 실제 링크
    
                    list.add(new Volcano(date, name, alertLevel, color, url));
                }
            }
        }
        return list;
    }

    public List<Earthquake> fetchEarthquakeData() throws IOException {
        List<Earthquake> list = new ArrayList<>();
        String csvPath = "src/main/resources/static/data/earthquake.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line;
            boolean isFirst = true;

            while ((line = br.readLine()) != null) {
                if (isFirst) {
                    isFirst = false; // 헤더는 건너뛰기
                    continue;
                }

                String[] tokens = line.split(",", -1); // 공백도 포함
                
                // earthquake.csv 파일 헤더를 보면 컬럼이 22개이다. 
                // row 중에서 컬럼이 22개인것만 파싱하고 나머지는 넘어감.
                if (tokens.length == 22) { 
                    String time = tokens[0];
                    double magnitude;
                    try {
                        magnitude = Double.parseDouble(tokens[4]);
                    } catch (NumberFormatException e) {
                        continue; // 잘못된 숫자는 스킵
                    }

                    String place = tokens[13].replaceAll("^\"|\"$", ""); // 큰따옴표 제거
                    String url = "https://earthquake.usgs.gov/earthquakes/eventpage/" + tokens[11]; // id로 링크 생성

                    list.add(new Earthquake(place, time, magnitude, url));
                }
            }
        }
        return list;
    }
}
