package com.example.subham.controller;

import com.example.subham.model.Books;
import com.example.subham.model.Computer;
import com.example.subham.model.Doc;
import com.example.subham.repository.BooksRepo;
import com.example.subham.repository.ComputerRepo;
import com.example.subham.repository.DocRepository;
import com.example.subham.repository.ScienceRepo;
import com.example.subham.service.DocStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ComputerBookController {
    @Autowired
    BooksRepo booksRepo;
    @Autowired
    DocStorageService docStorageService;
    @Autowired
    DocRepository docRepository;
    @Autowired
    ComputerRepo computerRepo;
    @Autowired
    ScienceRepo scienceRepo;

    @GetMapping("/computerupload")
    public String computerupload(Model model){
        ArrayList<Computer> oa = (ArrayList<Computer>) computerRepo.findAll();
        model.addAttribute("computer",oa);
        List<Doc> docs2 = docStorageService.getFiles();
        model.addAttribute("docs", docs2); //attribute name should be same


        return "computerupload";
    }

    @GetMapping("/computerbooks")
    public String getComputerBookController(Model model)
    {
        ArrayList<Computer> oa=(ArrayList<Computer>)computerRepo.findAll();
        model.addAttribute("computer",oa);

        return "computerbooks";
    }
    @PostMapping("/computerbooks")
    public  String SaveBooks(Computer oa){

        oa.getAuthorName(); oa.setAuthorName();oa.getBookName();oa.setBookName();oa.getContent();oa.setContent();oa.getData();oa.setData();oa.getPrice();oa.setPrice();
        computerRepo.save(oa);




        System.out.println(oa);
        return "doc";
    }

    @GetMapping("/computer/delete/{id}")
    public String DeleteBooks(@PathVariable("id") int id){

        computerRepo.deleteById(id);
        docRepository.deleteById(id);


        return "computerupload";
    }



}
