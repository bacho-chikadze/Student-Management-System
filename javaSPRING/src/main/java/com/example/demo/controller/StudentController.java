
package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
@Controller -> HTML გვერდები
*/

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    // მთავარი გვერდი
    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("student", new Student());

        model.addAttribute("students", service.findAll());

        return "form";
    }

    /*
    POST request ფორმიდან
    */
    @PostMapping("/save")
    public String save(
            @Valid @ModelAttribute Student student,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ){

        // validation error
        if(result.hasErrors()){
            return "form";
        }

        service.save(student);

        /*
        PRG Pattern
        */
        redirectAttributes.addFlashAttribute("success", "Student Saved");

        return "redirect:/";
    }

    // File Upload
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){

        System.out.println(file.getOriginalFilename());

        return "redirect:/";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){

        service.delete(id);

        return "redirect:/";
    }
}
