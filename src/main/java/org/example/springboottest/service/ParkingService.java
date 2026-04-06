package org.example.springboottest.service;

import lombok.RequiredArgsConstructor;
import org.example.springboottest.dto.TicketRequest;
import org.example.springboottest.dto.TicketResponse;
import org.example.springboottest.dto.TicketSummaryResponse;
import org.example.springboottest.model.ParkingTicket;
import org.example.springboottest.model.Vehicle;
import org.example.springboottest.model.Zone;
import org.example.springboottest.repository.ParkingTicketRepository;
import org.example.springboottest.repository.VehicleRepository;
import org.example.springboottest.repository.ZoneRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingService {

    private final VehicleRepository vehicleRepository;
    private final ZoneRepository zoneRepository;
    private final ParkingTicketRepository ticketRepository;

    @Transactional
    public TicketResponse checkIn(TicketRequest req) {

        Vehicle vehicle = vehicleRepository.findById(req.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Zone zone = zoneRepository.findById(req.getZoneId())
                .orElseThrow(() -> new RuntimeException("Zone not found"));

        if (zone.getOccupiedSpots() >= zone.getCapacity()) {
            throw new RuntimeException("Zone is full");
        }

        ParkingTicket ticket = new ParkingTicket();
        ticket.setVehicle(vehicle);
        ticket.setZone(zone);
        ticket.setCheckInTime(LocalDateTime.now());

        zone.setOccupiedSpots(zone.getOccupiedSpots() + 1);

        ticketRepository.save(ticket);

        return new TicketResponse(
                ticket.getId(),
                vehicle.getLicensePlate(),
                zone.getName(),
                ticket.getCheckInTime(),
                null
        );
    }

    // 🚗 CHECK-OUT
    @Transactional
    public TicketResponse checkOut(int vehicleId) {

        ParkingTicket ticket = ticketRepository
                .findTopByVehicleIdAndCheckOutTimeIsNullOrderByCheckInTimeDesc(vehicleId)
                .orElseThrow(() -> new RuntimeException("No active ticket found"));

        ticket.setCheckOutTime(LocalDateTime.now());

        Zone zone = ticket.getZone();

        // 👉 giảm số chỗ đã dùng
        zone.setOccupiedSpots(zone.getOccupiedSpots() - 1);

        ticketRepository.save(ticket);

        return new TicketResponse(
                ticket.getId(),
                ticket.getVehicle().getLicensePlate(),
                zone.getName(),
                ticket.getCheckInTime(),
                ticket.getCheckOutTime()
        );
    }

    public List<TicketSummaryResponse> getTodayTickets() {
        return ticketRepository.findTodayTickets();
    }
}