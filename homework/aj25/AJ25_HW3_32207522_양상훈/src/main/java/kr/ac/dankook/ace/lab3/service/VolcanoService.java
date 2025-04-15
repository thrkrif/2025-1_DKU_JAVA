package kr.ac.dankook.ace.lab3.service;

import kr.ac.dankook.ace.lab3.dao.dataimporter.DataImporter;
import kr.ac.dankook.ace.lab3.dao.dataimporter.VolcanoDataImporter;
import kr.ac.dankook.ace.lab3.dao.finder.VolcanoFinder;
import kr.ac.dankook.ace.lab3.dao.parser.VolcanoCleanParser;
import kr.ac.dankook.ace.lab3.dao.parser.VolcanoRawParser;
import kr.ac.dankook.ace.lab3.dto.Volcano;
import kr.ac.dankook.ace.lab3.form.SearchForm;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class VolcanoService {

    // raw 파서를 이용해서 raw 데이터를 정제
    private final DataImporter<Volcano> rawImporter = new VolcanoDataImporter(new VolcanoRawParser());

    // clean 파서로 정제된 csv 데이터를 다시 로드
    private final DataImporter<Volcano> cleanImporter = new VolcanoDataImporter(new VolcanoCleanParser());

    private final VolcanoFinder finder = new VolcanoFinder();

    private final String volcanoCsvPath = "src/main/resources/static/data/volcano.csv";
    private final String cleanCsvPath = "src/main/resources/static/data/volcano_clean.csv";

    @PostConstruct
    public void init() {
        cleanVolcanoData();
    }

    public void cleanVolcanoData() {
        List<Volcano> rawList = rawImporter.load(volcanoCsvPath);
        cleanImporter.save(cleanCsvPath, rawList);
    }

    public List<Volcano> search(SearchForm form) {
        List<Volcano> volcanoes = cleanImporter.load(cleanCsvPath);

        volcanoes = finder.findByYearRange(volcanoes, form.getMinYear(), form.getMaxYear());
        volcanoes = finder.findByVEIRange(volcanoes, form.getMinVei(), form.getMaxVei());
        volcanoes = finder.findByCountry(volcanoes, form.getCountry());
        volcanoes = finder.findByLocationContains(volcanoes, form.getLocation());
        volcanoes = finder.findByNameContains(volcanoes, form.getName());

        return volcanoes;
    }
}