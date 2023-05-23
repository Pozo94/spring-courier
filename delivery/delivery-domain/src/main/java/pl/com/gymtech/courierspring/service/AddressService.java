package pl.com.gymtech.courierspring.service;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.entity.AddressDomain;
import pl.com.gymtech.courierspring.repository.AddressRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public List<AddressDomain> getAllAddresses(){
        return null;
    }
    public void addAddress(AddressDomain address){}
    public AddressDomain getAddressById(Long id){return null;}
    public void updateAddress(Long id){}
    public void deleteAddress(Long id){}

}
