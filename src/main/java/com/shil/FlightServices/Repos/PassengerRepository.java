package com.shil.FlightServices.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shil.FlightServices.Entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
