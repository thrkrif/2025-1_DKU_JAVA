package kr.ac.dankook.ace.lab3.dao.parser;

import kr.ac.dankook.ace.lab3.dto.Earthquake;

public class EarthquakeRawParser implements Parser<Earthquake> {

    @Override
    public Earthquake parse(String line) {
        String[] tokens = line.split(",", -1);
        if (tokens.length < 14) return null;

        Earthquake eq = new Earthquake();            
        eq.setYear(parseInt(tokens[1]));            
        eq.setMonth(parseInt(tokens[2]));           
        eq.setDay(parseInt(tokens[3])); 
        eq.setLocationName(tokens[9]); 
        eq.setLatitude(parseDouble(tokens[10])); 
        eq.setLongitude(parseDouble(tokens[11])); 
        eq.setDepth(parseDouble(tokens[12])); 
        eq.setMagnitude(parseDouble(tokens[13]));

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
            return -1.0;
        }
    }
}
