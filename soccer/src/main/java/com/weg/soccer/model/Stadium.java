package com.weg.soccer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "stadium")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer capacity;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String turfType;

    @Column
    private LocalDate inaugurationDate;
}
