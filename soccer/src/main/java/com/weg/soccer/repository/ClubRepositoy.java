package com.weg.soccer.repository;

import com.weg.soccer.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepositoy extends JpaRepository<Club, Integer> {
}
