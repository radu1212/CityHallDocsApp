package entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @Column(name = "UUID", unique = true)
    private String id;

    @Column(name = "document", nullable = false)
    private String document;

    @Column(name = "time", nullable = false)
    private String time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "address", nullable = true)
    private String address;

    public Request(String document, String time, User user, String address) {
        this.document = document;
        this.time = time;
        this.user = user;
        this.id = UUID.randomUUID().toString();
        this.status = "Pending";
    }

    public Request(String time, User user) {
        this.document = "";
        this.time = time;
        this.user = user;
        this.id = UUID.randomUUID().toString();
        this.status = "Pending";
        this.address = null;
    }

    public Request(String time) {
        this.document = "";
        this.time = time;
        this.id = UUID.randomUUID().toString();
        this.status = "Pending";
        this.address = null;
    }

    public Request() {
        this.id = UUID.randomUUID().toString();
        this.status = "Pending";
        this.address = null;
    }

    public String getId() {
        return id;
    }

    public String getDocument() {
        return document;
    }

    public String getTime() {
        return time;
    }

    public User getUser() {
        return user;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }
}
