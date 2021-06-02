package com.example.controller;

import com.example.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/dateFormat")
public class DateTimeFormatController {
    @Autowired
    DateService dateService;
   @PostMapping
    public String getDateFormat(@RequestParam String date) throws IOException {

        return dateService.getDateFormat(date);
    }

    @GetMapping
    public String justPrint(){
       return "hello";
    }
}
