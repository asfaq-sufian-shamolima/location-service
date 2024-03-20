package com.shamolima.locationservice.LocationService.dto;

public record ViewTrackerDTO(int id,
                             String name,
                             String url,
                             String urlType,
                             String headers,
                             String params,
                             String body,
                             String loginUrl) {
}
