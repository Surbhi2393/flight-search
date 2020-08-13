# Flight Search Engine

Steps to run the application:

1. Run /flightsearch/src/main/java/com/flights/flightsearch/FlightsearchApplication.java as a Java Application, which will start the server of the SpringBoot Application.
2. Run /flightsearch/src/main/resources/flightDetails.sql in MySQL to create database with dummy values.
3. Edit the properties in /flightsearch/src/main/resources/application.properties, if required.
3. Try hitting the service from browser or PostMan using URL like http://localhost:9090/searchFlights?source=Bangalore&destination=Chennai&travelDate=2020-07-02T11:50:55
4. Output will be a JSON containing list of flights and the total number of files.
