package pl.com.gymtech.courierspring.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Shipment
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T10:08:20.752442600+02:00[Europe/Warsaw]")
public class Shipment   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("driver")
  private Object driver;

  @JsonProperty("order")
  private Object order;

  @JsonProperty("departureTime")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate departureTime;

  @JsonProperty("arrivalTime")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate arrivalTime;

  public Shipment id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Shipment driver(Object driver) {
    this.driver = driver;
    return this;
  }

  /**
   * Get driver
   * @return driver
  */
  @ApiModelProperty(value = "")


  public Object getDriver() {
    return driver;
  }

  public void setDriver(Object driver) {
    this.driver = driver;
  }

  public Shipment order(Object order) {
    this.order = order;
    return this;
  }

  /**
   * Get order
   * @return order
  */
  @ApiModelProperty(value = "")


  public Object getOrder() {
    return order;
  }

  public void setOrder(Object order) {
    this.order = order;
  }

  public Shipment departureTime(LocalDate departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  /**
   * Get departureTime
   * @return departureTime
  */
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(LocalDate departureTime) {
    this.departureTime = departureTime;
  }

  public Shipment arrivalTime(LocalDate arrivalTime) {
    this.arrivalTime = arrivalTime;
    return this;
  }

  /**
   * Get arrivalTime
   * @return arrivalTime
  */
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(LocalDate arrivalTime) {
    this.arrivalTime = arrivalTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Shipment shipment = (Shipment) o;
    return Objects.equals(this.id, shipment.id) &&
        Objects.equals(this.driver, shipment.driver) &&
        Objects.equals(this.order, shipment.order) &&
        Objects.equals(this.departureTime, shipment.departureTime) &&
        Objects.equals(this.arrivalTime, shipment.arrivalTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, driver, order, departureTime, arrivalTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Shipment {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    driver: ").append(toIndentedString(driver)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    departureTime: ").append(toIndentedString(departureTime)).append("\n");
    sb.append("    arrivalTime: ").append(toIndentedString(arrivalTime)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

