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
@Table(name = "tracking")
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

    @Version
    private int version;
    public Tracking() {
        id = UUID.randomUUID().toString();
    }

    public Tracking(Order order, String eventType, LocalDate eventTime, String location, String description) {
        this.id=UUID.randomUUID().toString();
        this.order = order;
        this.eventType = eventType;
        this.eventTime = eventTime;
        this.location = location;
        this.description = description;
    }
}
