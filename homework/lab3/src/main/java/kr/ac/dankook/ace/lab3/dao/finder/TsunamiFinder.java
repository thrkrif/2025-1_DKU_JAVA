package kr.ac.dankook.ace.lab3.dao.finder;

import kr.ac.dankook.ace.lab3.dto.Tsunami;

import java.util.List;
import java.util.stream.Collectors;

public class TsunamiFinder {

    public List<Tsunami> findByYearRange(List<Tsunami> tsunamis, Integer minYear, Integer maxYear) {
        if (minYear == null && maxYear == null) return tsunamis;
        return tsunamis.stream()
                .filter(t -> (minYear == null || t.getYear() >= minYear))
                .filter(t -> (maxYear == null || t.getYear() <= maxYear))
                .collect(Collectors.toList());
    }

    public List<Tsunami> findByMaximumWaterHeightLessThan(List<Tsunami> tsunamis, Double maxWaterHeight) {
        if (maxWaterHeight == null) return tsunamis;
        return tsunamis.stream()
                .filter(t -> t.getMaximumWaterHeight() <= maxWaterHeight)
                .collect(Collectors.toList());
    }

    public List<Tsunami> findByCountryContains(List<Tsunami> tsunamis, String country) {
        if (country == null || country.isBlank()) return tsunamis;
        return tsunamis.stream()
                .filter(t -> t.getCountry() != null && t.getCountry().toLowerCase().contains(country.toLowerCase()))
                .collect(Collectors.toList());
    }


    public List<Tsunami> findByLocationNameContains(List<Tsunami> tsunamis, String locationName) {
        if (locationName == null || locationName.isBlank()) return tsunamis;
        return tsunamis.stream()
                .filter(t -> t.getLocationName() != null && t.getLocationName().toLowerCase().contains(locationName.toLowerCase()))
                .collect(Collectors.toList());
    }
}
