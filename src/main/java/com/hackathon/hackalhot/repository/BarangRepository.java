package com.hackathon.hackalhot.repository;

import com.hackathon.hackalhot.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<Barang, String> {
}
