package com.cloudbees.app.cloudbeesApp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departure = "London";  // Rename from -> departure
    private String destination = "France";  // Rename to -> destination
    private String firstName;
    private String lastName;
    private String email;
    private double pricePaid = 20.0;
    private String section;
    private String seatNumber;
}