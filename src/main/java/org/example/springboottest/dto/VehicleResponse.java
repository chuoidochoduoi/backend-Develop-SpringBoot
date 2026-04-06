package org.example.springboottest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.springboottest.model.VehicleType;
@Data
@AllArgsConstructor
public class VehicleResponse {
    private Long id;
    private String licensePlate;
    private String color;
    private VehicleType vehicleType;
}
