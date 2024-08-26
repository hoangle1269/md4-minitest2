package com.example.md4minitest2computer.controller;

import com.example.md4minitest2computer.model.Computer;
import com.example.md4minitest2computer.model.ComputerForm;
import com.example.md4minitest2computer.model.Manufacturer;
import com.example.md4minitest2computer.service.IComputerService;
import com.example.md4minitest2computer.service.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/computers")
public class ComputerController {
    @Autowired
    private IComputerService computerService;

    @Autowired
    private IManufacturerService manufacturerService;

    //Dùng de lay ds them sua o trong ds nha san xuat,phan them sua can
    @ModelAttribute("manufacturers")
    public Iterable<Manufacturer> manufacturers() {return manufacturerService.findAll();}

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Computer> computerPage = computerService.findAll(pageable);
        model.addAttribute("computerList", computerPage);

        return "/computer/index";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("computer", new Computer());

        //ds bang nha san xuat
//        Iterable<Manufacturer> manufacturers = manufacturerService.findAll();//findAll tat ca customer ra
//        model.addAttribute("manufacturers", manufacturers);

        return "/computer/create";
    }

    @Value("${file-upload}")
    private String upload;

    @PostMapping("/save")
    public String save(ComputerForm computerForm) {
        MultipartFile file = computerForm.getImg();

        String fileName = file.getOriginalFilename();

        try {
            FileCopyUtils.copy(file.getBytes(), new File(upload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            Computer computer = new Computer();
            computer.setComputerId(computerForm.getComputerId());
            computer.setComputerCode(computerForm.getComputerCode());
            computer.setComputerName(computerForm.getComputerName());
            computer.setPrice(computerForm.getPrice());
            computer.setManufacturer(computerForm.getManufacturerId());
            computer.setDescription(computerForm.getDescription());
            computer.setImg(fileName);
            computerService.save(computer);
            return "redirect:/computers";
        }

    }

    @GetMapping("/{computerId}/edit")
    public String showFormEdit(@PathVariable Long computerId, Model model) {
        model.addAttribute("computer", computerService.findById(computerId).get());
//        Iterable<Manufacturer> manufacturers = manufacturerService.findAll();
//        model.addAttribute("manufacturers", manufacturers);
        return "/computer/edit";
    }


    @PostMapping("/update")
    public String update(ComputerForm computerForm) {
        MultipartFile file = computerForm.getImg();

        String fileName = file.getOriginalFilename();

        try {
            FileCopyUtils.copy(file.getBytes(), new File(upload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            Computer computer = new Computer();
            computer.setComputerId(computerForm.getComputerId());
            computer.setComputerCode(computerForm.getComputerCode());
            computer.setComputerName(computerForm.getComputerName());
            computer.setPrice(computerForm.getPrice());
            computer.setManufacturer(computerForm.getManufacturerId());
            computer.setDescription(computerForm.getDescription());
            computer.setImg(fileName);
            computerService.save(computer);
            return "redirect:/computers";
        }

    }

    @GetMapping("/{computerId}/delete")
    public String showFormDelete(@PathVariable Long computerId, Model model) {
        model.addAttribute("computer", computerService.findById(computerId).get());
        Iterable<Manufacturer> manufacturers = manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "/computer/delete";
    }

    @PostMapping("/delete")
    public String delete(Long computerId, RedirectAttributes redirect) {
        computerService.remove(computerId);
        redirect.addFlashAttribute("success", "Removed computer successfully!");
        return "redirect:/computers";
    }

    //    @GetMapping("{id}/view")
//    public String showView(@PathVariable int id, Model model) {
//        model.addAttribute("product", productService.findById(id));
//        return "/view";
//    }
//
    @GetMapping("/search")
    public String search(@RequestParam("computerName") String computerName,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size,
                         Model model) {
        Page<Computer> computerList = computerService.findAllByNameContaining(PageRequest.of(page, size), computerName);
        model.addAttribute("computerList", computerList);
        return "/computer/index";
    }
}

