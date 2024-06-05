package br.com.insight.insight_lab.modules.supplier.dto;

import br.com.insight.insight_lab.modules.supplier.SupplierStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {

  private String name;

  private String cnpj;

  private String address;

  private String phone;

  private String email;

  private String website;

  private String description;

  private SupplierStatus status;

}
