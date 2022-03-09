package com.hackathon.hackalhot.model;

import com.hackathon.hackalhot.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBarangRequest {

  private String name;

  private String category;

  private String description;

  private String userId;
}
