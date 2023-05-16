package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.gymtech.courierspring.entity.ShipmentDomain;

import java.util.List;
import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<ShipmentDomain,Long> {
    ShipmentDomain save(ShipmentDomain shipmentDomain);
    List<ShipmentDomain> findAll();
    Optional<ShipmentDomain> findById(Long id);
}
