package pl.com.gymtech.courierspring.delegate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.api.DriversApiDelegate;
import pl.com.gymtech.courierspring.dto.DriverDTO;
import pl.com.gymtech.courierspring.service.DriverService;

import java.util.List;

@Service
public class DriverDelegateImpl implements DriversApiDelegate {
    DriverService driverService;
    @Override
    public ResponseEntity<DriverDTO> createDriver(DriverDTO driverDTO) {
        return ResponseEntity.ok(driverService.createDriver(driverDTO));
    }

    @Override
    public ResponseEntity<Void> deleteDriverById(String id) {
        driverService.deleteDriver(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @Override
    public ResponseEntity<DriverDTO> getDriverById(String id) {
        return ResponseEntity.ok(driverService.getDriverById(id));
    }

    @Override
    public ResponseEntity<DriverDTO> updateDriverById(String id, DriverDTO driverDTO) {
        return ResponseEntity.ok(driverService.updateDriver(id,driverDTO));
    }
}
