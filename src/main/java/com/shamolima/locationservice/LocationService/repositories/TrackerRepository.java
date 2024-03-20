package com.shamolima.locationservice.LocationService.repositories;

import com.shamolima.locationservice.LocationService.entities.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackerRepository extends JpaRepository<Tracker, Integer> {
}
