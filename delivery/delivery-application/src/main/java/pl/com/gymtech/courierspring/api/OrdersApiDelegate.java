package pl.com.gymtech.courierspring.api;

import pl.com.gymtech.courierspring.entity.OrderDomain;
import pl.com.gymtech.courierspring.entity.ShipmentDomain;
import pl.com.gymtech.courierspring.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link OrdersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T10:08:20.752442600+02:00[Europe/Warsaw]")
public interface OrdersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /orders : Pobierz wszystkie zamówienia
     *
     * @return OK (status code 200)
     * @see OrdersApi#ordersGet
     */
    default ResponseEntity<List<OrderDomain>> ordersGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /orders/{id} : Usuń zamówienie o określonym identyfikatorze
     *
     * @param id Identyfikator zamówienia (required)
     * @return Usunięto (status code 204)
     *         or Nie znaleziono zamówienia o podanym identyfikatorze (status code 404)
     * @see OrdersApi#ordersIdDelete
     */
    default ResponseEntity<Void> ordersIdDelete(Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /orders/{id} : Pobierz zamówienie o określonym identyfikatorze
     *
     * @param id Identyfikator zamówienia (required)
     * @return OK (status code 200)
     * or Nie znaleziono zamówienia o podanym identyfikatorze (status code 404)
     * @see OrdersApi#ordersIdGet
     */
    default ResponseEntity<OrderDomain> ordersIdGet(Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /orders/{id} : Zaktualizuj zamówienie o określonym identyfikatorze
     *
     * @param id Identyfikator zamówienia (required)
     * @param order  (required)
     * @return OK (status code 200)
     *         or Nie znaleziono zamówienia o podanym identyfikatorze (status code 404)
     * @see OrdersApi#ordersIdPut
     */
    default ResponseEntity<Void> ordersIdPut(Integer id,
        Order order) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /orders/{orderId}/shipment : Śledzenie przesyłki zamówienia o określonym identyfikatorze
     *
     * @param orderId Identyfikator zamówienia (required)
     * @return Szczegóły przesyłki (status code 200)
     * or Zamówienie o podanym identyfikatorze nie istnieje (status code 404)
     * @see OrdersApi#ordersOrderIdShipmentGet
     */
    default ResponseEntity<ShipmentDomain> ordersOrderIdShipmentGet(Integer orderId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /orders/{orderId}/shipment : Aktualizuj dane przesyłki zamówienia
     *
     * @param orderId Identyfikator zamówienia (required)
     * @return Szczegóły przesyłki (status code 200)
     *         or Zamówienie o podanym identyfikatorze nie istnieje (status code 404)
     * @see OrdersApi#ordersOrderIdShipmentPut
     */
    default ResponseEntity<Void> ordersOrderIdShipmentPut(Integer orderId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /orders : Dodaj nowe zamówienie
     *
     * @param order  (required)
     * @return Stworzono (status code 201)
     * @see OrdersApi#ordersPost
     */
    default ResponseEntity<Void> ordersPost(Order order) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
