package com.wani.workreport.report.ui;

import com.wani.workreport.auth.domain.AuthenticationPrincipal;
import com.wani.workreport.member.domain.LoginMember;
import com.wani.workreport.report.application.ReportService;
import com.wani.workreport.report.domain.ReportRepository;
import com.wani.workreport.report.dto.ReportRequest;
import com.wani.workreport.report.dto.ReportResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/reports")
    public ResponseEntity createReport(@AuthenticationPrincipal LoginMember loginMember, @RequestBody ReportRequest request) {
        ReportResponse report = reportService.createReport(loginMember, request);
        return ResponseEntity.created(URI.create("/reports" + report.getId())).build();
    }

    @GetMapping("/reports")
    public ResponseEntity<List<ReportResponse>> getReports(@AuthenticationPrincipal LoginMember loginMember){
        List<ReportResponse> reports = reportService.findReports(loginMember);
        return ResponseEntity.ok().body(reports);
    }

    @DeleteMapping("/reports/{id}")
    public ResponseEntity deleteReports(@AuthenticationPrincipal LoginMember loginMember , @PathVariable Long id){

        reportService.deleteReports(loginMember , id);
        return ResponseEntity.noContent().build();
    }
}
