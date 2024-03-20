package com.shamolima.locationservice.LocationService.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Tracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String urlType;

    @Column(nullable = false)
    private String headers;

    @Column(nullable = false)
    private String params;

    private String body;
    private String loginUrl;
}
