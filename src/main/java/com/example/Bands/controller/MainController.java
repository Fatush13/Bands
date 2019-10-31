package com.example.Bands.controller;

import com.example.Bands.domain.Band;
import com.example.Bands.repos.BandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private BandRepo bandRepo;

    @GetMapping("/")
    public String greeting(
            Map<String, Object> model
    ) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Model model) {
        Iterable<Band> bands = bandRepo.findAll();

        model.addAttribute("bands", bands);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model) {
        Iterable<Band> bands;

        if (filter != null && !filter.isEmpty()) {
            bands = bandRepo.findByName(filter);
        } else {
            bands = bandRepo.findAll();
        }

        model.addAttribute("bands", bands);

        return "main";
    }
}
