package br.com.insight.insight_lab.modules.supplier;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CNPJ;

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

  @Size(min = 2, max = 100, message = "O campo[name] deve conter entre 2 e 100 caracteres")
  private String name;

  @CNPJ(message = "O CNPJ deve estar no formato válido")
  private String cnpj;

  @Size(min = 5, max = 200, message = "O campo[address] deve conter entre 5 e 200 caracteres")
  private String address;

  @Size(max = 13, message = "O campo[phone] deve conter até 13 caracteres")
  private String phone;

  @Email(message = "O campo [email] deve conter um e-mail válido")
  private String email;

  @URL(message = "O campo [website] deve conter um site válido")
  private String website;

  @Size(max = 500, message = "O campo[description] deve ter até no máximo 500 caracteres")
  private String description;

  @Enumerated(EnumType.STRING)
  private SupplierStatus status;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
