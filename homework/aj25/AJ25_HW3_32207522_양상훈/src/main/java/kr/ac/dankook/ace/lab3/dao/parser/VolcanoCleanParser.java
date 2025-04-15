package kr.ac.dankook.ace.lab3.dao.parser;

import kr.ac.dankook.ace.lab3.dto.Volcano;

public class VolcanoCleanParser implements Parser<Volcano> {

    @Override
    public Volcano parse(String line) {
        String[] tokens = line.split(",");
        if (tokens.length < 7) return null;

        Volcano volcano = new Volcano();
        volcano.setYear(parseInt(tokens[0]));
        volcano.setMonth(parseInt(tokens[1]));
        volcano.setDay(parseInt(tokens[2]));
        volcano.setName(tokens[3]);
        volcano.setLocation(tokens[4]);
        volcano.setCountry(tokens[5]);
        volcano.setVei(parseInt(tokens[6]));

        return volcano;
    }

    private int parseInt(String s) {
        try { return Integer.parseInt(s.trim()); } catch (Exception e) { return -1; }
    }


}
