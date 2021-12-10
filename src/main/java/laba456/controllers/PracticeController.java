package laba456.controllers;

import laba456.dao.PracticeDAO;
import laba456.models.Practice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/practice")
public class PracticeController {
    private PracticeDAO practiceDAO;

    @Autowired
    public PracticeController(PracticeDAO practiceDAO) {
        this.practiceDAO = practiceDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("practices", practiceDAO.index());
        return "practices/index";
    }

    @GetMapping("/new")
    public String newPractice(@ModelAttribute("practice") Practice practice) {
        return "practices/new";
    }

    @PostMapping()
    public String create(@RequestParam("dateOfReceipt") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @ModelAttribute("practice") @Valid Practice practice,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "practices/new";
//        practice.setDateOfReceipt(date);
        practiceDAO.save(practice);
        return "redirect:/practice";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("practice", practiceDAO.show(id));
        return "practices/edit";
    }

    @PatchMapping("/{id}")
    public String update(@RequestParam("dateOfReceipt") @DateTimeFormat(pattern = "dd.MM.yyyy") Date date, @ModelAttribute("practice") @Valid Practice practice,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "practices/edit";
//        practice.setDateOfReceipt(date);
        practiceDAO.update(id, practice);
        return "redirect:/practice";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        practiceDAO.delete(id);
        return "redirect:/practice";
    }
}
