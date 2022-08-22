package com.example.ip2location.repository;

import com.example.ip2location.model.IpToLocation;
import com.example.ip2location.model.IpToLocationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpToLocationRepository extends JpaRepository<IpToLocation, IpToLocationId> {
    IpToLocation getByIpFromLessThanEqualAndIpToGreaterThanEqual(Long ip, Long ipRepeated);
}
