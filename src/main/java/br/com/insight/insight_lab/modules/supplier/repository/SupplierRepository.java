package br.com.insight.insight_lab.modules.supplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.insight.insight_lab.modules.supplier.SupplierEntity;
import br.com.insight.insight_lab.modules.supplier.SupplierStatus;

import java.util.List;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
  List<SupplierEntity> findByStatus(SupplierStatus status);
}
