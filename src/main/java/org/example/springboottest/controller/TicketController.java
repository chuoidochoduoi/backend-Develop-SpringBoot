package org.example.springboottest.controller;

import org.example.springboottest.dto.ApiResponse;
import org.example.springboottest.dto.TicketSummaryResponse;
import org.example.springboottest.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
     ParkingService parkingService;

    @GetMapping("/summary")
    public ApiResponse<List<TicketSummaryResponse>> getSummary() {
        return ApiResponse.ok(parkingService.getTodayTickets());
    }
}
