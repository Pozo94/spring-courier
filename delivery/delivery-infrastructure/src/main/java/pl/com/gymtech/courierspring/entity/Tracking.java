package pl.com.gymtech.courierspring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "shipments")
@AllArgsConstructor
@Getter
@Setter
public class Tracking {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String eventType;

    private LocalDate eventTime;

    private String location;

    private String description;

    public Tracking() {
        id = UUID.randomUUID().toString();
    }
}
