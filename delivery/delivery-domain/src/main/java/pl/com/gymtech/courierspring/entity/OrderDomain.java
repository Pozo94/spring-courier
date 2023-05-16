package pl.com.gymtech.courierspring.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "sender_address_id", nullable = false)
    private Long senderAddressId;

    @Column(name = "receiver_address_id", nullable = false)
    private Long receiverAddressId;

    @Column(name = "package_type", nullable = false)
    private String packageType;

    @Column(name = "package_size", nullable = false)
    private String packageSize;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipment_id", referencedColumnName = "shipment_id")
    private ShipmentDomain shipmentDomain;

}
