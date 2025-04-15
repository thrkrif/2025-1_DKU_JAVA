package kr.ac.dankook.ace.lab3.dao.dataimporter;


import kr.ac.dankook.ace.lab3.dao.parser.Parser;
import kr.ac.dankook.ace.lab3.dto.Earthquake;

import java.io.*;
import java.util.*;

public class EarthquakeDataImporter implements DataImporter<Earthquake> {
    private final Parser<Earthquake> parser;

    public EarthquakeDataImporter(Parser<Earthquake> parser) {
        this.parser = parser;
    }

    @Override
    // CSV 파일에서 Earthquake 리스트 불러오기
    public List<Earthquake> load(String filepath) {
        List<Earthquake> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            br.readLine(); // 첫 줄 스킵 (헤더)
            String line;
            while ((line = br.readLine()) != null) {                
                Earthquake v = parser.parse(line);
                if (v != null) list.add(v);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    // 정제된 CSV로 저장
    public void save(String filepath, List<Earthquake> earthquakes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            bw.write("Year,Month,Day,Location Name,Latitude,Longitude,Depth,Magnitude");
            bw.newLine();
            for (Earthquake eq : earthquakes) {
                bw.write(String.join(",",
                    String.valueOf(eq.getYear()),
                    String.valueOf(eq.getMonth()),
                    String.valueOf(eq.getDay()),
                    sanitize(eq.getLocationName()),
                    String.valueOf(eq.getLatitude()),
                    String.valueOf(eq.getLongitude()),
                    String.valueOf(eq.getDepth()),
                    String.valueOf(eq.getMagnitude())
                ));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 문자열 정제 (null 방지 + 큰 따옴표 제거)
    private String sanitize(String input) {
        if (input == null) return "";
        return input.replace("\"", "").trim();
    }
}

