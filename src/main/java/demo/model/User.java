package demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Copyright 2015 Timothy Schimandle.  All Rights Reserved.
 */
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 3, max = 80)
    private String email;

    @NotNull
    @Size(min = 2, max = 80)
    private String name;

    public User() { }

    public User(long id) {
        this.id = id;
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public long getId()
    {
        return id;
    }

    // getter and setter methods ...

} // class User
