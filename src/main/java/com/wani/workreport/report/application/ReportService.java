package com.wani.workreport.report.application;

import com.wani.workreport.member.domain.LoginMember;
import com.wani.workreport.report.dto.ReportRequest;
import com.wani.workreport.report.dto.ReportResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReportService {
    public ReportResponse createReport(LoginMember loginMember, ReportRequest request) {
        return null;
    }

    public List<ReportResponse> findReports(LoginMember loginMember) {
        return null;
    }

    public void deleteReports(LoginMember loginMember, Long id) {

    }
}
