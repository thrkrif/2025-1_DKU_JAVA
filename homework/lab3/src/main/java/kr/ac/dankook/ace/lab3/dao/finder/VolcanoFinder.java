package kr.ac.dankook.ace.lab3.dao.finder;

import kr.ac.dankook.ace.lab3.dto.Volcano;
import java.util.List;
import java.util.stream.Collectors;

// 사용자가 입력하지 않거나 null인 경우 넘어감.
public class VolcanoFinder {

    public List<Volcano> findByYearRange(List<Volcano> volcanoes, Integer minYear, Integer maxYear) {
        if (minYear == null && maxYear == null) return volcanoes;
        return volcanoes.stream()
                .filter(v -> (minYear == null || v.getYear() >= minYear))
                .filter(v -> (maxYear == null || v.getYear() <= maxYear))
                .collect(Collectors.toList());
    }

    public List<Volcano> findByVEIRange(List<Volcano> volcanoes, Integer minVei, Integer maxVei) {
        if (minVei == null && maxVei == null) return volcanoes;
        return volcanoes.stream()
                .filter(v -> (minVei == null || v.getVei() >= minVei))
                .filter(v -> (maxVei == null || v.getVei() <= maxVei))
                .collect(Collectors.toList());
    }

    public List<Volcano> findByCountry(List<Volcano> volcanoes, String country) {
        if (country == null || country.isBlank()) return volcanoes;
        return volcanoes.stream()
                .filter(v -> v.getCountry().toLowerCase().contains(country.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Volcano> findByLocationContains(List<Volcano> volcanoes, String location) {
        if (location == null || location.isBlank()) return volcanoes;
        return volcanoes.stream()
                .filter(v -> v.getLocation().toLowerCase().contains(location.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Volcano> findByNameContains(List<Volcano> volcanoes, String name) {
        if (name == null || name.isBlank()) return volcanoes;
        return volcanoes.stream()
                .filter(v -> v.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
