package pl.com.gymtech.courierspring.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Order
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T10:08:20.752442600+02:00[Europe/Warsaw]")
public class Order   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("customer")
  private Object customer;

  @JsonProperty("senderAddress")
  private Object senderAddress;

  @JsonProperty("receiverAddress")
  private Object receiverAddress;

  @JsonProperty("packageType")
  private String packageType;

  @JsonProperty("packageSize")
  private String packageSize;

  @JsonProperty("shipment")
  private Object shipment;

  public Order id(Integer id) {
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

  public Order customer(Object customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  */
  @ApiModelProperty(value = "")


  public Object getCustomer() {
    return customer;
  }

  public void setCustomer(Object customer) {
    this.customer = customer;
  }

  public Order senderAddress(Object senderAddress) {
    this.senderAddress = senderAddress;
    return this;
  }

  /**
   * Get senderAddress
   * @return senderAddress
  */
  @ApiModelProperty(value = "")


  public Object getSenderAddress() {
    return senderAddress;
  }

  public void setSenderAddress(Object senderAddress) {
    this.senderAddress = senderAddress;
  }

  public Order receiverAddress(Object receiverAddress) {
    this.receiverAddress = receiverAddress;
    return this;
  }

  /**
   * Get receiverAddress
   * @return receiverAddress
  */
  @ApiModelProperty(value = "")


  public Object getReceiverAddress() {
    return receiverAddress;
  }

  public void setReceiverAddress(Object receiverAddress) {
    this.receiverAddress = receiverAddress;
  }

  public Order packageType(String packageType) {
    this.packageType = packageType;
    return this;
  }

  /**
   * Get packageType
   * @return packageType
  */
  @ApiModelProperty(value = "")


  public String getPackageType() {
    return packageType;
  }

  public void setPackageType(String packageType) {
    this.packageType = packageType;
  }

  public Order packageSize(String packageSize) {
    this.packageSize = packageSize;
    return this;
  }

  /**
   * Get packageSize
   * @return packageSize
  */
  @ApiModelProperty(value = "")


  public String getPackageSize() {
    return packageSize;
  }

  public void setPackageSize(String packageSize) {
    this.packageSize = packageSize;
  }

  public Order shipment(Object shipment) {
    this.shipment = shipment;
    return this;
  }

  /**
   * Get shipment
   * @return shipment
  */
  @ApiModelProperty(value = "")


  public Object getShipment() {
    return shipment;
  }

  public void setShipment(Object shipment) {
    this.shipment = shipment;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.id, order.id) &&
        Objects.equals(this.customer, order.customer) &&
        Objects.equals(this.senderAddress, order.senderAddress) &&
        Objects.equals(this.receiverAddress, order.receiverAddress) &&
        Objects.equals(this.packageType, order.packageType) &&
        Objects.equals(this.packageSize, order.packageSize) &&
        Objects.equals(this.shipment, order.shipment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customer, senderAddress, receiverAddress, packageType, packageSize, shipment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    senderAddress: ").append(toIndentedString(senderAddress)).append("\n");
    sb.append("    receiverAddress: ").append(toIndentedString(receiverAddress)).append("\n");
    sb.append("    packageType: ").append(toIndentedString(packageType)).append("\n");
    sb.append("    packageSize: ").append(toIndentedString(packageSize)).append("\n");
    sb.append("    shipment: ").append(toIndentedString(shipment)).append("\n");
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

