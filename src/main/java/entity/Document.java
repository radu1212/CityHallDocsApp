package entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "document")
public class Document {

    @Id
    @Column(name = "UUID", unique = true)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "requires_address")
    private Boolean requires_address;


    public Document(String title, Boolean requires_address) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.requires_address = requires_address;
    }

    public Document() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getRequires_address() {
        return requires_address;
    }

    public void setRequires_address(Boolean requires_address) {
        this.requires_address = requires_address;
    }
}
