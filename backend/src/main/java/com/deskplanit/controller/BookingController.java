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

import com.deskplanit.model.Booking;
import com.deskplanit.model.Seat;
import com.deskplanit.model.User;
import com.deskplanit.repository.BookingRepository;
import com.deskplanit.repository.SeatRepository;
import com.deskplanit.repository.UserRepository;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;
    private final UserRepository userRepository;

    public BookingController(BookingRepository bookingRepository, SeatRepository seatRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestParam Long seatId, @RequestParam Long userId, @RequestBody Booking booking) {
        Optional<Seat> seat = seatRepository.findById(seatId);
        Optional<User> user = userRepository.findById(userId);
        if (seat.isEmpty() || user.isEmpty()) return ResponseEntity.notFound().build();
        booking.setSeat(seat.get());
        booking.setUser(user.get());
        return ResponseEntity.ok(bookingRepository.save(booking));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        return bookingRepository.findById(id)
                .map(existing -> {
                    existing.setStartTime(booking.getStartTime());
                    existing.setEndTime(booking.getEndTime());
                    existing.setStatus(booking.getStatus());
                    return ResponseEntity.ok(bookingRepository.save(existing));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        if (!bookingRepository.existsById(id)) return ResponseEntity.notFound().build();
        bookingRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
