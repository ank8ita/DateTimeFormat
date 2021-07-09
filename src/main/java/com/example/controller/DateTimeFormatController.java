package com.example.controller;

import com.example.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/dateFormat")
public class DateTimeFormatController {
    @Autowired
    DateService dateService;

    @PostMapping
    public ResponseEntity<List<String>> getDateFormat(@RequestParam String date) throws IOException {

        return ResponseEntity.ok().body(dateService.getDateFormat(date));
    }

    @GetMapping
    public String justPrint() {
        return "hello";
    }
}
