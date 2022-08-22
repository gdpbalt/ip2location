package com.example.ip2location.service;

import com.example.ip2location.model.IpToLocation;

public interface IpToLocationService {
    IpToLocation findRecordByIp(Long ip);
}
