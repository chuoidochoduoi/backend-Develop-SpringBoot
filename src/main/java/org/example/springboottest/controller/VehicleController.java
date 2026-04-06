package org.example.springboottest.controller;

import lombok.RequiredArgsConstructor;
import org.example.springboottest.dto.ApiResponse;
import org.example.springboottest.dto.PageResponse;
import org.example.springboottest.dto.VehicleCreateRequest;
import org.example.springboottest.dto.VehicleResponse;
import org.example.springboottest.model.Vehicle;
import org.example.springboottest.service.VehicleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    // ✅ POST
    @PostMapping
    public ApiResponse<Vehicle> create(@RequestBody VehicleCreateRequest req) {
        return ApiResponse.ok(vehicleService.createVehicle(req));
    }

    // ✅ GET pagination
    @GetMapping
    public ApiResponse<PageResponse<VehicleResponse>> getVehicles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String direction,
            @RequestParam(required = false) String keyword
    ) {

        PageResponse<VehicleResponse> result =
                vehicleService.getPagedVehicles(page, size, sortBy, direction, keyword);

        return ApiResponse.ok(result);
    }
}