package br.com.insight.insight_lab.modules.supplier.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.insight.insight_lab.modules.supplier.SupplierEntity;
import br.com.insight.insight_lab.modules.supplier.service.SupplierService;
import br.com.insight.insight_lab.modules.supplier.SupplierStatus;
import br.com.insight.insight_lab.modules.supplier.dto.SupplierDTO;

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
  public ResponseEntity<SupplierEntity> update(@PathVariable Long id, @RequestBody SupplierDTO updatedSupplierDTO) {
    SupplierEntity updatedEntity = supplierService.updateSupplier(id, updatedSupplierDTO);

    if (updatedEntity != null) {
      return ResponseEntity.ok(updatedEntity);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<SupplierEntity> delete(@PathVariable Long id) {
    SupplierEntity deletedEntity = supplierService.deleteSupplier(id);

    if (deletedEntity != null) {
      return ResponseEntity.ok(deletedEntity);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PatchMapping("/{id}/status")
  public ResponseEntity<SupplierEntity> updateStatus(@PathVariable Long id) {

    SupplierEntity updatedEntity = supplierService.toggleSupplierStatus(id);

    if (updatedEntity != null) {
      return ResponseEntity.ok(updatedEntity);
    } else {
      return ResponseEntity.notFound().build();
    }

  }
}
