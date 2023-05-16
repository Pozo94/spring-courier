package pl.com.gymtech.courierspring.api;

import pl.com.gymtech.courierspring.entity.AddressDomain;
import pl.com.gymtech.courierspring.model.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link AddressesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T10:08:20.752442600+02:00[Europe/Warsaw]")
public interface AddressesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /addresses : Pobierz wszystkie adresy
     *
     * @return Lista adresów (status code 200)
     * @see AddressesApi#addressesGet
     */
    default ResponseEntity<List<AddressDomain>> addressesGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /addresses/{id} : Usuń adres o określonym identyfikatorze
     *
     * @param id Identyfikator adresu do usunięcia (required)
     * @return Adres został usunięty (status code 204)
     *         or Nie znaleziono adresu o podanym identyfikatorze (status code 404)
     * @see AddressesApi#addressesIdDelete
     */
    default ResponseEntity<Void> addressesIdDelete(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /addresses/{id} : Pobierz adres o określonym identyfikatorze
     *
     * @param id Identyfikator adresu do pobrania (required)
     * @return Szczegóły adresu (status code 200)
     * or Nie znaleziono adresu o podanym identyfikatorze (status code 404)
     * @see AddressesApi#addressesIdGet
     */
    default ResponseEntity<AddressDomain> addressesIdGet(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /addresses/{id} : Zaktualizuj adres o określonym identyfikatorze
     *
     * @param id Identyfikator adresu do zaktualizowania (required)
     * @param address  (required)
     * @return Adres został zaktualizowany (status code 200)
     *         or Nie znaleziono adresu o podanym identyfikatorze (status code 404)
     * @see AddressesApi#addressesIdPut
     */
    default ResponseEntity<Void> addressesIdPut(Long id,
        Address address) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /addresses : Dodaj nowy adres
     *
     * @param address  (required)
     * @return Adres został dodany (status code 201)
     * @see AddressesApi#addressesPost
     */
    default ResponseEntity<Void> addressesPost(Address address) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
