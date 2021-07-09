package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DateService {
    @Autowired
    ResourceLoader resourceLoader;

    public List<String> getDateFormat(String date) throws IOException {

        List<String> format = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat();
        Resource resource = resourceLoader.getResource("classpath:" + File.separator + "dateFormat.txt");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        String line = bufferedReader.readLine();
        while (line != null) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(line);
            if (isCorrectFormat(date, dateFormat) && !format.contains(line)) format.add(line);
            if (getDateBySDF(date, sdf, line) && !format.contains(line)) format.add(line);
            line = bufferedReader.readLine();
        }
        return format.isEmpty() ? Collections.singletonList("No Format found") : format;
    }

    private boolean getDateBySDF(String date, SimpleDateFormat sdf, String s) {
        sdf.applyPattern(s);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean isCorrectFormat(String date, DateTimeFormatter dateFormat) {

        try {
            System.out.println(dateFormat.parse(date));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(LocalDate.now());

    }


}
