package pl.com.gymtech.courierspring.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "shipments")
@AllArgsConstructor
@Getter
@Setter
public class Shipment {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    private LocalDate pickupTime;

    private LocalDate deliveryTime;

    @Version
    private int version;


    public Shipment() {
        id = UUID.randomUUID().toString();
    }
}
