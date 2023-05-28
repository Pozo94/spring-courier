package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.gymtech.courierspring.entity.Shipment;

import java.util.List;
import java.util.Optional;
@Repository
public interface ShipmentRepository extends CrudRepository<Shipment,String> {
    Shipment save(Shipment shipment);
    List<Shipment> findAll();
    Optional<Shipment> findById(String  id);
}
