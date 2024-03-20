package com.shamolima.locationservice.LocationService.services;

import com.shamolima.locationservice.LocationService.dto.AddTrackerDTO;
import com.shamolima.locationservice.LocationService.dto.TrackerListDTO;
import com.shamolima.locationservice.LocationService.dto.ViewTrackerDTO;
import com.shamolima.locationservice.LocationService.entities.Tracker;
import com.shamolima.locationservice.LocationService.repositories.TrackerRepository;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackerServiceImpl implements TrackerService{

    private final TrackerRepository trackerRepository;

    public TrackerServiceImpl(TrackerRepository trackerRepository) {
        this.trackerRepository = trackerRepository;
    }

    @Override
    public Tracker addTracker(AddTrackerDTO addTrackerDTO) {
        Tracker tracker = Tracker.builder()
                .name(addTrackerDTO.name())
                .url(addTrackerDTO.url())
                .urlType(addTrackerDTO.urlType())
                .headers(addTrackerDTO.headers())
                .params(addTrackerDTO.params())
                .body(addTrackerDTO.body())
                .loginUrl(addTrackerDTO.loginUrl())
                .build();

        Tracker savedTracker = trackerRepository.save(tracker);
        return savedTracker;
    }

    @Override
    public ViewTrackerDTO getTracker(int id) {
        Optional<Tracker> tracker = trackerRepository.findById(id);
        Tracker t = tracker.orElseThrow(() -> new RuntimeException());
        return ViewTrackerDTO.fromTracker(t);
    }

    @Override
    public TrackerListDTO getTrackerList(@Min(0) @Max(1000) int start, @Min(1) @Max(20) int size) {
        Sort.TypedSort<Tracker> trackerSort = Sort.sort(Tracker.class);
        Sort sort = trackerSort.by(Tracker::getName)
                .descending();
        Pageable pageable = PageRequest.of(start, size, sort);

        List<Tracker> trackerList = trackerRepository.findAll(pageable).toList();

        return new TrackerListDTO(trackerList);
    }

    @Override
    public ViewTrackerDTO updateTracker(int id, AddTrackerDTO addTrackerDTO) {
        Optional<Tracker> trackerOptional = trackerRepository.findById(id);
        Tracker tracker = trackerOptional.orElseThrow();

        tracker.setName(addTrackerDTO.name());
        tracker.setUrl(addTrackerDTO.url());
        tracker.setUrlType(addTrackerDTO.urlType());
        tracker.setHeaders(addTrackerDTO.headers());
        tracker.setParams(addTrackerDTO.params());
        tracker.setBody(addTrackerDTO.body());
        tracker.setLoginUrl(addTrackerDTO.loginUrl());

        return ViewTrackerDTO.fromTracker(trackerRepository.save(tracker));
    }
}
