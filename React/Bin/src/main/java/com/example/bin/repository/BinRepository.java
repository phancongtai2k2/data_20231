package com.example.bin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bin.Bin;

public interface BinRepository extends JpaRepository<Bin, Integer> {
}
