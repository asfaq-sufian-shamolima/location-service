package com.shamolima.locationservice.services;

import com.shamolima.locationservice.dto.AddTrackerDTO;
import com.shamolima.locationservice.dto.TrackerListDTO;
import com.shamolima.locationservice.dto.ViewTrackerDTO;
import com.shamolima.locationservice.entities.Tracker;

public interface TrackerService {

    Tracker addTracker(AddTrackerDTO addTrackerDTO);
    ViewTrackerDTO getTracker(int id);
    TrackerListDTO getTrackerList(int start, int size);

    ViewTrackerDTO updateTracker(int id, AddTrackerDTO addTrackerDTO);
}
