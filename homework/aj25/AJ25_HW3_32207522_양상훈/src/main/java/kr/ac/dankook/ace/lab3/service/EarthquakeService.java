package kr.ac.dankook.ace.lab3.service;

import kr.ac.dankook.ace.lab3.dao.dataimporter.DataImporter;
import kr.ac.dankook.ace.lab3.dao.dataimporter.EarthquakeDataImporter;
import kr.ac.dankook.ace.lab3.dao.finder.EarthquakeFinder;
import kr.ac.dankook.ace.lab3.dao.parser.EarthquakeRawParser;
import kr.ac.dankook.ace.lab3.dao.parser.EarthquakeCleanParser;
import kr.ac.dankook.ace.lab3.dto.Earthquake;
import kr.ac.dankook.ace.lab3.form.SearchForm;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class EarthquakeService {

    // raw 파서를 이용해 원본 데이터를 정제
    private final DataImporter<Earthquake> rawImporter = new EarthquakeDataImporter(new EarthquakeRawParser());

    // 정제된 csv를 불러올 때 사용하는 clean 파서
    private final EarthquakeDataImporter cleanImporter = new EarthquakeDataImporter(new EarthquakeCleanParser());

    private final EarthquakeFinder finder = new EarthquakeFinder();

    private final String earthquakeCsvPath = "src/main/resources/static/data/earthquake.csv";
    private final String cleanCsvPath = "src/main/resources/static/data/earthquake_clean.csv";

    @PostConstruct
    public void init() {
        cleanEarthquakeData();
    }

    // raw 데이터를 불러와 clean 데이터로 저장
    public void cleanEarthquakeData() {
        List<Earthquake> rawList = rawImporter.load(earthquakeCsvPath);
        cleanImporter.save(cleanCsvPath, rawList);
    }

    // 정제된 데이터 기준으로 검색
    public List<Earthquake> search(SearchForm form) {
        List<Earthquake> earthquakes = cleanImporter.load(cleanCsvPath);

        earthquakes = finder.findByYearRange(earthquakes, form.getMinYear(), form.getMaxYear());
        earthquakes = finder.findByMagnitudeGreaterThan(earthquakes, form.getMinMagnitude());
        earthquakes = finder.findByLocationContains(earthquakes, form.getLocation());
        earthquakes = finder.findByDepthLessThan(earthquakes, form.getMaxDepth());

        return earthquakes;
    }
}
