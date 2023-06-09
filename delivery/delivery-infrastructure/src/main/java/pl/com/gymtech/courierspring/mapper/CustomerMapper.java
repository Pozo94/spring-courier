package pl.com.gymtech.courierspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.com.gymtech.courierspring.dto.CustomerDTO;
import pl.com.gymtech.courierspring.entity.Customer;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {
    @Mapping(target = "id", ignore = true)
    public abstract Customer customerDTOToCustomer(CustomerDTO customerDTO);
    public abstract CustomerDTO customerToCustomerDTO(Customer customer);
    public abstract List<CustomerDTO> CustomerToCustomerDTO(List<Customer> customerList);

}
