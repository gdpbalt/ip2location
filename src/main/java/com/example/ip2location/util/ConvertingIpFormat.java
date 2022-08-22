package com.example.ip2location.util;

import org.springframework.stereotype.Component;

@Component
public class ConvertingIpFormat {

    public long convertIpStringToLong(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");
        long result = 0;
        long power = 1;
        for (int i = ipAddressInArray.length - 1; i >= 0 ; i--) {
            int ipPart = Integer.parseInt(ipAddressInArray[i]);
            result += ipPart * power;
            power *= 256;
        }
        return result;
    }
}
