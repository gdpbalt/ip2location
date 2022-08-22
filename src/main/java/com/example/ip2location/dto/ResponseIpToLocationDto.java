package com.example.ip2location.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseIpToLocationDto {
    private String canonicalIPv4Representation;
    @JsonProperty("IPv4")
    private String ip;
    private String countryName;
    private String countryCode;
    private String regionName;
    private String cityName;
    private String latitude;
    private String longitude;
}
