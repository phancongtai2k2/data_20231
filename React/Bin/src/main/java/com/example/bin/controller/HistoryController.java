package com.example.bin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.bin.History;
import com.example.bin.repository.HistoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryController {
    
    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    @PostMapping
    public History createHistory(@RequestBody History history) {
        return historyRepository.save(history);
    }

    @GetMapping("/{id}")
    public History getHistoryById(@PathVariable int id) {
        return historyRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public History updateHistory(@PathVariable int id, @RequestBody History historyDetails) {
        History history = historyRepository.findById(id).orElse(null);
        if (history != null) {
            history.setBinId(historyDetails.getBinId());
            history.setType(historyDetails.getType());
            history.setTime(historyDetails.getTime());
            history.setInBin(historyDetails.isInBin());
            return historyRepository.save(history);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteHistory(@PathVariable int id) {
        historyRepository.deleteById(id);
    }
}
