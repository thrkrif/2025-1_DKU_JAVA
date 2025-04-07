package kr.ac.dankook.ace.lab2.controller;

import kr.ac.dankook.ace.lab2.model.*;
import kr.ac.dankook.ace.lab2.service.DisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class DisasterController {

    @Autowired
    private DisasterService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("type", "none");
        return "lab2";
    }

    @GetMapping("/list/{type}")
    public String showList(@PathVariable String type, Model model) throws IOException {
        if (type.equals("volcano")) {
            List<Volcano> volcanoes = service.fetchVolcanoData();
            model.addAttribute("data", volcanoes);
            model.addAttribute("type", "volcano");
        } else if (type.equals("earthquake")) {
            List<Earthquake> earthquakes = service.fetchEarthquakeData();
            model.addAttribute("data", earthquakes);
            model.addAttribute("type", "earthquake");
        }
        return "lab2";
    }
    
    // Earthquake일 경우: url, type만 전달되니까 기존처럼 iframe에 링크 띄워짐
    // Volcano일 경우: name, date, colorCode까지 전달되니까 텍스트 + 검색 버튼으로 보여줌
    @GetMapping("/detail")
    public String showDetail(@RequestParam String url,
                         @RequestParam String type,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) String date,
                         @RequestParam(required = false) String colorCode,
                         @RequestParam(required = false) Double magnitude,
                         Model model) 
    {
        model.addAttribute("link", url);
        model.addAttribute("type", type);

        // Volcano 데이터용 (지진일 땐 null이어도 문제 없음)
        model.addAttribute("name", name);
        model.addAttribute("date", date);
        model.addAttribute("colorCode", colorCode);
        model.addAttribute("magnitude", magnitude);

        return "detailView";
    }
}