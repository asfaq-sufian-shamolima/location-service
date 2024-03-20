package com.shamolima.locationservice.LocationService.dto;

import com.shamolima.locationservice.LocationService.entities.Tracker;

public record ViewTrackerDTO(int id,
                             String name,
                             String url,
                             String urlType,
                             String headers,
                             String params,
                             String body,
                             String loginUrl) {

    public static ViewTrackerDTO fromTracker(Tracker tracker) {
        return new ViewTrackerDTO(tracker.getId(), tracker.getName(), tracker.getUrl(),
                tracker.getUrlType(), tracker.getHeaders(), tracker.getParams(), tracker.getBody(), tracker.getLoginUrl());
    }
}
