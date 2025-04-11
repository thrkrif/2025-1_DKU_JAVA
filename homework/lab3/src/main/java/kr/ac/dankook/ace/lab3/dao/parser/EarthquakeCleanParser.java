package kr.ac.dankook.ace.lab3.dao.parser;

import kr.ac.dankook.ace.lab3.dto.Earthquake;

//그럼 CSV 포맷이 Year,Month,Day,locationName,Latitude,Longitude,Depth,Magnitude 이라고 가정하고 파서 만들자.
public class EarthquakeCleanParser implements Parser<Earthquake>{
    
    @Override
    public Earthquake parse(String line) {
        String[] tokens = line.split(",", -1);
        if (tokens.length < 8) return null; // 최소 필드 수

        Earthquake eq = new Earthquake();
        eq.setYear(parseInt(tokens[0]));
        eq.setMonth(parseInt(tokens[1]));
        eq.setDay(parseInt(tokens[2]));
        eq.setLocationName(tokens[3]);
        eq.setLatitude(parseDouble(tokens[4]));
        eq.setLongitude(parseDouble(tokens[5]));
        eq.setDepth(parseDouble(tokens[6]));
        eq.setMagnitude(parseDouble(tokens[7]));

        return eq;
    }

    private int parseInt(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return -1;
        }
    }

    private double parseDouble(String s) {
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception e) {
            return -1;
        }
    }
}
