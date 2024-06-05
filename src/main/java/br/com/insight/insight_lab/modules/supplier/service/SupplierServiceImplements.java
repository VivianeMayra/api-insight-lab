package br.com.insight.insight_lab.modules.supplier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.insight.insight_lab.exceptions.SupplierNotFoundException;
import br.com.insight.insight_lab.modules.supplier.SupplierEntity;
import br.com.insight.insight_lab.modules.supplier.SupplierStatus;
import br.com.insight.insight_lab.modules.supplier.dto.SupplierDTO;
import br.com.insight.insight_lab.modules.supplier.repository.SupplierRepository;

@Service
public class SupplierServiceImplements implements SupplierService {

  @Autowired
  private SupplierRepository supplierRepository;

  @Override
  public SupplierEntity createSupplier(SupplierDTO supplierDTO) {

    SupplierEntity supplierEntity = new SupplierEntity();
    supplierEntity.setName(supplierDTO.getName());
    supplierEntity.setAddress(supplierDTO.getAddress());
    supplierEntity.setCnpj(supplierDTO.getCnpj());
    supplierEntity.setDescription(supplierDTO.getDescription());
    supplierEntity.setEmail(supplierDTO.getEmail());
    supplierEntity.setPhone(supplierDTO.getPhone());
    supplierEntity.setWebsite(supplierDTO.getWebsite());
    supplierEntity.setStatus(supplierDTO.getStatus());
    return this.supplierRepository.save(supplierEntity);
  }

  @Override
  public List<SupplierEntity> getAllSupplier(SupplierStatus status) {
    if (status != null) {
      return this.supplierRepository.findByStatus(status);
    } else {
      return this.supplierRepository.findAll();
    }
  }

  @Override
  public SupplierEntity updateSupplier(Long id, SupplierDTO updatedSupplierDTO) {
    Optional<SupplierEntity> optionalSupplier = supplierRepository.findById(id);

    if (optionalSupplier.isPresent()) {

      SupplierEntity existingSupplier = optionalSupplier.get();

      if (updatedSupplierDTO.getName() != null) {
        existingSupplier.setName(updatedSupplierDTO.getName());
      }

      if (updatedSupplierDTO.getEmail() != null) {
        existingSupplier.setEmail(updatedSupplierDTO.getEmail());
      }

      if (updatedSupplierDTO.getDescription() != null) {
        existingSupplier.setDescription(updatedSupplierDTO.getDescription());
      }

      if (updatedSupplierDTO.getAddress() != null) {
        existingSupplier.setAddress(updatedSupplierDTO.getAddress());
      }

      if (updatedSupplierDTO.getPhone() != null) {
        existingSupplier.setPhone(updatedSupplierDTO.getPhone());
      }

      if (updatedSupplierDTO.getCnpj() != null) {
        existingSupplier.setCnpj(updatedSupplierDTO.getCnpj());
      }

      if (updatedSupplierDTO.getWebsite() != null) {
        existingSupplier.setWebsite(updatedSupplierDTO.getWebsite());
      }

      return this.supplierRepository.save(existingSupplier);

    } else {
      throw new SupplierNotFoundException();
    }
  }

  @Override
  public SupplierEntity deleteSupplier(Long id) {
    Optional<SupplierEntity> optionalSupplier = supplierRepository.findById(id);

    if (optionalSupplier.isPresent()) {
      SupplierEntity deletedSupplier = optionalSupplier.get();
      supplierRepository.deleteById(id);
      return deletedSupplier;
    } else {
      throw new SupplierNotFoundException();
    }
  }

  @Override
  public SupplierEntity toggleSupplierStatus(Long id) {
    Optional<SupplierEntity> optionalSupplier = supplierRepository.findById(id);

    if (optionalSupplier.isPresent()) {
      SupplierEntity existingSupplier = optionalSupplier.get();

      switch (existingSupplier.getStatus()) {
        case ACTIVE:
          existingSupplier.setStatus(SupplierStatus.INACTIVE);
          break;
        case INACTIVE:
          existingSupplier.setStatus(SupplierStatus.UNDER_ANALYSIS);
          break;
        case UNDER_ANALYSIS:
          existingSupplier.setStatus(SupplierStatus.ACTIVE);
          break;
        default:
          throw new SupplierNotFoundException();
      }
      return this.supplierRepository.save(existingSupplier);
    } else {
      throw new SupplierNotFoundException();
    }
  }

}
