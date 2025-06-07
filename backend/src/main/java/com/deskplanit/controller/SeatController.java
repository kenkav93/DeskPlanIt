package com.deskplanit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deskplanit.model.MapFile;
import com.deskplanit.model.Seat;
import com.deskplanit.repository.MapFileRepository;
import com.deskplanit.repository.SeatRepository;

@RestController
@RequestMapping("/api/seating")
public class SeatController {
    private final SeatRepository seatRepository;
    private final MapFileRepository mapFileRepository;

    public SeatController(SeatRepository seatRepository, MapFileRepository mapFileRepository) {
        this.seatRepository = seatRepository;
        this.mapFileRepository = mapFileRepository;
    }

    @GetMapping
    public ResponseEntity<List<Seat>> getSeats(@RequestParam Long mapId) {
        Optional<MapFile> map = mapFileRepository.findById(mapId);
        return map.map(m -> ResponseEntity.ok(seatRepository.findByMap(m)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Seat> addSeat(@RequestParam Long mapId, @RequestBody Seat seat) {
        Optional<MapFile> map = mapFileRepository.findById(mapId);
        if (map.isEmpty()) return ResponseEntity.notFound().build();
        seat.setMap(map.get());
        return ResponseEntity.ok(seatRepository.save(seat));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable Long id, @RequestBody Seat seat) {
        return seatRepository.findById(id)
                .map(existing -> {
                    existing.setLabel(seat.getLabel());
                    existing.setX(seat.getX());
                    existing.setY(seat.getY());
                    existing.setAssignedUser(seat.getAssignedUser());
                    return ResponseEntity.ok(seatRepository.save(existing));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long id) {
        if (!seatRepository.existsById(id)) return ResponseEntity.notFound().build();
        seatRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
