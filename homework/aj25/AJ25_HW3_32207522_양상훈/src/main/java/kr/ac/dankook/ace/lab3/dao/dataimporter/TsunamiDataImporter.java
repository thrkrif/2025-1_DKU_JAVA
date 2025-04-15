
package kr.ac.dankook.ace.lab3.dao.dataimporter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.dankook.ace.lab3.dao.parser.Parser;
import kr.ac.dankook.ace.lab3.dto.Tsunami;

public class TsunamiDataImporter implements DataImporter<Tsunami> {

    private final Parser<Tsunami> parser;

    public TsunamiDataImporter(Parser<Tsunami> parser){
        this.parser = parser;
    }

    @Override
    //csv 파일 가져오기
    public List<Tsunami> load(String filepath) {
        List<Tsunami> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            br.readLine(); // 첫 줄 스킵 (헤더)
            String line;
            while ((line = br.readLine()) != null) {
                Tsunami t = parser.parse(line);
                if (t != null) list.add(t);
            }          
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    // 정제된 CSV로 저장
    public void save(String filepath, List<Tsunami> tsunamis) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            bw.write("Year,Month,Day,Location Name,Country,Event Validity,Cause Code,Latitude,Longitude,Maximum Water Height,Number Of Runups");
            bw.newLine();
            for (Tsunami t : tsunamis) {
                bw.write(String.join(",",
                    String.valueOf(t.getYear()),
                    String.valueOf(t.getMonth()),
                    String.valueOf(t.getDay()),
                    sanitize(t.getLocationName()),
                    sanitize(t.getCountry()),
                    sanitize(t.getEventValidity()),
                    sanitize(t.getCauseCode()),                    
                    String.valueOf(t.getLatitude()),
                    String.valueOf(t.getLongitude()),
                    String.valueOf(t.getMaximumWaterHeight()),
                    String.valueOf(t.getNumberOfRunups())
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
        return input.replace("\"", "");
    }
}

    