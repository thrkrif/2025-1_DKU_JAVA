package kr.ac.dankook.ace.lab3.dao.parser;

import kr.ac.dankook.ace.lab3.dto.Tsunami;

public class TsunamiCleanParser implements Parser<Tsunami> {

    @Override
    public Tsunami parse(String line) {
        String[] tokens = line.split(",", -1);
        if (tokens.length < 11) return null;

        Tsunami ts = new Tsunami();
        ts.setYear(parseInt(tokens[0]));
        ts.setMonth(parseInt(tokens[1]));
        ts.setDay(parseInt(tokens[2]));
        ts.setCountry(tokens[3]);
        ts.setEventValidity(tokens[4]);
        ts.setCauseCode(tokens[5]);
        ts.setLocationName(tokens[6]);
        ts.setLatitude(parseDouble(tokens[7]));
        ts.setLongitude(parseDouble(tokens[8]));
        ts.setMaximumWaterHeight(parseDouble(tokens[9]));
        ts.setNumberOfRunups(parseInt(tokens[10]));

        return ts;
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

