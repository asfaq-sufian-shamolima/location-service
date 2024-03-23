package com.shamolima.locationservice.repositories;

import com.shamolima.locationservice.entities.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackerRepository extends JpaRepository<Tracker, Integer> {
}
