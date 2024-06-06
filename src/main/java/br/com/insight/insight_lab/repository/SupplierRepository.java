package br.com.insight.insight_lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.insight.insight_lab.entities.SupplierEntity;
import br.com.insight.insight_lab.entities.enums.SupplierStatus;

import java.util.List;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
  List<SupplierEntity> findByStatus(SupplierStatus status);
}
