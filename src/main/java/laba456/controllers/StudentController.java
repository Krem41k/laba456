package laba456.controllers;

import laba456.dao.StudentDAO;
import laba456.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("students", studentDAO.index());
        return "students/index";
    }

    @GetMapping("/new")
    public String newStudent(@ModelAttribute("student") Student student){
        return "students/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("student") @Valid Student student,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "students/new";

        studentDAO.save(student);
        return "redirect:/student";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("student", studentDAO.show(id));
        return "students/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student") @Valid Student student,
                         BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors())
            return "students/edit";

        studentDAO.update(id,student);
        return "redirect:/student";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        studentDAO.delete(id);
        return "redirect:/student";
    }
}
