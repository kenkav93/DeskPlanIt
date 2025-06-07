package com.deskplanit.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deskplanit.model.Booking;
import com.deskplanit.model.Seat;
import com.deskplanit.model.User;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBySeat(Seat seat);
    List<Booking> findByUser(User user);
    List<Booking> findBySeatAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(Seat seat, LocalDateTime end, LocalDateTime start);
}
