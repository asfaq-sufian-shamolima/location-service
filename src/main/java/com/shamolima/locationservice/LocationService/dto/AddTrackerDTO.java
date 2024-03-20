package com.shamolima.locationservice.LocationService.dto;

import jakarta.annotation.Nonnull;

public record AddTrackerDTO(@Nonnull String name,
                            @Nonnull String url,
                            @Nonnull String urlType,
                            @Nonnull  String headers,
                            @Nonnull String params,
                            String body,
                            String loginUrl) {
}
