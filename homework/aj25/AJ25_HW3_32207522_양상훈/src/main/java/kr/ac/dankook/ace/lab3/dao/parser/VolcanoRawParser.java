package kr.ac.dankook.ace.lab3.dao.parser;

import kr.ac.dankook.ace.lab3.dto.Volcano;


public class VolcanoRawParser implements Parser<Volcano> {

    @Override
    public Volcano parse(String line) {
        String[] tokens = line.split(",", -1);
        if (tokens.length < 14) return null;

        Volcano volcano = new Volcano();
        volcano.setYear(parseInt(tokens[1]));
        volcano.setMonth(parseInt(tokens[2]));
        volcano.setDay(parseInt(tokens[3]));
        volcano.setName(tokens[6]);
        volcano.setLocation(tokens[7]);
        volcano.setCountry(tokens[8]);
        volcano.setVei(parseInt(tokens[13]));

        return volcano;
    }

    private int parseInt(String s) {
        try { return Integer.parseInt(s.trim()); } catch (Exception e) { return -1; }
    }
}
