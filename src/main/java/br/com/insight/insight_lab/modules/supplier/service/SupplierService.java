package br.com.insight.insight_lab.modules.supplier.service;

import java.util.List;

import br.com.insight.insight_lab.modules.supplier.SupplierEntity;
import br.com.insight.insight_lab.modules.supplier.SupplierStatus;
import br.com.insight.insight_lab.modules.supplier.dto.SupplierDTO;

public interface SupplierService {

  SupplierEntity createSupplier(SupplierDTO supplierDTO);

  List<SupplierEntity> getAllSupplier(SupplierStatus status);

  SupplierEntity updateSupplier(Long id, SupplierDTO updatedSupplierDTO);

  SupplierEntity deleteSupplier(Long id);

  SupplierEntity toggleSupplierStatus(Long id);

}
