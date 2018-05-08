package ex.aaronfae.report.service.impl;

import ex.aaronfae.report.dao.ReportRepository;
import ex.aaronfae.report.dao.UsersRepository;
import ex.aaronfae.report.entity.Report;
import ex.aaronfae.report.service.ReportService;
import ex.aaronfae.report.vo.ReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, UsersRepository usersRepository) {
        this.reportRepository = reportRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public void save(ReportVO reportVO) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date contributingTime = null;
        try {
            contributingTime = simpleDateFormat.parse(reportVO.getContributingTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Report report = new Report(null, reportVO.getRealName(), reportVO.getPrice(), contributingTime, new Date(System.currentTimeMillis()), null, reportVO.getIntention());
        reportRepository.save(report);
    }

    @Override
    public List<ReportVO> list() {
        List<ReportVO> reportVOList = new ArrayList<>();
        List<Report> reportList = reportRepository.findAll();
        for (Report report : reportList) {
            reportVOList.add(new ReportVO(report.getRealName(), report.getPrice(), new SimpleDateFormat("yyyy-MM-dd").format(report.getContributingTime()), report.getIntention()));
        }
        return reportVOList;
    }
}
