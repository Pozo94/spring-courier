package pl.com.gymtech.courierspring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String address;

    public Customer() {
        id= UUID.randomUUID().toString();
    }

    public Customer( String firstName, String lastName, String email, String phone, String address) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}