package pl.com.gymtech.courierspring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.gymtech.courierspring.mapper.DriverMapper;
import pl.com.gymtech.courierspring.dto.DriverDTO;
import pl.com.gymtech.courierspring.entity.Driver;
import pl.com.gymtech.courierspring.repository.DriverRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class DriverService {
    DriverRepository driverRepository;
    DriverMapper driverMapper;


    public List<DriverDTO> getAllDrivers(){
        return driverMapper.driverToDriverDTO(driverRepository.findAll());
    }
    @Transactional
    public DriverDTO createDriver(DriverDTO  driverDTO){
        return driverMapper.driverToDriverDTO(driverRepository.save(new Driver(driverDTO.getFirstName(), driverDTO.getLastName(), driverDTO.getEmail(), driverDTO.getPhone())));

    }
    @Transactional
    public void deleteDriver(String id){
        driverRepository.deleteById(id);
    }
    @Transactional
    public DriverDTO updateDriver(String id,DriverDTO driverDTO){
        Driver driver=driverRepository.findById(id).orElseThrow(()->new NoSuchElementException("Driver with id: "+id+ " not found!" ));
        driver.setFirstName(driverDTO.getFirstName());
        driver.setLastName(driverDTO.getLastName());
        driver.setEmail(driverDTO.getEmail());
        driver.setPhone(driverDTO.getPhone());
        return driverMapper.driverToDriverDTO(driverRepository.save(driver));
    }
    public DriverDTO getDriverById(String id){
       return driverMapper.driverToDriverDTO(driverRepository.findById(id).orElseThrow(()->new NoSuchElementException("Driver with id: "+id+ " not found!" )));
    }


}
