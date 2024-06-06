package br.com.insight.insight_lab.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.insight.insight_lab.dto.SupplierDTO;
import br.com.insight.insight_lab.entities.SupplierEntity;
import br.com.insight.insight_lab.entities.enums.SupplierStatus;
import br.com.insight.insight_lab.exceptions.SupplierNotFoundException;
import br.com.insight.insight_lab.repository.SupplierRepository;
import jakarta.validation.Valid;

@Service
@Validated
public class SupplierServiceImplements implements SupplierService {

  @Autowired
  private SupplierRepository supplierRepository;

  @Override
  public SupplierEntity createSupplier(SupplierDTO supplierDTO) {
    SupplierEntity supplierEntity = new SupplierEntity(supplierDTO);
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
  public SupplierEntity updateSupplier(Long id, @Valid SupplierDTO updatedSupplierDTO) {

    SupplierEntity existingSupplier = getSupplierById(id);

    existingSupplier.setName(updatedSupplierDTO.getName());

    existingSupplier.setEmail(updatedSupplierDTO.getEmail());

    existingSupplier.setDescription(updatedSupplierDTO.getDescription());

    existingSupplier.setAddress(updatedSupplierDTO.getAddress());

    existingSupplier.setPhone(updatedSupplierDTO.getPhone());

    existingSupplier.setCnpj(updatedSupplierDTO.getCnpj());

    existingSupplier.setWebsite(updatedSupplierDTO.getWebsite());

    existingSupplier.setStatus(updatedSupplierDTO.getStatus());

    return this.supplierRepository.save(existingSupplier);

  }

  @Override
  public void deleteSupplier(Long id) {
    getSupplierById(id);
    supplierRepository.deleteById(id);

  }

  private SupplierEntity getSupplierById(Long id) {
    Optional<SupplierEntity> optionalSupplier = supplierRepository.findById(id);
    if (optionalSupplier.isPresent()) {
      return optionalSupplier.get();
    } else {
      throw new SupplierNotFoundException();
    }
  }

}
