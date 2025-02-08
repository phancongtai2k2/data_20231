package com.example.bin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bin.History;

public interface HistoryRepository extends JpaRepository<History, Integer> {
}
