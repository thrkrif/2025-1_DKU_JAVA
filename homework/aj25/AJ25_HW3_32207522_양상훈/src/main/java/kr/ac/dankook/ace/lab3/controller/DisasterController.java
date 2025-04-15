package kr.ac.dankook.ace.lab3.controller;

import kr.ac.dankook.ace.lab3.dto.*;
import kr.ac.dankook.ace.lab3.form.SearchForm;
import kr.ac.dankook.ace.lab3.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class DisasterController {
    private final VolcanoService volcanoService;
    private final EarthquakeService earthquakeService;
    private final TsunamiService tsunamiService;

    @GetMapping("/")
    public String home() {
        return "lab3";
    }
    
    // Volcano 검색폼 페이지
    @GetMapping("/volcano")
    public String showVolcanoForm(Model model) {
        SearchForm form = new SearchForm();
        form.setDisasterType("volcano");
        model.addAttribute("searchForm", form);
        return "form";  // form.html
    }

    // Volcano 검색 결과 처리
    @PostMapping("/search/volcano")
    public String searchVolcano(@ModelAttribute("searchForm") SearchForm form, Model model) {
        List<Volcano> results = volcanoService.search(form);
        model.addAttribute("searchForm", form);
        model.addAttribute("results", results);
        return "form"; // 결과도 같은 페이지에 출력
    }

    // Earthquake 검색폼 페이지
    @GetMapping("/earthquake")
    public String showEarthquakeForm(Model model) {
        SearchForm form = new SearchForm();
        form.setDisasterType("earthquake");
        model.addAttribute("searchForm", form);
        return "form";
    }
 
    // Earthquake 검색 결과 처리
    @PostMapping("/search/earthquake")
    public String searchEarthquake(@ModelAttribute("searchForm") SearchForm form, Model model) {
        List<Earthquake> results = earthquakeService.search(form);
        model.addAttribute("searchForm", form);
        model.addAttribute("results", results);
        return "form";
    }

    // Tsunami 검색폼 페이지 -> dto 쓰나미의 필드 데이터를 form.html에 searchForm 이라는 이름으로 넘긴다.
    @GetMapping("/tsunami")
    public String showTsunamiForm(Model model) {
        SearchForm form = new SearchForm();
        form.setDisasterType("tsunami");
        model.addAttribute("searchForm", form);
        return "form";  // form.html
    }

    // Tsunami 검색 결과 처리
    @PostMapping("/search/tsunami")
    public String searchTsunami(@ModelAttribute("searchForm") SearchForm form, Model model) {
        List<Tsunami> results = tsunamiService.search(form);
        model.addAttribute("searchForm", form);
        model.addAttribute("results", results);
        return "form";
    }
    
}
