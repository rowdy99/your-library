package com.example.subham.controller;

import com.example.subham.model.Chemistry;
import com.example.subham.model.Computer;
import com.example.subham.model.Doc;
import com.example.subham.repository.BooksRepo;
import com.example.subham.repository.ChemistryRepo;
import com.example.subham.repository.DocRepository;
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
public class ChemistryController {

    @Autowired
    BooksRepo booksRepo;
    @Autowired
    DocStorageService docStorageService;
    @Autowired
    DocRepository docRepository;
    @Autowired
    ChemistryRepo chemistryRepo;

    @GetMapping("/chemistryupload")
    public String chemistryupload(Model model){
        ArrayList<Chemistry> of = (ArrayList<Chemistry>) chemistryRepo.findAll();
        model.addAttribute("chemistry",of);
        List<Doc> docs2 = docStorageService.getFiles();
        model.addAttribute("docs", docs2); //attribute name should be same


        return "chemistryupload";
    }

    @GetMapping("/chemistrybooks")
    public String getChemistryController(Model model)
    {
        ArrayList<Chemistry> of=(ArrayList<Chemistry>)chemistryRepo.findAll();
        model.addAttribute("chemistry",of);

        return "chemistrybooks";
    }

    @PostMapping("/chemistrybooks")
    public  String SaveBooks(Chemistry of){

        of.getAuthorName(); of.setAuthorName();of.getBookName();of.setBookName();of.getContent();of.setContent();of.getData();of.setData();of.getPrice();of.setPrice();
        chemistryRepo.save(of);




        System.out.println(of);
        return "doc";
    }
    @GetMapping("/chemistry/delete/{id}")
    public String DeleteBooks(@PathVariable("id") int id){

        chemistryRepo.deleteById(id);
        docRepository.deleteById(id);


        return "chemistryupload";
    }

}
