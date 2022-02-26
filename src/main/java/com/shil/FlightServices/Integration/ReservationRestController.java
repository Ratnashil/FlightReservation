package com.shil.FlightServices.Integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shil.FlightServices.Entity.Flight;
import com.shil.FlightServices.Entity.Passenger;
import com.shil.FlightServices.Entity.Reservation;
import com.shil.FlightServices.Repos.FlightRepository;
import com.shil.FlightServices.Repos.PassengerRepository;
import com.shil.FlightServices.Repos.ReservationRepository;
import com.shil.FlightServices.dto.CreateReservationRequest;

@RestController
public class ReservationRestController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping(value="/Flight", method= RequestMethod.GET)
	public List<Flight> findflights(){
		return flightRepository.findAll();
	}
	
	@RequestMapping(value ="/Reservation", method= RequestMethod.POST)
	@Transactional
	public Reservation saveReservation(CreateReservationRequest request) {
		
		Flight flight = flightRepository.findById(request.getFlightId()).get();
		
		Passenger passenger = new Passenger();
		
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setFirstName(request.getPassengerLastName());
		passenger.setFirstName(request.getPassengerMiddleName());
		passenger.setFirstName(request.getPassengerEmail());
		passenger.setFirstName(request.getPassengerPhone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		return reservationRepository.save(reservation);
		
	}
	
	@RequestMapping(value="/reservation/{Id}")
	public Reservation findReservation(int Id) {
		return reservationRepository.findById(Id).get();
		
	}

}
