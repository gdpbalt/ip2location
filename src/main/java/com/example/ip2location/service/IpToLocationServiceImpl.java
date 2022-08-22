package com.example.ip2location.service;

import com.example.ip2location.model.IpToLocation;
import com.example.ip2location.repository.IpToLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IpToLocationServiceImpl implements IpToLocationService {
    private final IpToLocationRepository ipToLocationRepository;

    @Override
    public IpToLocation findRecordByIp(Long ip) {
        return ipToLocationRepository.getByIpFromLessThanEqualAndIpToGreaterThanEqual(ip, ip);
    }
}
