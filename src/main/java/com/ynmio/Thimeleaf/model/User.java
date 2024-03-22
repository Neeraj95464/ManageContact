package com.ynmio.Thimeleaf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "name ca")
    @Size(max = 20,min = 3,message = "name should be between 3 to 20")
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    private boolean enabled;
    @Column(length = 200)
    private String about;
    private String imageUrl;
    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY ,mappedBy = "user")
    private List<Contact> contacts=new ArrayList<>();
}
