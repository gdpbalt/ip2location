package com.example.ip2location.service.mapper;

import com.example.ip2location.dto.ResponseIpToLocationDto;
import com.example.ip2location.model.IpToLocation;
import org.springframework.stereotype.Component;

@Component
public class IpToLocationMapper {

    public ResponseIpToLocationDto toDto(IpToLocation ipToLocation) {
        ResponseIpToLocationDto dto = new ResponseIpToLocationDto();
        dto.setCountryName(ipToLocation.getCountryName());
        dto.setCountryCode(ipToLocation.getCountryCode());
        dto.setRegionName(ipToLocation.getRegionName());
        dto.setCityName(ipToLocation.getCityName());
        dto.setLatitude(String.valueOf(ipToLocation.getLatitude()));
        dto.setLongitude(String.valueOf(ipToLocation.getLongitude()));
        return dto;
    }
}
