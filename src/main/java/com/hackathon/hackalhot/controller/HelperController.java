package com.hackathon.hackalhot.controller;

import com.hackathon.hackalhot.model.SalurkanBarangRequest;
import com.hackathon.hackalhot.repository.UserRepository;
import com.hackathon.hackalhot.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class HelperController {

  @Autowired
  BarangService barangService;

  @Autowired
  UserRepository userRepository;

  @GetMapping(path = "/")
  public String home(Model model) {
    model.addAttribute("barangList", barangService.findAll());
    return "index";
  }

  @GetMapping(path = "/upload-barang")
  public String formBarang() {
    return "barang/upload_barang";
  }

  @GetMapping(path = "/detail-barang/{id}")
  public String detailBarang(@PathVariable String id, Model model) {
    model.addAttribute("barang",barangService.findById(id));
    return "barang/detail_barang";
  }

  // Contoh sebagai Dummy
  @GetMapping(path = "/detail-barang")
  public String detailBarangOthers() {
    return "barang/detail_barang_others";
  }

  @GetMapping(path = "/terhibah")
  public String deliveredBarang(Model model) {
    model.addAttribute("barangList", barangService.findByTersalurkan());
    return "barang/terhibah";
  }

  @PutMapping(path = "/salurkan/{id}")
  public String salurkan(@PathVariable String id) {
    SalurkanBarangRequest salurkanBarangRequest = new SalurkanBarangRequest(true);
    barangService.salurkan(id, salurkanBarangRequest);
    return "redirect:/barangku";
  }
}
