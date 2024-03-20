package com.shamolima.locationservice.LocationService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;

public record AddTrackerDTO(@Nonnull String name,
                            @Nonnull String url,
                            @Nonnull @JsonProperty("url_type") String urlType,
                            @Nonnull  String headers,
                            @Nonnull String params,
                            String body,
                            @JsonProperty("login_url") String loginUrl) {
}
