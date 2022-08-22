package com.example.ip2location.controller;

import com.example.ip2location.dto.ResponseIpToLocationDto;
import com.example.ip2location.service.IpToLocationService;
import com.example.ip2location.service.mapper.IpToLocationMapper;
import com.example.ip2location.util.ConvertingIpFormat;
import javax.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geoip")
@RequiredArgsConstructor
@Validated
public class IpToLocationController {
    private final ConvertingIpFormat convertingIpFormat;
    private final IpToLocationService ipToLocationService;
    private final IpToLocationMapper ipToLocationMapper;

    @GetMapping("/{ipString}")
    public ResponseIpToLocationDto getLocationByIp(
            @PathVariable
            @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
            String ipString) {
        long ipNumericAddress = convertingIpFormat.convertIpStringToLong(ipString);
        ResponseIpToLocationDto responseDto =
                ipToLocationMapper.toDto(ipToLocationService.findRecordByIp(ipNumericAddress));
        responseDto.setCanonicalIPv4Representation(ipString);
        responseDto.setIp(String.valueOf(ipNumericAddress));
        return responseDto;
    }
}
