/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalexam.Final_Exam;

import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Muhamad Akmal Amran_20200140138
 */
@RestController
@CrossOrigin
@RequestMapping("/exam")
public class FinalExamController {
    
    @Autowired
    private SuratService  suratService;
    
    @ResponseBody
    @GetMapping("/check")
    public String checkAPI()
    {
        return "hello word";
    }
    
    @PostMapping("/surat")
    public String saveSurat(@RequestBody Surat surat) throws InterruptedException, ExecutionException{
        
        return suratService.save(surat);
        
    }

    @GetMapping("/suratall")
    public List<Surat> viewSuratAll() throws InterruptedException, ExecutionException{
        
        return suratService.getSuratAll();
        
    }

    @GetMapping("/surat/{no_surat}")
    public Surat viewSurat(@PathVariable String id) throws InterruptedException, ExecutionException{
        
        return suratService.getSurat(id);
        
    }

    @PutMapping("/updateSurat")
    public String updateSurat(@RequestBody Surat surat) throws InterruptedException, ExecutionException{
        
        return suratService.update(surat);
        
    }

    @DeleteMapping("/deleteSurat/{no_surat}")
    public String deleteSurat(@PathVariable String no_surat) throws InterruptedException, ExecutionException{
        
        return suratService.delete(no_surat);
        
    }
    
}
