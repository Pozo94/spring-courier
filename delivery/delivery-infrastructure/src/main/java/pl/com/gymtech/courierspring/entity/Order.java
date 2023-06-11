package pl.com.gymtech.courierspring.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    private String  id;

    private String senderAddress;

    private String receiverAddress;

    private String packageType;

    private String packageSize;

    private String status;

    private LocalDate deliveryDate;

    @Version
    private int version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order() {
        id = UUID.randomUUID().toString();
    }

    public Order(String senderAddress, String receiverAddress, String packageType, String packageSize, String status) {
        this.id = UUID.randomUUID().toString();
        this.senderAddress = senderAddress;
        this.receiverAddress = receiverAddress;
        this.packageType = packageType;
        this.packageSize = packageSize;
        this.status = status;

    }

    public Order(String id, String status) {
        this.id = id;
        this.status=status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", packageType='" + packageType + '\'' +
                ", packageSize='" + packageSize + '\'' +
                ", status='" + status + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", version=" + version +
                ", customer=" + customer +
                '}';
    }
}
