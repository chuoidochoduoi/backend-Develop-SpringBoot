package org.example.springboottest.dto;

import lombok.Data;

@Data
public class TicketRequest {
    private int vehicleId;
    private int zoneId;
}