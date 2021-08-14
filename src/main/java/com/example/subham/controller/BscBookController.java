package com.example.subham.controller;

import com.example.subham.model.Anm;
import com.example.subham.model.Bsc;
import com.example.subham.model.Doc;
import com.example.subham.repository.BooksRepo;
import com.example.subham.repository.BscRepo;
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
public class BscBookController {
    @Autowired
    BooksRepo booksRepo;
    @Autowired
    DocStorageService docStorageService;
    @Autowired
    DocRepository docRepository;
    @Autowired
    BscRepo bscRepo;

    @GetMapping("/bscupload")
    public String bscupload(Model model){
        ArrayList<Bsc> oj = (ArrayList<Bsc>) bscRepo.findAll();
        model.addAttribute("bsc",oj);
        List<Doc> docs2 = docStorageService.getFiles();
        model.addAttribute("docs", docs2); //attribute name should be same
        return "bscupload";
    }

    @GetMapping("/bscbooks")
    public String getBscBookController(Model model)
    {
        ArrayList<Bsc> oj=(ArrayList<Bsc>)bscRepo.findAll();
        model.addAttribute("bsc",oj);

        return "bscbooks";
    }

    @PostMapping("/bscbooks")
    public  String SaveBooks(Bsc oj){

        oj.getAuthorName(); oj.setAuthorName();oj.getBookName();oj.setBookName();oj.getContent();oj.setContent();oj.getData();oj.setData();oj.getPrice();oj.setPrice();
        bscRepo.save(oj);

        System.out.println(oj);
        return "doc";
    }

    @GetMapping("/bsc/delete/{id}")
    public String DeleteBooks(@PathVariable("id") int id){

        bscRepo.deleteById(id);
        docRepository.deleteById(id);


        return "bscupload";
    }
}
