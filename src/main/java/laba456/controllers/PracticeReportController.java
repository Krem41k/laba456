package laba456.controllers;

import laba456.dao.PracticeReportDAO;
import laba456.models.PracticeReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/practiceReport")
public class PracticeReportController {
    private PracticeReportDAO practiceReportDAO;

    @Autowired
    public PracticeReportController(PracticeReportDAO practiceReportDAO){
        this.practiceReportDAO = practiceReportDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("practiceReports", practiceReportDAO.index());
        return "practiceReports/index";
    }
    @GetMapping("/new")
    public String newPractice(@ModelAttribute("practiceReport") PracticeReport practiceReport){
        return "practiceReports/new";
    }

    @PostMapping()
    public String create(@RequestParam("expirationDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date date,@ModelAttribute("practiceReport") @Valid PracticeReport practiceReport,
                         BindingResult bindingResult){
//        if(bindingResult.hasErrors())
//            return "practiceReports/new";
        practiceReport.setExpirationDate(date);
        practiceReportDAO.save(practiceReport);
        return "redirect:/practiceReport";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("practiceReport", practiceReportDAO.show(id));
        return "practiceReports/edit";
    }

    @PatchMapping("/{id}")
    public String update(@RequestParam("expirationDate") @DateTimeFormat(pattern="dd.MM.yyyy") Date date,@ModelAttribute("practiceReport") @Valid PracticeReport practiceReport,
                         BindingResult bindingResult, @PathVariable("id") int id){
//        if(bindingResult.hasErrors())
//            return "practices/edit";
        practiceReport.setExpirationDate(date);
        practiceReportDAO.update(id,practiceReport);
        return "redirect:/practiceReport";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        practiceReportDAO.delete(id);
        return "redirect:/practiceReport";
    }
}
