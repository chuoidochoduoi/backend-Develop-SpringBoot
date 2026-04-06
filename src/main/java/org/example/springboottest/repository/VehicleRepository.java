package org.example.springboottest.repository;

import org.example.springboottest.dto.VehicleResponse;
import org.example.springboottest.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("""
        SELECT new org.example.springboottest.dto.VehicleResponse(
            v.id,
            v.licensePlate,
            v.color,
            v.type
        )
        FROM Vehicle v
        WHERE (:keyword IS NULL 
               OR LOWER(v.licensePlate) LIKE LOWER(CONCAT('%', :keyword, '%')))
    """)
    Page<VehicleResponse> findAllByKeyword(@Param("keyword") String keyword, Pageable pageable);
}