package com.example.bin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.bin.Bin;
import com.example.bin.repository.BinRepository;

import java.util.List;

@RestController
@RequestMapping("/api/bins")
public class BinController {
    
    @Autowired
    private BinRepository binRepository;

    @GetMapping
    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }

    @PostMapping
    public Bin createBin(@RequestBody Bin bin) {
        return binRepository.save(bin);
    }

    @GetMapping("/{id}")
    public Bin getBinById(@PathVariable int id) {
        return binRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Bin updateBin(@PathVariable int id, @RequestBody Bin binDetails) {
        Bin bin = binRepository.findById(id).orElse(null);
        if (bin != null) {
            bin.setLat(binDetails.getLat());
            bin.setLon(binDetails.getLon());
            bin.setStatus(binDetails.getStatus());
            return binRepository.save(bin);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBin(@PathVariable int id) {
        binRepository.deleteById(id);
    }
}
