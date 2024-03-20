package com.shamolima.locationservice.LocationService.services;

import com.shamolima.locationservice.LocationService.dto.AddTrackerDTO;
import com.shamolima.locationservice.LocationService.dto.TrackerListDTO;
import com.shamolima.locationservice.LocationService.dto.ViewTrackerDTO;
import com.shamolima.locationservice.LocationService.entities.Tracker;
import com.shamolima.locationservice.LocationService.repositories.TrackerRepository;
import org.springframework.stereotype.Service;

@Service
public class TrackerServiceImpl implements TrackerService{

    private TrackerRepository trackerRepository;

    public TrackerServiceImpl(TrackerRepository trackerRepository) {
        this.trackerRepository = trackerRepository;
    }

    @Override
    public Tracker addTracker(AddTrackerDTO addTrackerDTO) {
        return null;
    }

    @Override
    public ViewTrackerDTO getTracker(int id) {
        return null;
    }

    @Override
    public TrackerListDTO getTrackerList(int start, int size) {
        return null;
    }

    @Override
    public Tracker updateTracker(AddTrackerDTO addTrackerDTO) {
        return null;
    }
}
