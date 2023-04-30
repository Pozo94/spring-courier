package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.gymtech.courierspring.entity.Shipment;

import java.util.List;
import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<Shipment,Long> {
    Shipment save(Shipment shipment);
    List<Shipment> findAll();
    Optional<Shipment> findById(Long id);
}
