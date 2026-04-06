package org.example.springboottest.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "zones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "occupied_spots")
    private Integer occupiedSpots;

    // 👉 1 - N với ParkingTicket
    @OneToMany(mappedBy = "zone")
    private List<ParkingTicket> parkingTickets;
}