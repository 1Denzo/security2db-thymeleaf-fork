package ru.urfu.testsecurity2dbthymeleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.urfu.testsecurity2dbthymeleaf.entity.Motobike;
import ru.urfu.testsecurity2dbthymeleaf.repository.MotobikeRepository;

import java.util.Optional;

@Slf4j
@Controller
public class MotobikeController {
    @Autowired
    private MotobikeRepository motobikeRepository;

    @GetMapping("/list")
    public ModelAndView getAllMotobike() {
        log.info("/list -> connection");
        ModelAndView mav = new ModelAndView("list-motobikes");
        mav.addObject("motobikes", motobikeRepository.findAll());
        return mav;
    }

    @GetMapping("/list/addMotobikeForm")
    public ModelAndView addStudentForm() {
        ModelAndView mav = new ModelAndView("add-motobike-form");
        Motobike motobike = new Motobike();
        mav.addObject("motobike", motobike);
        return mav;
    }

    @PostMapping("/list/saveMotobike")
    public String saveMotobike(@ModelAttribute Motobike motobike) {
        motobikeRepository.save(motobike);
        return "redirect:/list";
    }

    @GetMapping("/list/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long motobikeId) {
        ModelAndView mav = new ModelAndView("add-motobike-form");
        Optional<Motobike> optionalMotobike = motobikeRepository.findById(motobikeId);
        Motobike motobike = new Motobike();
        if (optionalMotobike.isPresent()) {
            motobike = optionalMotobike.get();
        }
        mav.addObject("motobike", motobike);
        return mav;
    }

    @GetMapping("/list/deleteMotobike")
    public String deleteStudent(@RequestParam Long motobikeId) {
        motobikeRepository.deleteById(motobikeId);
        return "redirect:/list";
    }
}

