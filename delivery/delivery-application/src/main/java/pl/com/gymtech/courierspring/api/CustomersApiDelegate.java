package pl.com.gymtech.courierspring.api;

import pl.com.gymtech.courierspring.entity.CustomerDomain;
import pl.com.gymtech.courierspring.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link CustomersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T10:08:20.752442600+02:00[Europe/Warsaw]")
public interface CustomersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /customers : Pobierz wszystkich klientów
     *
     * @return Lista klientów (status code 200)
     * @see CustomersApi#customersGet
     */
    default ResponseEntity<List<CustomerDomain>> customersGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /customers/{id} : Usuń klienta o określonym identyfikatorze
     *
     * @param id Identyfikator klienta do usunięcia (required)
     * @return Klient został usunięty (status code 204)
     *         or Nie znaleziono klienta o podanym identyfikatorze (status code 404)
     * @see CustomersApi#customersIdDelete
     */
    default ResponseEntity<Void> customersIdDelete(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /customers/{id} : Pobierz klienta o określonym identyfikatorze
     *
     * @param id Identyfikator klienta do pobrania (required)
     * @return Szczegóły klienta (status code 200)
     *         or Nie znaleziono (status code 404)
     * @see CustomersApi#customersIdGet
     */
    default ResponseEntity<Void> customersIdGet(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /customers/{id}/orders : Pobierz wszystkie zamówienia użytkownika
     *
     * @param id Identyfikator użytkownika (required)
     * @return OK (status code 200)
     * or Nie znaleziono klienta o podanym identyfikatorze (status code 404)
     * @see CustomersApi#customersIdOrdersGet
     */
    default ResponseEntity<CustomerDomain> customersIdOrdersGet(Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /customers/{id} : Zaktualizuj adres o określonym identyfikatorze
     *
     * @param id Identyfikator adresu do zaktualizowania (required)
     * @param customer  (required)
     * @return Klient został zaktualizowany (status code 200)
     *         or Nie znaleziono klienta o podanym identyfikatorze (status code 404)
     * @see CustomersApi#customersIdPut
     */
    default ResponseEntity<Void> customersIdPut(Long id,
        Customer customer) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /customers : Dodaj nowego klienta
     *
     * @param customer  (required)
     * @return Klient został dodany (status code 201)
     * @see CustomersApi#customersPost
     */
    default ResponseEntity<Void> customersPost(Customer customer) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
