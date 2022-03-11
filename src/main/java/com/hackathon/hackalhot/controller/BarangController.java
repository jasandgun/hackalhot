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

  @GetMapping(path = "/")
  public String home(Model model) {
    model.addAttribute("barangList", barangService.findAll());
    return "index";
  }

  @GetMapping(path = "/upload-barang")
  public String formBarang() {
    return "barang/upload_barang";
  }

  @GetMapping(path = "/barangku")
  public String personalBarang(Model model) {
    model.addAttribute("barangList", barangService.findAll());
    return "barang/barangku";
  }

  @GetMapping(path = "/detail-barang")
  public String detailBarang() {
    return "barang/detail_barang";
  }

  @GetMapping(path = "/terhibah")
  public String deliveredBarang() {
    return "barang/terhibah";
  }

  @PostMapping(path = "/barangku")
  public String createBarang(
      @RequestParam(value = "name") String name,
      @RequestParam(value = "category") String category,
      @RequestParam(value = "quantity") Integer quantity,
      @RequestParam(value = "description") String description) {
    //Dummy
//    User newUser = new User("dummyId","dummyName", "dummyAddress", "dummyContactNumber");
//    userRepository.save(newUser);
//    String userId = "dummyId";
    //
    CreateBarangRequest newBarang = new CreateBarangRequest(name, category, quantity, description);
    barangService.create(newBarang);
    return "redirect:/barangku";
  }

  @PutMapping(path = "/barangku/{id}")
  public String updateBarang(
      @PathVariable String id,
      @RequestParam(value = "name") String name,
      @RequestParam(value = "category") String category,
      @RequestParam(value = "quantity") Integer quantity,
      @RequestParam(value = "description") String description) {
    //Dummy
//    String userId = "dummyId";
    //
    UpdateBarangRequest updateBarang = new UpdateBarangRequest(name, category, quantity, description);
    barangService.update(id, updateBarang);
    return "redirect:/barang";
  }

  @DeleteMapping(path = "/barangku/{id}")
  public String deleteBarang(@PathVariable String id) {
    barangService.deleteById(id);
    return "redirect:/barangku";
  }
}
