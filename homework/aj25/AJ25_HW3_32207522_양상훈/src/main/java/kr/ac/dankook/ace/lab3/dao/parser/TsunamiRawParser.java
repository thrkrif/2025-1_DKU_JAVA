package kr.ac.dankook.ace.lab3.dao.parser;

import kr.ac.dankook.ace.lab3.dto.Tsunami;

public class TsunamiRawParser implements Parser<Tsunami> {

    @Override
    public Tsunami parse(String line) {
        String[] tokens = line.split(",", -1);
        if (tokens.length < 19) return null;

        Tsunami ts = new Tsunami();
        ts.setYear(parseInt(tokens[1]));                    
        ts.setMonth(parseInt(tokens[2]));                   
        ts.setDay(parseInt(tokens[3]));                     
        ts.setCountry(tokens[13]);                          
        ts.setEventValidity(tokens[7]);                     
        ts.setCauseCode(tokens[8]);                         
        ts.setLocationName(tokens[14]);                     
        ts.setLatitude(parseDouble(tokens[15]));            
        ts.setLongitude(parseDouble(tokens[16]));           
        ts.setMaximumWaterHeight(parseDouble(tokens[17]));  
        ts.setNumberOfRunups(parseInt(tokens[18]));         

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
