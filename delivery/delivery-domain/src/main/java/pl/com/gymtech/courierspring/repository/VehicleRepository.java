package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.gymtech.courierspring.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    Vehicle save(Vehicle vehicle);
    List<Vehicle> findAll();
    Optional<Vehicle> findById(Long id);

}
