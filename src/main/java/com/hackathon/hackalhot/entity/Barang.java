package com.hackathon.hackalhot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="barang")
public class Barang {

  @Id
  @Column(name="barang_id")
  @GeneratedValue(generator="uuid2")
  @GenericGenerator(name="uuid2", strategy= "org.hibernate.id.UUIDGenerator")
  private String id;

  @Column(name="barang_name")
  private String name;

  @Column
  private String category;

  @Column
  private Integer quantity;

  @Column
  private String description;

  @Column
  private String pictureUrl;

  @Column
  private Boolean isTersalurkan;

  @Version
  @Column
  private Long version;
}
