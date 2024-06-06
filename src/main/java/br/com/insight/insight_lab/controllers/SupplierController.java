package br.com.insight.insight_lab.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.insight.insight_lab.dto.SupplierDTO;
import br.com.insight.insight_lab.entities.SupplierEntity;
import br.com.insight.insight_lab.entities.enums.SupplierStatus;
import br.com.insight.insight_lab.exceptions.SupplierNotFoundException;
import br.com.insight.insight_lab.service.SupplierService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedores")
public class SupplierController {

  @Autowired
  private SupplierService supplierService;

  @PostMapping("/")
  public SupplierEntity create(@RequestBody SupplierDTO supplierDTO) {
    return supplierService.createSupplier(supplierDTO);
  }

  @GetMapping("/")
  public List<SupplierEntity> findAll(@RequestParam(required = false) SupplierStatus status) {
    return supplierService.getAllSupplier(status);
  }

  @PutMapping("/{id}")
  public ResponseEntity<SupplierEntity> update(@PathVariable Long id,
      @Valid @RequestBody SupplierDTO updatedSupplierDTO) {
    try {
      SupplierEntity updatedEntity = supplierService.updateSupplier(id, updatedSupplierDTO);
      return ResponseEntity.ok(updatedEntity);
    } catch (SupplierNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {

    try {
      supplierService.deleteSupplier(id);
      return ResponseEntity.noContent().build();
    } catch (SupplierNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

}
