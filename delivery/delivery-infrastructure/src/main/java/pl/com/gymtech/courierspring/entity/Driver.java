package pl.com.gymtech.courierspring.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "drivers")
@Getter
@Setter
public class Driver {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    @Version
    private int version;

    public Driver() {
        id = UUID.randomUUID().toString();
    }

    public Driver( String firstName, String lastName, String email, String phone) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}
