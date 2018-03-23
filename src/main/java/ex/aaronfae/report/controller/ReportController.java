package ex.aaronfae.report.controller;

import ex.aaronfae.report.dao.ReportRepository;
import ex.aaronfae.report.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/save")
    public String save(Report report, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("report", reportRepository.save(report));
        return "redirect:index";
    }
}
