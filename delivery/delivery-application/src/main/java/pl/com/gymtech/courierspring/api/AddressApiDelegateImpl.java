package pl.com.gymtech.courierspring.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.entity.AddressDomain;
import pl.com.gymtech.courierspring.model.Address;
import pl.com.gymtech.courierspring.service.AddressService;

import java.util.List;

@Service
public class AddressApiDelegateImpl implements AddressesApiDelegate{
    private AddressService addressService;

    public AddressApiDelegateImpl(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public ResponseEntity<List<AddressDomain>> addressesGet() {
        List<AddressDomain> addresses=addressService.getAllAddresses();
        return ResponseEntity.ok().body(addresses);
    }

    @Override
    public ResponseEntity<Void> addressesIdDelete(Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<AddressDomain> addressesIdGet(Long id) {
        AddressDomain address= addressService.getAddressById(id);
        return ResponseEntity.ok(address);
    }

    @Override
    public ResponseEntity<Void> addressesIdPut(Long id, Address address) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> addressesPost(Address address) {
        return ResponseEntity.noContent().build();    }
}
