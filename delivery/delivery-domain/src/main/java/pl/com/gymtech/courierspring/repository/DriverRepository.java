package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.gymtech.courierspring.entity.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    Driver save(Driver driver);
    List<Driver> findAll();
    Optional<Driver> findById(Long id);
}
