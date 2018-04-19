package com.kodilla.good.patterns.airlines;

import java.util.Random;

public class PrepareShow {

    private CorporateAirConnections corporateAirConnections = new CorporateAirConnections();

    public void progress() {
        Random genearor = new Random();
        String[] airports = {"Katowice", "Warszawa", "Kraków", "Lublin", "Wrocław", "Poznań", "Szczecin", "Gdańsk"};
        System.out.println();
        for (int i = 0; i < airports.length; i++) {
            System.out.println();
            System.out.println("Wykaz połączeń dla lotniska --> " + airports[i] + " ------------------------------------------");
            corporateAirConnections.showArrivals(corporateAirConnections.findArrivals(airports[i]));
            System.out.println();
            corporateAirConnections.showDepartures(corporateAirConnections.findDepartures(airports[i]));
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------");
        }
        int from, to, between;
        for (int i = 0; i < airports.length; i++) {
            from = 0;
            to = 0;
            between = 0;
            while (!((from != to) & (from != between) & (to != between))) {
                from = genearor.nextInt(airports.length);
                to = genearor.nextInt(airports.length);
                between = genearor.nextInt(airports.length);
            }
            System.out.println();
            System.out.println("Wykaz połączeń z " + airports[from] + " przez " + airports[between] + " do " + airports[to] + " ------------------------------");
            corporateAirConnections.betweenConnections(airports[from], airports[between], airports[to]);
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------");
        }
    }
}
