package com.hackathon.hackalhot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalurkanBarangRequest {
    private Boolean isTersalurkan;
}
