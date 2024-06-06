package br.com.insight.insight_lab.service;

import java.util.List;

import br.com.insight.insight_lab.dto.SupplierDTO;
import br.com.insight.insight_lab.entities.SupplierEntity;
import br.com.insight.insight_lab.entities.enums.SupplierStatus;
import jakarta.validation.Valid;

public interface SupplierService {

  SupplierEntity createSupplier(SupplierDTO supplierDTO);

  List<SupplierEntity> getAllSupplier(SupplierStatus status);

  SupplierEntity updateSupplier(Long id, @Valid SupplierDTO updatedSupplierDTO);

  void deleteSupplier(Long id);

}
