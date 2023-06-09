package pl.com.gymtech.courierspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.com.gymtech.courierspring.dto.DriverDTO;
import pl.com.gymtech.courierspring.entity.Driver;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DriverMapper {

    public abstract DriverDTO driverToDriverDTO(Driver driver);
    @Mapping(target = "id", ignore = true)
    public abstract Driver driverDTOToDriver(DriverDTO driverDTO);
    public abstract List<DriverDTO> driverToDriverDTO(List<Driver> drivers);
}
