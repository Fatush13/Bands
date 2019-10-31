package com.example.Bands.controller;

import com.example.Bands.domain.Band;
import com.example.Bands.repos.BandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class BandController {
    @Autowired
    private BandRepo bandRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/adding")
    public String adding() {
        return "adding";
    }

    @PostMapping("/adding")
    public String add(@RequestParam String name, @RequestParam String genre,
                      @RequestParam String origin, @RequestParam Integer foundation,
                      @RequestParam("file") MultipartFile file, Map<String, Object> model
    ) throws IOException {
        Band band = new Band(name, genre, origin, foundation);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            band.setFilename(resultFilename);
        }

        bandRepo.save(band);

        Iterable<Band> bands = bandRepo.findAll();

        model.put("bands", bands);

        return "main";
    }
}
