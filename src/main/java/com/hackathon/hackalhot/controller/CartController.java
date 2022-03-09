package com.hackathon.hackalhot.controller;

import com.hackathon.hackalhot.model.CreateBarangRequest;
import com.hackathon.hackalhot.model.UpdateBarangRequest;
import com.hackathon.hackalhot.repository.UserRepository;
import com.hackathon.hackalhot.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

  @Autowired
  BarangService barangService;

  @Autowired
  UserRepository userRepository;

  @GetMapping(path = "/cart")
  public String home(Model model) {
    model.addAttribute("barangList", barangService.findAll());
    return "template/barang";
  }


  @PostMapping(path = "/barang")
  public String createBarang(
      @RequestParam(value = "name") String name,
      @RequestParam(value = "category") String category,
      @RequestParam(value = "description") String description) {
    //Dummy
    String userId = "aaaa";
    //
    CreateBarangRequest newBarang = new CreateBarangRequest(name, category, description, userId);
    barangService.create(newBarang);
    return "redirect:/cart";
  }

  @PutMapping(path = "/barang/{id}")
  public String updateBarang(
      @PathVariable String id,
      @RequestParam(value = "name") String name,
      @RequestParam(value = "category") String category,
      @RequestParam(value = "description") String description) {
    //Dummy
    String userId = "aaaa";
    //
    UpdateBarangRequest updateBarang = new UpdateBarangRequest(name, category, description, userId);
    barangService.update(id, updateBarang);
    return "redirect:/cart";
  }

  @DeleteMapping(path = "/barang/{id}")
  public String deleteBarang(@PathVariable String id) {
    barangService.deleteById(id);
    return "template/barang";
  }



}
