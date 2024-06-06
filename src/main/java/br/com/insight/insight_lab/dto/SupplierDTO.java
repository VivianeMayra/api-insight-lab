package br.com.insight.insight_lab.dto;

import br.com.insight.insight_lab.entities.enums.SupplierStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {

  @NotNull(message = "O nome do fornecedor não pode ser nulo")
  @NotBlank(message = "O nome do fornecedor não pode ser vazio")
  private String name;

  @NotNull(message = "O cnpj do fornecedor não pode ser nulo")
  @NotBlank(message = "O cnpj do fornecedor não pode ser vazio")
  private String cnpj;

  @NotNull(message = "O endereço do fornecedor não pode ser nulo")
  @NotBlank(message = "O endereço do fornecedor não pode ser vazio")
  private String address;

  @NotNull(message = "O telefone do fornecedor não pode ser nulo")
  @NotBlank(message = "O telefone do fornecedor não pode ser vazio")
  private String phone;

  @NotNull(message = "O email do fornecedor não pode ser nulo")
  @NotBlank(message = "O email do fornecedor não pode ser vazio")
  private String email;

  @NotNull(message = "O website do fornecedor não pode ser nulo")
  @NotBlank(message = "O website do fornecedor não pode ser vazio")
  private String website;

  @NotNull(message = "A descrição do fornecedor não pode ser nulo")
  @NotBlank(message = "A descrição do fornecedor não pode ser vazio")
  private String description;

  @NotNull(message = "O status do fornecedor não pode ser nulo")
  private SupplierStatus status;

}
