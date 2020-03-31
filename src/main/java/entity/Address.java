package entity;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "UUID", unique = true)
    private String id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "apartment", nullable = false)
    private String apartment;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "county", nullable = false)
    private String county;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Address(String street, String number, String apartment, String city, String county, User user) {
        this.id = UUID.randomUUID().toString();
        this.street = street;
        this.number = number;
        this.apartment = apartment;
        this.city = city;
        this.county = county;
        this.user = user;
    }

    public Address() {
        this.id = UUID.randomUUID().toString();
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getApartment() {
        return apartment;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }


}
