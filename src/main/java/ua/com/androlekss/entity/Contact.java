package ua.com.androlekss.entity;

import javax.persistence.*;

@Entity
public class Contact {

    @Id
    @GeneratedValue(generator = "contact_generator")
    @SequenceGenerator(
            name = "contact_generator",
            sequenceName = "contact_sequence",
            initialValue = 1000
    )
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
