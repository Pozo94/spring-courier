package pl.com.gymtech.courierspring.api;

import pl.com.gymtech.courierspring.entity.DriverDomain;
import pl.com.gymtech.courierspring.model.Driver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link DriversApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T10:08:20.752442600+02:00[Europe/Warsaw]")
public interface DriversApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /drivers : Pobierz wszystkich kierowców
     *
     * @return Lista wszystkich kierowców (status code 200)
     * @see DriversApi#driversGet
     */
    default ResponseEntity<List<DriverDomain>> driversGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /drivers/{id} : Usuń kierowcę o określonym identyfikatorze
     *
     * @param id Identyfikator kierowcy (required)
     * @return Kierowca został usunięty (status code 204)
     *         or Kierowca o podanym identyfikatorze nie istnieje (status code 404)
     * @see DriversApi#driversIdDelete
     */
    default ResponseEntity<Void> driversIdDelete(Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /drivers/{id} : Pobierz kierowcę o określonym identyfikatorze
     *
     * @param id Identyfikator kierowcy (required)
     * @return Szczegóły kierowcy (status code 200)
     * or Kierowca o podanym identyfikatorze nie istnieje (status code 404)
     * @see DriversApi#driversIdGet
     */
    default ResponseEntity<DriverDomain> driversIdGet(Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /drivers/{id} : Zaktualizuj kierowcę o określonym identyfikatorze
     *
     * @param id Identyfikator kierowcy (required)
     * @param driver  (required)
     * @return Kierowca został zaktualizowany (status code 200)
     *         or Nieprawidłowe dane kierowcy (status code 400)
     *         or Kierowca o podanym identyfikatorze nie istnieje (status code 404)
     * @see DriversApi#driversIdPut
     */
    default ResponseEntity<Void> driversIdPut(Integer id,
        Driver driver) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /drivers : Dodaj nowego kierowcę
     *
     * @param order  (required)
     * @return Kierowca został dodany (status code 201)
     *         or Nieprawidłowe dane kierowcy (status code 400)
     * @see DriversApi#driversPost
     */
    default ResponseEntity<Void> driversPost(Driver driver) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
