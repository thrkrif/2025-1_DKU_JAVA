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
    
            while ((line = br.readLine()) != null) {
                try {
                    // 예: 2025-03-03 - Atka volcanic complex, Aviation Color Code: GREEN (view)
                    String[] dateAndRest = line.split(" - ", 2);
                    if (dateAndRest.length < 2) continue;
    
                    String date = dateAndRest[0].trim();
    
                    String[] nameAndCode = dateAndRest[1].split(", Aviation Color Code: ");
                    if (nameAndCode.length < 2) continue;
    
                    String name = nameAndCode[0].trim();
                    String colorCode = nameAndCode[1].replace("(view)", "").trim();
                    
                    // 실제로 없는 링크라서 데이터를 가져오지 못함.
                    String url = (date.replaceAll("-", "") + "-" + name.toLowerCase().replaceAll("[^a-z0-9]", "")).trim();
    
                    list.add(new Volcano(date, name, colorCode, url));
                } catch (Exception e) {
                    System.out.println("잘못된 줄: " + line);
                    // continue로 넘어감
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
