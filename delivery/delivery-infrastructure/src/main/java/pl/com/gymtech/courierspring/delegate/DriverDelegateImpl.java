package pl.com.gymtech.courierspring.delegate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.api.DriversApiDelegate;
import pl.com.gymtech.courierspring.dto.DriverDTO;
import pl.com.gymtech.courierspring.service.DriverService;

import java.util.List;
import java.util.UUID;

@Service
public class DriverDelegateImpl implements DriversApiDelegate {
    private DriverService driverService;

    public DriverDelegateImpl(DriverService driverService) {
        this.driverService = driverService;
    }

    @Override
    public ResponseEntity<DriverDTO> createDriver(DriverDTO driverDTO) {

        return ResponseEntity.ok(driverService.createDriver(driverDTO));
    }

    @Override
    public ResponseEntity<Void> deleteDriverById(UUID id) {
        driverService.deleteDriver(id.toString());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @Override
    public ResponseEntity<DriverDTO> getDriverById(UUID id) {
        return ResponseEntity.ok(driverService.getDriverById(id.toString()));
    }

    @Override
    public ResponseEntity<DriverDTO> updateDriverById(UUID id, DriverDTO driverDTO) {
        return ResponseEntity.ok(driverService.updateDriver(id.toString(),driverDTO));
    }
}
