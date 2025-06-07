package com.deskplanit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deskplanit.model.MapFile;
import com.deskplanit.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByMap(MapFile map);
}
