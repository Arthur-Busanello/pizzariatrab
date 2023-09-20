package org.example.Controller;

import org.example.Entity.Report;
import org.example.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Controller
@RestController
@RequestMapping("/Report")
public class ReportController {
    @Autowired
    private ReportService service;

    @GetMapping( "/Period")

    private ResponseEntity<Report> periodReport (@RequestParam String day1, String day2) {
        LocalDate start = LocalDate.parse(day1);
        LocalDate end = LocalDate.parse(day1);
        return service.GetReport(start,end);

    }

    @GetMapping ( "/day")

    private ResponseEntity<Report> periodReport ( @RequestParam String day1) {
        LocalDate day = LocalDate.parse(day1);
        return service.GetReportDay(day);
    }
}
