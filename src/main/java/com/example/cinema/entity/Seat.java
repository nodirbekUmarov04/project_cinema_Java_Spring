package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @Column(name = "row_number")
    private Integer rowNumber;

    @Column(name = "seat_number")
    private Integer seatNumber;
}
