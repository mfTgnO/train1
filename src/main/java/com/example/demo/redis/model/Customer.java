package com.example.demo.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/*@Data
@AllArgsConstructor*/
public class Customer implements Serializable {

    private static final long serialVersionUID = -6894784201567109845L;
    private Long id;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
