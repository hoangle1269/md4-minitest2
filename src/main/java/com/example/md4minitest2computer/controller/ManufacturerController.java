package com.example.md4minitest2computer.controller;

import com.example.md4minitest2computer.model.Computer;
import com.example.md4minitest2computer.model.DTO.ICountManufacturer;
import com.example.md4minitest2computer.model.Manufacturer;
import com.example.md4minitest2computer.service.IManufacturerService;
import com.example.md4minitest2computer.service.impl.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    private IManufacturerService manufacturerService;

    @Autowired
    private ComputerService computerService;

    @GetMapping("")
    public String index(Model model) {
        Iterable<Manufacturer> manufacturerList = manufacturerService.findAll();
        model.addAttribute("manufacturerList", manufacturerList);
        return "/manufacturer/index";
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/manufacturer/create");
        modelAndView.addObject("manufacturer", new Manufacturer());
        return modelAndView;
    }

    //
    @PostMapping("/create")
    public String create(@ModelAttribute("province") Manufacturer manufacturer,
                         RedirectAttributes redirectAttributes) {
        manufacturerService.save(manufacturer);
        redirectAttributes.addFlashAttribute("message", "Create new manufacturer successfully");
        return "redirect:/manufacturers";
    }


    @GetMapping("/update/{manufacturerId}")
    public ModelAndView updateForm (@PathVariable Long manufacturerId){
        Optional<Manufacturer> manufacturer = manufacturerService.findById(manufacturerId);
        if (manufacturer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/manufacturer/update");
            modelAndView.addObject("manufacturer", manufacturer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update (@ModelAttribute("province") Manufacturer manufacturer,
                          RedirectAttributes redirect){
        manufacturerService.save(manufacturer);
        redirect.addFlashAttribute("message", "Update manufacturer successfully");
        return "redirect:/manufacturers";
    }

    @GetMapping("/view-manufacturer/{id}")
    public ModelAndView viewManufacturer(@PathVariable("id") Long manufacturerId) {
        Optional<Manufacturer> manufacturerOptional = manufacturerService.findById(manufacturerId);
        if (!manufacturerOptional.isPresent()) {
            return new ModelAndView("/error_404");
        }

        Iterable<Computer> computers = computerService.findAllByManufacturer(manufacturerOptional.get());

        ModelAndView modelAndView = new ModelAndView("/computer/index");
        modelAndView.addObject("computers", computers);
        return modelAndView;
    }

    @GetMapping("/delete/{manufacturerId}")
    public ModelAndView deleteForm (@PathVariable Long manufacturerId){
        Optional<Manufacturer> manufacturer = manufacturerService.findById(manufacturerId);
        if (manufacturer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/manufacturer/delete");
            modelAndView.addObject("manufacturer", manufacturer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/delete")
    public String delete (Manufacturer manufacturer){
        manufacturerService.deleteManufacturerById(manufacturer.getManufacturerId());
        return "redirect:/manufacturers";
    }
    @GetMapping("/demo")
    public String countName (Model model){
        Iterable<ICountManufacturer> countList = manufacturerService.getNumbersOfManufacturer();
        model.addAttribute("count", countList);
        return "/demo";
    }
}


