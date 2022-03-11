package com.hackathon.hackalhot.service;

import com.hackathon.hackalhot.entity.Barang;
import com.hackathon.hackalhot.entity.User;
import com.hackathon.hackalhot.model.CreateBarangRequest;
import com.hackathon.hackalhot.model.SalurkanBarangRequest;
import com.hackathon.hackalhot.model.UpdateBarangRequest;
import com.hackathon.hackalhot.repository.BarangRepository;
import com.hackathon.hackalhot.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangServiceImpl implements BarangService {

  @Autowired
  BarangRepository barangRepository;

  @Autowired
  UserRepository userRepository;

  @Override
  public Barang create(CreateBarangRequest request) {
    // jika pakai user
//    User user = userRepository.getById(request.getUserId());
//    Barang barang = Barang.builder().userId(user).build();
    Barang barang = Barang.builder().build();
    BeanUtils.copyProperties(request,barang);
    return barangRepository.save(barang);
  }

  @Override
  public List<Barang> findAll() {
    return barangRepository.findAll();
  }

  @Override
  public Barang findById(String id) {
    return barangRepository.getById(id);
  }

  @Override
  public Barang update(String id, UpdateBarangRequest request) {
    Barang barang = barangRepository.getById(id);
    BeanUtils.copyProperties(request, barang);
    return barangRepository.save(barang);
  }

  @Override
  public void deleteById(String id) {
    barangRepository.deleteById(id);
  }

  public Barang salurkan(String id, SalurkanBarangRequest request) {
    Barang barang = barangRepository.getById(id);
    BeanUtils.copyProperties(request, barang);
    return barangRepository.save(barang);
  }
}
