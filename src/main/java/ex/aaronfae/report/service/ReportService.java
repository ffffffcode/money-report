package ex.aaronfae.report.service;

import ex.aaronfae.report.entity.Report;
import ex.aaronfae.report.vo.ReportVO;

import java.util.List;

public interface ReportService {
    void save(ReportVO reportVO);

    List<ReportVO> list();
}
