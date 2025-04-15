package kr.ac.dankook.ace.lab3.service;

import jakarta.annotation.PostConstruct;
import kr.ac.dankook.ace.lab3.dao.dataimporter.DataImporter;
import kr.ac.dankook.ace.lab3.dao.dataimporter.TsunamiDataImporter;
import kr.ac.dankook.ace.lab3.dao.finder.TsunamiFinder;
import kr.ac.dankook.ace.lab3.dao.parser.TsunamiCleanParser;
import kr.ac.dankook.ace.lab3.dao.parser.TsunamiRawParser;
import kr.ac.dankook.ace.lab3.dto.Tsunami;
import kr.ac.dankook.ace.lab3.form.SearchForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TsunamiService {

    private final DataImporter<Tsunami> rawImporter = new TsunamiDataImporter(new TsunamiRawParser());
    private final DataImporter<Tsunami> cleanImporter = new TsunamiDataImporter(new TsunamiCleanParser());
    private final TsunamiFinder finder = new TsunamiFinder();

    private final String tsunamiCsvPath = "src/main/resources/static/data/tsunami.csv";
    private final String cleanCsvPath = "src/main/resources/static/data/tsunami_clean.csv";

    @PostConstruct
    public void init() {
        cleanTsunamiData();
    }

    // raw 데이터를 불러와 clean 데이터로 저장
    public void cleanTsunamiData() {
        List<Tsunami> rawList = rawImporter.load(tsunamiCsvPath);
        cleanImporter.save(cleanCsvPath, rawList);
    }

    // 정제된 데이터 기준으로 검색
    public List<Tsunami> search(SearchForm form) {
        List<Tsunami> tsunamis = cleanImporter.load(cleanCsvPath);

        tsunamis = finder.findByYearRange(tsunamis, form.getMinYear(), form.getMaxYear());
        tsunamis = finder.findByMaximumWaterHeightLessThan(tsunamis, form.getMaximumWaterHeight());
        tsunamis = finder.findByCountryContains(tsunamis, form.getCountry());
        tsunamis = finder.findByLocationNameContains(tsunamis, form.getLocationName());
        
        return tsunamis;
    }
}
