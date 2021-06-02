package com.example.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@Service
public class DateService {

    public String getDateFormat(String date) throws IOException {

        SimpleDateFormat sdf = new SimpleDateFormat();
        URL resource = getClass().getClassLoader().getResource("dateFormat.txt");
        BufferedReader bufferedReader = null;
        if (resource != null) {
            bufferedReader = new BufferedReader(new FileReader(resource.getPath()));
            String line = bufferedReader.readLine();
            while (line != null) {
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(line);
                if (isCorrectFormat(date, dateFormat)) return line;
                if (getDateBySDF(date, sdf, line)) return line;
                line = bufferedReader.readLine();
            }
        }


        return "No Format found";

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

    public static void main(String[] args) throws IOException {
        DateService dateService = new DateService();
        System.out.println(dateService.getDateFormat("2019-02-20"));

    }

}
