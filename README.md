# IP2LOCATION

## Project description
This application determines location per ip address.
The application has integration test of the endpoint.

Example:
<pre>
http://servicehost/geoip/8.8.8.8
</pre>

This endpoint permits get location of ip 8.8.8.8

Output:
<pre>
{
    "IPv4": "134744072"
    "canonicalIPv4Representation": "8.8.8.8",
    "countryName": "United States of America",
    "countryCode": "US",
    "regionName": "California",
    "cityName": "Mountain View",
    "latitude": "37.405992",
    "longitude": "-122.078515",
}
</pre>

For working the application uses data from site https://lite.ip2location.com


## Project architecture
1. Controllers - Presentation layer
2. Services - Application layer
3. Repository - Data access layer

# Technologies used in project
- Spring Boot v.2.7.3
- Java v.17
- MySQL v.8
- JUnit v.5

## How to run a project?
1. Clone this project
2. Install and configure MySQL
3. Open project in IntelliJ IDEA
4. Setup database parameters in `src/main/resources/application.properties`
5. After first running you should download CSV file from 
https://lite.ip2location.com/database/db5-ip-country-region-city-latitude-longitude to local disk 
and add data from CSV to database. One of possible way it's via IDE.
- add datasource to your mysql database;
- context menu on your database name (Mouse right button);
- select "Import/Export";
- select "Import Data From File(s).."
- choose file with CVS file.
6. Now via http://localhost:8080/geoip/<ip> you can get location by ip.
