package pl.com.gymtech.courierspring.service;

import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.Mapper.CustomerMapper;
import pl.com.gymtech.courierspring.Mapper.CustomerMapperImpl;
import pl.com.gymtech.courierspring.dto.CustomerDTO;
import pl.com.gymtech.courierspring.dto.OrderDTO;
import pl.com.gymtech.courierspring.entity.Customer;
import pl.com.gymtech.courierspring.repository.CustomerRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    OrderService orderService;
    CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, OrderService orderService, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.orderService = orderService;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer(customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getEmail(), customerDTO.getPhone(), customerDTO.getAddress());
        customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(customer);
    }
    public CustomerDTO getCustomerById(String id){
        return customerMapper.customerToCustomerDTO(customerRepository.findById(id.toString()).orElseThrow());
    }
    public List<CustomerDTO> getAllCustomers(){
        return customerMapper.CustomerToCustomerDTO(customerRepository.findAll());
    }
    public CustomerDTO updateCustomer(String id, CustomerDTO updatedCustomer){
        Customer customer= customerRepository.findById(id).orElseThrow();
        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setAddress(updatedCustomer.getAddress());
        customer.setPhone(updatedCustomer.getPhone());
        return customerMapper.customerToCustomerDTO(customerRepository.save(customer));
    }
    public void deleteCustomer(String id){
        customerRepository.deleteById(id);

    }
    public List<OrderDTO> getCustomerOrders(String customerId){
        return orderService.getCustomerOrders(customerId);

    }
}
