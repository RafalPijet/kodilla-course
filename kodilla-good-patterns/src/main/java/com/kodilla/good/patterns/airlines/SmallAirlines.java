package com.kodilla.good.patterns.airlines;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmallAirlines {

    private final String COMPANY_NAME = "FAST Airlines";
    private List<Airport> airports = new ArrayList<>();

    public SmallAirlines() {
        createCompany();
        System.out.println("\nWitamy w wyszukiwarce lotów firmy \"" + COMPANY_NAME + "\"\n");
    }

    public void createCompany() {

        Airport katowice = new Airport("Katowice");
        Airport warszawa = new Airport("Warszawa");
        Airport krakow = new Airport("Kraków");
        Airport lublin = new Airport("Lublin");
        Airport wroclaw = new Airport("Wrocław");
        Airport poznan = new Airport("Poznań");
        Airport szczecin = new Airport("Szczecin");
        Airport gdansk = new Airport("Gdańsk");

        katowice.addDeparture(new Departure(1006, new Airplane("Airbus A320", "AB010", 26), katowice, warszawa));
        warszawa.addArrival(new Arrival(1040, new Airplane("Airbus A320", "AB010", 26), katowice, warszawa));
        katowice.addDeparture(new Departure(1516, new Airplane("Airbus A320", "AB020", 46), katowice, warszawa));
        warszawa.addArrival(new Arrival(1557, new Airplane("Airbus A320", "AB020", 46), katowice, warszawa));
        katowice.addDeparture(new Departure(2059, new Helicopter("Sikorsky S-76", "SS010", 12), katowice, warszawa));
        warszawa.addArrival(new Arrival(2149, new Helicopter("Sikorsky S-76", "SS010", 12), katowice, warszawa));
        katowice.addDeparture(new Departure(505, new Blimp("Zeppelin Z 300", "ZZ010", 123), katowice, krakow));
        krakow.addArrival(new Arrival(645, new Blimp("Zeppelin Z 300", "ZZ010", 123), katowice, krakow));
        katowice.addDeparture(new Departure(1116, new Helicopter("Eurocopter A S350", "EU020", 5), katowice, krakow));
        krakow.addArrival(new Arrival(1139, new Helicopter("Eurocopter A S350", "EU020", 5), katowice, krakow));
        katowice.addDeparture(new Departure(1720, new Airplane("Boeing B737-200", "BB040", 32), katowice, krakow));
        krakow.addArrival(new Arrival(1757, new Airplane("Boeing B737-200", "BB040", 32), katowice, krakow));
        katowice.addDeparture(new Departure(102, new Airplane("Boeing B737-600", "BB010", 15), katowice, lublin));
        lublin.addArrival(new Arrival(207, new Airplane("Boeing B737-600", "BB010", 15), katowice, lublin));
        katowice.addDeparture(new Departure(1419, new Blimp("Zeppelin Z 300", "ZZ020", 76), katowice, wroclaw));
        wroclaw.addArrival(new Arrival(1709, new Blimp("Zeppelin Z 300", "ZZ020", 76), katowice, wroclaw));
        katowice.addDeparture(new Departure(1609, new Airplane("Boeing B737-200", "BB040", 77), katowice, poznan));
        poznan.addArrival(new Arrival(1648, new Airplane("Boeing B737-200", "BB040", 77), katowice, poznan));
        katowice.addDeparture(new Departure(328, new Airplane("Airbus A320", "AB030", 105), katowice, szczecin));
        szczecin.addArrival(new Arrival(415, new Airplane("Airbus A320", "AB030", 105), katowice, szczecin));
        katowice.addDeparture(new Departure(1311, new Airplane("Airbus A320", "AB040", 54), katowice, gdansk));
        gdansk.addArrival(new Arrival(1418, new Airplane("Airbus A320", "AB040", 54), katowice, gdansk));
        warszawa.addDeparture(new Departure(620, new Blimp("Zeppelin Z 300", "ZZ030", 251), warszawa, katowice));
        katowice.addArrival(new Arrival(850, new Blimp("Zeppelin Z 300", "ZZ030", 251), warszawa, katowice));
        warszawa.addDeparture(new Departure(1525, new Helicopter("Eurocopter A S350", "EU010", 5), warszawa, gdansk));
        gdansk.addArrival(new Arrival(1658, new Helicopter("Eurocopter A S350", "EU010", 5), warszawa, gdansk));
        warszawa.addDeparture(new Departure(1112, new Airplane("Boeing B737-200", "BB050", 48), warszawa, szczecin));
        szczecin.addArrival(new Arrival(1205, new Airplane("Boeing B737-200", "BB050", 48), warszawa, szczecin));
        warszawa.addDeparture(new Departure(750, new Helicopter("Sikorsky S-76", "SS010", 12), warszawa, wroclaw));
        wroclaw.addArrival(new Arrival(858, new Helicopter("Sikorsky S-76", "SS010", 12), warszawa, wroclaw));
        krakow.addDeparture(new Departure(1102, new Helicopter("Eurocopter A S350", "EU010", 5), krakow, katowice));
        katowice.addArrival(new Arrival(1138, new Helicopter("Eurocopter A S350", "EU010", 5), krakow, katowice));
        krakow.addDeparture(new Departure(1709, new Airplane("Airbus A320", "AB040", 73), krakow, gdansk));
        gdansk.addArrival(new Arrival(1811, new Airplane("Airbus A320", "AB040", 73), krakow, gdansk));
        krakow.addDeparture(new Departure(908, new Helicopter("Eurocopter A S350", "EU030", 5), krakow, warszawa));
        warszawa.addArrival(new Arrival(957, new Helicopter("Eurocopter A S350", "EU030", 5), krakow, warszawa));
        krakow.addDeparture(new Departure(2109, new Airplane("Airbus A320", "AB140", 23), krakow, szczecin));
        szczecin.addArrival(new Arrival(2241, new Airplane("Airbus A320", "AB140", 23), krakow, szczecin));
        lublin.addDeparture(new Departure(1011, new Airplane("Boeing B737-600", "BB030", 99), lublin, szczecin));
        szczecin.addArrival(new Arrival(1118, new Airplane("Boeing B737-600", "BB030", 99), lublin, szczecin));
        lublin.addDeparture(new Departure(1416, new Helicopter("Sikorsky S-76", "SS020", 12), lublin, warszawa));
        warszawa.addArrival(new Arrival(1501, new Helicopter("Sikorsky S-76", "SS020", 12), lublin, warszawa));
        lublin.addDeparture(new Departure(2216, new Airplane("Boeing B737-600", "BB020", 65), lublin, wroclaw));
        wroclaw.addArrival(new Arrival(2306, new Airplane("Boeing B737-600", "BB020", 65), lublin, wroclaw));
        lublin.addDeparture(new Departure(711, new Airplane("Boeing B737-600", "BB130", 19), lublin, poznan));
        poznan.addArrival(new Arrival(758, new Airplane("Boeing B737-600", "BB130", 19), lublin, poznan));
        wroclaw.addDeparture(new Departure(856, new Helicopter("Sikorsky S-76", "SS030", 12), wroclaw, szczecin));
        szczecin.addArrival(new Arrival(948, new Helicopter("Sikorsky S-76", "SS030", 12), wroclaw, szczecin));
        wroclaw.addDeparture(new Departure(1316, new Airplane("Boeing B737-200", "BB060", 43), wroclaw, katowice));
        katowice.addArrival(new Arrival(1354, new Airplane("Boeing B737-200", "BB060", 43), wroclaw, katowice));
        wroclaw.addDeparture(new Departure(1805, new Airplane("Airbus A320", "AB050", 32), wroclaw, warszawa));
        warszawa.addArrival(new Arrival(1549, new Airplane("Airbus A320", "AB050", 32), wroclaw, warszawa));
        wroclaw.addDeparture(new Departure(1402, new Helicopter("Sikorsky S-76", "SS091", 12), wroclaw, krakow));
        krakow.addArrival(new Arrival(1538, new Helicopter("Sikorsky S-76", "SS091", 12), wroclaw, krakow));
        wroclaw.addDeparture(new Departure(1018, new Airplane("Boeing B737-200", "BB164", 53), wroclaw, gdansk));
        gdansk.addArrival(new Arrival(1104, new Airplane("Boeing B737-200", "BB164", 53), wroclaw, gdansk));
        wroclaw.addDeparture(new Departure(1258, new Airplane("Boeing B737-200", "BB364", 53), wroclaw, lublin));
        lublin.addArrival(new Arrival(1404, new Airplane("Boeing B737-200", "BB364", 53), wroclaw, lublin));
        wroclaw.addDeparture(new Departure(1628, new Airplane("Boeing B737-200", "BB464", 59), wroclaw, poznan));
        poznan.addArrival(new Arrival(1701, new Airplane("Boeing B737-200", "BB464", 59), wroclaw, poznan));
        poznan.addDeparture(new Departure(702, new Helicopter("Sikorsky S-76", "SS040", 12), poznan, katowice));
        katowice.addArrival(new Arrival(757, new Helicopter("Sikorsky S-76", "SS040", 12), poznan, katowice));
        poznan.addDeparture(new Departure(1208, new Blimp("Zeppelin Z 300", "ZZ040", 135), poznan, gdansk));
        gdansk.addArrival(new Arrival(1358, new Blimp("Zeppelin Z 300", "ZZ040", 135), poznan, gdansk));
        poznan.addDeparture(new Departure(2120, new Airplane("Airbus A320", "AB050", 87), poznan, warszawa));
        warszawa.addArrival(new Arrival(2201, new Airplane("Airbus A320", "AB050", 87), poznan, warszawa));
        poznan.addDeparture(new Departure(2340, new Airplane("Airbus A320", "AB092", 77), poznan, szczecin));
        szczecin.addArrival(new Arrival(101, new Airplane("Airbus A320", "AB092", 77), poznan, szczecin));
        poznan.addDeparture(new Departure(908, new Blimp("Zeppelin Z 300", "ZZ050", 102), poznan, lublin));
        lublin.addArrival(new Arrival(1208, new Blimp("Zeppelin Z 300", "ZZ050", 102), poznan, lublin));
        poznan.addDeparture(new Departure(1900, new Airplane("Airbus A320", "AB093", 27), poznan, krakow));
        krakow.addArrival(new Arrival(1935, new Airplane("Airbus A320", "AB093", 27), poznan, krakow));
        poznan.addDeparture(new Departure(402, new Helicopter("Sikorsky S-76", "SS090", 12), poznan, wroclaw));
        wroclaw.addArrival(new Arrival(508, new Helicopter("Sikorsky S-76", "SS090", 12), poznan, wroclaw));
        szczecin.addDeparture(new Departure(905, new Airplane("Airbus A320", "AB060", 27), szczecin, katowice));
        katowice.addArrival(new Arrival(955, new Airplane("Airbus A320", "AB060", 27), szczecin, katowice));
        szczecin.addDeparture(new Departure(1256, new Helicopter("Sikorsky S-76", "SS050", 12), szczecin, warszawa));
        warszawa.addArrival(new Arrival(1411, new Helicopter("Sikorsky S-76", "SS050", 12), szczecin, warszawa));
        szczecin.addDeparture(new Departure(856, new Helicopter("Sikorsky S-76", "SS080", 12), szczecin, wroclaw));
        wroclaw.addArrival(new Arrival(1001, new Helicopter("Sikorsky S-76", "SS080", 12), szczecin, wroclaw));
        szczecin.addDeparture(new Departure(1905, new Airplane("Airbus A320", "AB090", 35), szczecin, poznan));
        poznan.addArrival(new Arrival(1955, new Airplane("Airbus A320", "AB090", 35), szczecin, poznan));
        szczecin.addDeparture(new Departure(108, new Airplane("Airbus A320", "AB091", 27), szczecin, lublin));
        lublin.addArrival(new Arrival(159, new Airplane("Airbus A320", "AB091", 27), szczecin, lublin));
        gdansk.addDeparture(new Departure(1105, new Airplane("Boeing B737-200", "BB070", 63), gdansk, katowice));
        katowice.addArrival(new Arrival(1203, new Airplane("Boeing B737-200", "BB070", 63), gdansk, katowice));
        gdansk.addDeparture(new Departure(1525, new Helicopter("Sikorsky S-76", "SS060", 12), gdansk, warszawa));
        warszawa.addArrival(new Arrival(1608, new Helicopter("Sikorsky S-76", "SS060", 12), gdansk, warszawa));
        gdansk.addDeparture(new Departure(436, new Airplane("Airbus A320", "AB070", 47), gdansk, poznan));
        poznan.addArrival(new Arrival(501, new Airplane("Airbus A320", "AB070", 47), gdansk, poznan));
        gdansk.addDeparture(new Departure(1136, new Airplane("Airbus A320", "AB080", 87), gdansk, lublin));
        lublin.addArrival(new Arrival(1205, new Airplane("Airbus A320", "AB080", 87), gdansk, lublin));
        gdansk.addDeparture(new Departure(1546, new Helicopter("Sikorsky S-76", "SS070", 12), gdansk, szczecin));
        szczecin.addArrival(new Arrival(1635, new Helicopter("Sikorsky S-76", "SS070", 12), gdansk, szczecin));
        gdansk.addDeparture(new Departure(1126, new Airplane("Boeing B737-200", "BB090", 58), gdansk, krakow));
        krakow.addArrival(new Arrival(1202, new Airplane("Boeing B737-200", "BB090", 58), gdansk, krakow));


        airports.add(katowice);
        airports.add(warszawa);
        airports.add(krakow);
        airports.add(lublin);
        airports.add(wroclaw);
        airports.add(poznan);
        airports.add(szczecin);
        airports.add(gdansk);
    }

    public List<Airport> getAirports() {
        return airports;
    }
}
