package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.gymtech.courierspring.entity.DriverDomain;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<DriverDomain,Long> {
    DriverDomain save(DriverDomain driverDomain);
    List<DriverDomain> findAll();
    Optional<DriverDomain> findById(Long id);
}
