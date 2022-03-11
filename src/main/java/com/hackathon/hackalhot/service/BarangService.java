package com.hackathon.hackalhot.service;

import com.hackathon.hackalhot.entity.Barang;
import com.hackathon.hackalhot.model.CreateBarangRequest;
import com.hackathon.hackalhot.model.SalurkanBarangRequest;
import com.hackathon.hackalhot.model.UpdateBarangRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BarangService {

  Barang create(CreateBarangRequest request);

  List<Barang> findAll();

  Barang findById(String id);

  Barang update(String id, UpdateBarangRequest request);

  void deleteById(String id);

  Barang salurkan(String id, SalurkanBarangRequest request);
}
