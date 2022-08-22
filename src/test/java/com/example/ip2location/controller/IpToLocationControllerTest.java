package com.example.ip2location.controller;

import com.example.ip2location.model.IpToLocation;
import com.example.ip2location.service.IpToLocationService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class IpToLocationControllerTest {
    private final static int HTTP_STATUS_OK = 200;
    private final static String HTTP_REQUEST_PATH = "/geoip";
    @MockBean
    private IpToLocationService ipToLocationService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void check_convertIpToLocation_ok() {
        String ip = "8.8.8.8";
        long ipNumericAddress = 134744072;
        IpToLocation mockIpToLocation = new IpToLocation();
        mockIpToLocation.setCountryName("United States of America");
        mockIpToLocation.setCountryCode("US");
        mockIpToLocation.setRegionName("California");
        mockIpToLocation.setCityName("Mountain View");
        mockIpToLocation.setLatitude(37.405992);
        mockIpToLocation.setLongitude(-122.078515);

        Mockito.when(ipToLocationService.findRecordByIp(ipNumericAddress))
                .thenReturn(mockIpToLocation);
        RestAssuredMockMvc.when()
                .get(HTTP_REQUEST_PATH + "/" + ip)
                .then()
                .statusCode(HTTP_STATUS_OK)
                .body("canonicalIPv4Representation", Matchers.equalTo(ip))
                .body("IPv4", Matchers.equalTo(String.valueOf(ipNumericAddress)))
                .body("countryName", Matchers.equalTo(mockIpToLocation.getCountryName()))
                .body("countryCode", Matchers.equalTo(mockIpToLocation.getCountryCode()))
                .body("regionName", Matchers.equalTo(mockIpToLocation.getRegionName()))
                .body("cityName", Matchers.equalTo(mockIpToLocation.getCityName()))
                .body("latitude", Matchers.equalTo(
                        String.valueOf(mockIpToLocation.getLatitude())))
                .body("longitude", Matchers.equalTo(
                        String.valueOf(mockIpToLocation.getLongitude())));
    }
}
