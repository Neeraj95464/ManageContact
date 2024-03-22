package com.ynmio.Thimeleaf.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contact
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cId;
    private String name;
    private String SecondName;
    private String work;
    private String email;
    private String phone;
    private String image;
    @Column(length = 500)
    private String description;

    @ManyToOne
    private User user;
}
