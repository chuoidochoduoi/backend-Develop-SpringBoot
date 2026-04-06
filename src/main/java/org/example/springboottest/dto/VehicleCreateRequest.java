package org.example.springboottest.dto;


import lombok.Data;
import org.example.springboottest.model.VehicleType;

@Data
public class VehicleCreateRequest {
    private String licensePlate;
    private String color;
    private VehicleType vehicleType;
}
