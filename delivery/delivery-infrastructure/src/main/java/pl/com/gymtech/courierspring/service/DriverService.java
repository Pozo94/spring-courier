package pl.com.gymtech.courierspring.service;

import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.Mapper.DriverMapper;
import pl.com.gymtech.courierspring.dto.DriverDTO;
import pl.com.gymtech.courierspring.entity.Driver;
import pl.com.gymtech.courierspring.repository.DriverRepository;

import java.util.List;

@Service
public class DriverService {
    DriverRepository driverRepository;
    DriverMapper driverMapper;

    public DriverService(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }
    public List<DriverDTO> getAllDrivers(){
        return driverMapper.driverToDriverDTO(driverRepository.findAll());
    }
    public DriverDTO createDriver(DriverDTO  driverDTO){
        return driverMapper.driverToDriverDTO(new Driver(driverDTO.getFirstName(), driverDTO.getLastName(), driverDTO.getEmail(), driverDTO.getPhone()));

    }
    public void deleteDriver(String id){
        driverRepository.deleteById(id);
    }
    public DriverDTO updateDriver(String id,DriverDTO driverDTO){
        Driver driver=driverRepository.findById(id).orElseThrow();
        driver.setFirstName(driverDTO.getFirstName());
        driver.setLastName(driverDTO.getLastName());
        driver.setEmail(driverDTO.getEmail());
        driver.setPhone(driverDTO.getPhone());
        return driverMapper.driverToDriverDTO(driverRepository.save(driver));
    }
    public DriverDTO getDriverById(String id){
       return driverMapper.driverToDriverDTO(driverRepository.findById(id).orElseThrow());
    }


}
