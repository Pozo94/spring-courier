package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import pl.com.gymtech.courierspring.entity.DriverDomain;

import java.util.List;
import java.util.Optional;
@Repository
public interface DriverRepository extends JpaRepository<DriverDomain,Long> {
    DriverDomain save(DriverDomain driverDomain);
    List<DriverDomain> findAll();
    Optional<DriverDomain> findById(Long id);
}
