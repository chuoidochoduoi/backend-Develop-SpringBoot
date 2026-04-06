package org.example.springboottest.service;

import lombok.RequiredArgsConstructor;
import org.example.springboottest.dto.PageResponse;
import org.example.springboottest.dto.VehicleCreateRequest;
import org.example.springboottest.dto.VehicleResponse;
import org.example.springboottest.model.Vehicle;
import org.example.springboottest.repository.VehicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public PageResponse<VehicleResponse> getPagedVehicles(
            int page,
            int size,
            String sortBy,
            String direction,
            String keyword) {

        if (page < 0) page = 0;

        Sort sort = Sort.unsorted();

        if (sortBy != null && direction != null) {
            if (direction.equalsIgnoreCase("ASC")) {
                sort = Sort.by(sortBy).ascending();
            } else {
                sort = Sort.by(sortBy).descending();
            }
        }

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<VehicleResponse> pageResult =
                vehicleRepository.findAllByKeyword(keyword, pageable);

        return new PageResponse<>(
                pageResult.getContent(),
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages(),
                pageResult.isLast()
        );
    }

    public Vehicle createVehicle(VehicleCreateRequest req) {
        Vehicle v = new Vehicle();
        v.setLicensePlate(req.getLicensePlate());
        v.setColor(req.getColor());
        v.setType(req.getVehicleType());
        return vehicleRepository.save(v);
    }
}