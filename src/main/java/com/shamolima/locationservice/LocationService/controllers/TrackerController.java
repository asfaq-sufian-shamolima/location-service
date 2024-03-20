package com.shamolima.locationservice.LocationService.controllers;

import com.shamolima.locationservice.LocationService.dto.AddTrackerDTO;
import com.shamolima.locationservice.LocationService.dto.TrackerListDTO;
import com.shamolima.locationservice.LocationService.dto.ViewTrackerDTO;
import com.shamolima.locationservice.LocationService.entities.Tracker;
import com.shamolima.locationservice.LocationService.services.TrackerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trackers")
public class TrackerController {

    private TrackerService trackerService;

    public TrackerController(TrackerService trackerService) {
        this.trackerService = trackerService;
    }

    @PostMapping
    public ResponseEntity<Tracker> addTracker(@RequestBody AddTrackerDTO addTrackerDTO) {
        Tracker tracker = trackerService.addTracker(addTrackerDTO);

        return new ResponseEntity<>(tracker, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewTrackerDTO> getTracker(@PathVariable int id) {
        ViewTrackerDTO tracker = trackerService.getTracker(id);

        return new ResponseEntity<>(tracker, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<TrackerListDTO> getTrackers(@RequestParam int start,
                                                      @RequestParam int size) {
        TrackerListDTO trackerList = trackerService.getTrackerList(start, size);

        return new ResponseEntity<>(trackerList, HttpStatus.OK);
    }

}
