package org.example.springboottest.controller;

import lombok.RequiredArgsConstructor;
import org.example.springboottest.dto.ApiResponse;
import org.example.springboottest.dto.TicketRequest;
import org.example.springboottest.dto.TicketResponse;
import org.example.springboottest.service.ParkingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;

    // ✅ CHECK-IN
    @PostMapping("/check-in")
    public ApiResponse<TicketResponse> checkIn(@RequestBody TicketRequest req) {
        return ApiResponse.ok(parkingService.checkIn(req));
    }

    // ✅ CHECK-OUT
    @PutMapping("/check-out/{vehicleId}")
    public ApiResponse<TicketResponse> checkOut(@PathVariable("vehicleId") int vehicleId) {
        return ApiResponse.ok(parkingService.checkOut(vehicleId));
    }
}