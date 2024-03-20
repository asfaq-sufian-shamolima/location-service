package com.shamolima.locationservice.LocationService.services;

import com.shamolima.locationservice.LocationService.dto.AddTrackerDTO;
import com.shamolima.locationservice.LocationService.dto.TrackerListDTO;
import com.shamolima.locationservice.LocationService.dto.ViewTrackerDTO;
import com.shamolima.locationservice.LocationService.entities.Tracker;

public interface TrackerService {

    Tracker addTracker(AddTrackerDTO addTrackerDTO);
    ViewTrackerDTO getTracker(int id);
    TrackerListDTO getTrackerList(int start, int size);

    Tracker updateTracker(AddTrackerDTO addTrackerDTO);
}
