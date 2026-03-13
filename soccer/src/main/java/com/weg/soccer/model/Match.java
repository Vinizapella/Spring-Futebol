package com.weg.soccer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "match")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String homeTeam;
    @Column
    private String visitingTeam;
    @Column
    private Integer homeTeamGoals;
    @Column
    private Integer visitingTeamGoals;
    @Column
    private LocalDateTime DepartureDateTime;
    @Column
    private String stadiumName;

}
