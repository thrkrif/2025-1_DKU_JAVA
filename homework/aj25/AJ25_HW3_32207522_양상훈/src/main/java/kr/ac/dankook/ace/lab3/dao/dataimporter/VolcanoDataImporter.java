package kr.ac.dankook.ace.lab3.dao.dataimporter;
import kr.ac.dankook.ace.lab3.dao.parser.Parser;
import kr.ac.dankook.ace.lab3.dto.Volcano;

import java.io.*;
import java.util.*;

public class VolcanoDataImporter implements DataImporter<Volcano> {
    private final Parser<Volcano> parser;

    public VolcanoDataImporter(Parser<Volcano> parser) {
        this.parser = parser;
    }

    @Override
    //csv 파일 가져오기
    public List<Volcano> load(String filepath) {
        List<Volcano> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            br.readLine(); // 첫 줄 스킵 (헤더)
            String line;
            while ((line = br.readLine()) != null) {
                    Volcano v = parser.parse(line);
                    if (v != null) list.add(v);
            }          
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    // 정제된 CSV로 저장
    public void save(String filepath, List<Volcano> volcanoes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            bw.write("Year,Month,Day,Name,Location,Country,Vei");
            bw.newLine();
            for (Volcano v : volcanoes) {
                bw.write(String.join(",",
                    String.valueOf(v.getYear()),
                    String.valueOf(v.getMonth()),
                    String.valueOf(v.getDay()),
                    sanitize(v.getName()),
                    sanitize(v.getLocation()),
                    sanitize(v.getCountry()),
                    String.valueOf(v.getVei())
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
