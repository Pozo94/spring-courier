package pl.com.gymtech.courierspring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.com.gymtech.courierspring.mapper.CustomerMapper;
import pl.com.gymtech.courierspring.dto.CustomerDTO;
import pl.com.gymtech.courierspring.dto.OrderDTO;
import pl.com.gymtech.courierspring.entity.Customer;
import pl.com.gymtech.courierspring.repository.CustomerRepository;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class CustomerService {

    CustomerRepository customerRepository;
    OrderService orderService;
    CustomerMapper customerMapper;


    @Transactional
    public CustomerDTO createCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer(customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getEmail(), customerDTO.getPhone(), customerDTO.getAddress());
        customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(customer);
    }

    public CustomerDTO getCustomerById(String id){
        return customerMapper.customerToCustomerDTO(customerRepository.findById(id).orElseThrow(()->new NoSuchElementException("Customer with id: "+id+ " not found!" )));
    }
    public List<CustomerDTO> getAllCustomers(){
        return customerMapper.CustomerToCustomerDTO(customerRepository.findAll());
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerDTO updateCustomer(String id, CustomerDTO updatedCustomer){
        Customer customer= customerRepository.findById(id).orElseThrow(()->new NoSuchElementException("Customer with id: "+id+ " not found!" ));
        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setAddress(updatedCustomer.getAddress());
        customer.setPhone(updatedCustomer.getPhone());

        return customerMapper.customerToCustomerDTO(customerRepository.save(customer));
    }
    @Transactional
    public void deleteCustomer(String id){
        customerRepository.deleteById(id);

    }
    public List<OrderDTO> getCustomerOrders(String customerId){
        return orderService.getCustomerOrders(customerId);

    }
}
