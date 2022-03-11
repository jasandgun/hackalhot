package com.hackathon.hackalhot.controller;

import com.hackathon.hackalhot.model.CreateBarangRequest;
import com.hackathon.hackalhot.model.UpdateBarangRequest;
import com.hackathon.hackalhot.repository.UserRepository;
import com.hackathon.hackalhot.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BarangController {

  @Autowired
  BarangService barangService;

  @Autowired
  UserRepository userRepository;

  @GetMapping(path = "/barangku")
  public String personalBarang(Model model) {
    model.addAttribute("barangList", barangService.findAll());
    return "barang/barangku";
  }

  @PostMapping(path = "/barangku")
  public String createBarang(
      @RequestParam(value = "name") String name,
      @RequestParam(value = "category") String category,
      @RequestParam(value = "quantity") Integer quantity,
      @RequestParam(value = "description") String description,
      @RequestParam(value = "pictureUrl") String pictureUrl) {

    CreateBarangRequest newBarang = new CreateBarangRequest(name, category, quantity, description, pictureUrl, false);
    barangService.create(newBarang);
    return "redirect:/barangku";
  }

  @GetMapping(path = "/update-barangku/{id}")
  public String updateBarangView(@PathVariable String id, Model model) {
    model.addAttribute("barang", barangService.findById(id));
    model.addAttribute("options", new String[]{"Organik", "Anorganik", "B3 (Bahan Berbahaya dan Beracun)", "Lain-lain"});
    return "barang/update_barang";
  }
  @PutMapping(path = "/update-barangku/{id}")
  public String updateBarang(
      @PathVariable String id,
      @RequestParam(value = "name") String name,
      @RequestParam(value = "category") String category,
      @RequestParam(value = "quantity") Integer quantity,
      @RequestParam(value = "description") String description,
      @RequestParam(value = "pictureUrl") String pictureUrl) {

    UpdateBarangRequest updateBarang = new UpdateBarangRequest(name, category, quantity, description, pictureUrl);
    barangService.update(id, updateBarang);
    return "redirect:/barangku";
  }

  @DeleteMapping(path = "/barangku/{id}")
  public String deleteBarang(@PathVariable String id) {
    barangService.deleteById(id);
    return "redirect:/barangku";
  }
}
