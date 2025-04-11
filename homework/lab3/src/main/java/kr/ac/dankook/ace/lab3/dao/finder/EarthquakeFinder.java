package kr.ac.dankook.ace.lab3.dao.finder;

import kr.ac.dankook.ace.lab3.dto.Earthquake;

import java.util.List;
import java.util.stream.Collectors;

public class EarthquakeFinder {

    public List<Earthquake> findByYearRange(List<Earthquake> earthquakes, Integer minYear, Integer maxYear) {
        if (minYear == null && maxYear == null) return earthquakes;
        return earthquakes.stream()
                .filter(e -> (minYear == null || e.getYear() >= minYear))
                .filter(e -> (maxYear == null || e.getYear() <= maxYear))
                .collect(Collectors.toList());
    }

    public List<Earthquake> findByMagnitudeGreaterThan(List<Earthquake> earthquakes, Double minMagnitude) {
        if (minMagnitude == null) return earthquakes;
        return earthquakes.stream()
                .filter(e -> (minMagnitude == null || e.getMagnitude() >= minMagnitude))
                .collect(Collectors.toList());
    }

    
    public List<Earthquake> findByDepthLessThan(List<Earthquake> earthquakes, Double maxDepth) {
        if (maxDepth == null) return earthquakes;
        return earthquakes.stream()
                .filter(e -> (maxDepth == null || e.getDepth() <= maxDepth))
                .collect(Collectors.toList());
    }

    public List<Earthquake> findByLocationContains(List<Earthquake> earthquakes, String location) {
        if (location == null || location.isBlank()) return earthquakes;
        return earthquakes.stream()
                .filter(e -> e.getLocationName().toLowerCase().contains(location.toLowerCase()))
                .collect(Collectors.toList());
    }
}
