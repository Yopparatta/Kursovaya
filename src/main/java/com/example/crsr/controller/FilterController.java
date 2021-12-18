package com.example.crsr.controller;

import com.example.crsr.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FilterController {
    @Autowired
    private FilterService filterService;

    @RequestMapping("/filter/{field}")
    public String addFilter(@PathVariable String field) {
        filterService.addField(field);
        return "redirect:/";
    }

    @RequestMapping("/filter/removeAll")
    public String removeAllFilters() {
        filterService.removeAllFilters();
        return "redirect:/";
    }
}
