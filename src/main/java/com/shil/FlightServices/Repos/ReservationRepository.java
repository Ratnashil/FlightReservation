package com.shil.FlightServices.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shil.FlightServices.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
