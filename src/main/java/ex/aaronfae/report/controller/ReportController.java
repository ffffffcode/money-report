package ex.aaronfae.report.controller;

import ex.aaronfae.report.service.ReportService;
import ex.aaronfae.report.vo.ReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;
    @Autowired
    private MessageSource messageSource;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping("/save")
    public ModelAndView save(@Valid ReportVO reportVO, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("index");
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            Locale locale = LocaleContextHolder.getLocale();
            List<String> errorList = new ArrayList<>();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError);
                errorList.add(messageSource.getMessage(fieldError, locale));
            }
            modelAndView.addObject("errorList", errorList);
            return modelAndView;
        }
        reportService.save(reportVO);
        return modelAndView;
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("report");
        mv.addObject("list", reportService.list());
        return mv;
    }
}
