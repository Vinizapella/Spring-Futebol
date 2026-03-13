package com.weg.soccer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "transfer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String playerName;
    @Column
    private String clubOrigin;
    @Column
    private String clubDestination;
    @Column
    private double valueRate;
    @Column
    private LocalDate dateTransference;
    @Column
    private Boolean International;
}
