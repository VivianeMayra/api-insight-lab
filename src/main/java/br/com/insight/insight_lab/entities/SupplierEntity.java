package br.com.insight.insight_lab.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.insight.insight_lab.dto.SupplierDTO;
import br.com.insight.insight_lab.entities.enums.SupplierStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier")
public class SupplierEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(min = 2, max = 100, message = "O nome do fornecedor deve conter entre 2 e 100 caracteres")
  private String name;

  @CNPJ(message = "O CNPJ do fornecedor deve estar no formato válido")
  private String cnpj;

  @Size(min = 5, max = 200, message = "O endereço do fornecedor deve conter entre 5 e 200 caracteres")
  private String address;

  @Size(max = 13, message = "O telefone do fornecedor deve conter até 13 caracteres")
  private String phone;

  @Email(message = "O campo email do fornecedor deve conter um e-mail válido")
  private String email;

  @URL(message = "O website do fornecedor deve conter um site válido")
  private String website;

  @Size(max = 500, message = "A descrição do fornecedor deve ter no máximo 500 caracteres")
  private String description;

  @Enumerated(EnumType.STRING)
  private SupplierStatus status;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public SupplierEntity(SupplierDTO supplierDTO) {
    this.name = supplierDTO.getName();
    this.cnpj = supplierDTO.getCnpj();
    this.address = supplierDTO.getAddress();
    this.phone = supplierDTO.getPhone();
    this.email = supplierDTO.getEmail();
    this.website = supplierDTO.getWebsite();
    this.description = supplierDTO.getDescription();
    this.status = supplierDTO.getStatus();
  }
}
