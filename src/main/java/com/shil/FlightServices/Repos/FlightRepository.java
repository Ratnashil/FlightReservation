package com.shil.FlightServices.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shil.FlightServices.Entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
