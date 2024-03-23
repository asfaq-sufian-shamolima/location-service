package com.shamolima.locationservice.controllers;

import com.shamolima.locationservice.dto.AddTrackerDTO;
import com.shamolima.locationservice.dto.TrackerListDTO;
import com.shamolima.locationservice.dto.ViewTrackerDTO;
import com.shamolima.locationservice.entities.Tracker;
import com.shamolima.locationservice.services.TrackerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trackers")
public class TrackerController {

    private final TrackerService trackerService;

    public TrackerController(TrackerService trackerService) {
        this.trackerService = trackerService;
    }

    @Operation(summary = "Create a new tracker")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "insert a new tracker in db",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Tracker.class))}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid token or body"
            )
    })
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

    @PutMapping("/{id}")
    public ResponseEntity<ViewTrackerDTO> updateTracker(@PathVariable int id,
                                                        @RequestBody AddTrackerDTO addTrackerDTO) {
        ViewTrackerDTO trackerDTO = trackerService.updateTracker(id, addTrackerDTO);

        return new ResponseEntity<>(trackerDTO, HttpStatus.OK);
    }

}
