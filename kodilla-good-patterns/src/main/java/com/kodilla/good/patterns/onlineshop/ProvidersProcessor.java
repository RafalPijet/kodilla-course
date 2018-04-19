package com.kodilla.good.patterns.onlineshop;

import java.util.*;
import java.util.stream.Collectors;

public class ProvidersProcessor {

    private List<Product> newProducts = new ArrayList<>();

    public ProvidersProcessor() {
        newProducts.add(new Product(1235, "Mleko 2% łaciate 1 litr", "nabiał", "mleczko, aż miło...", 77));
        newProducts.add(new Product(1249, "Mleko 0% extraLite 1 litr", "nabiał", "mleczko, aż miło...", 88));
        newProducts.add(new Product(2875, "Marchew drobna twarda 1 kg", "warzywa", "soczysta marcheweczka, palce lizać", 135));
        newProducts.add(new Product(2874, "Brokuł hiszpański 1 kg", "warzywa", "mały kalafiorek, palce lizać", 145));
        newProducts.add(new Product(3479, "Jabłka zielone Legok 1 kg", "owoce", "wspaniałe słodkie, no no no!", 425));
        newProducts.add(new Product(3568, "Pomarańcze Maroco 1 kg", "owoce", "wspaniałe soczyste, bez pestek", 525));
        newProducts.add(new Product(3478, "Truskawki polskie 1 kg", "owoce", "wspaniałe słodkie, a jak!", 525));
        newProducts.add(new Product(2478, "Cukinia 1 kg", "warzywa", "wyjątkowo wydajna, z Niemiec", 465));
        newProducts.add(new Product(4797, "Chleb razowy ze słonecznikiem 1 szt", "pieczywo", "pachnący świeżutki chlebek pod masełko", 145));
        newProducts.add(new Product(4899, "Chleb chłopski na zakwasie 1 szt", "pieczywo", "pachnący świeżutki chlebek", 248));
    }

    public NewProvider createNewProvider() {

        String[] companyNames = {"FreshFood", "HealtyField", "Golden Vegetables", "Clean Food", "Only Health", "Oh Ah EAT", "Good Food Comp", "FoodFrom HEAVEN"};
        String[] companyAddress = {"12-318 Krasocin, ul. Kartoflana 22", "89-934 Poczesna, ul. Sportowa 2", "27-219 Adamów, ul. Zwyczajna 117", "52-121 Macki Małe, ul. Nowa 5"};
        String[] companyEmail = {"maszek123@op.eu", "jolek.bolek@gmail.com", "sitek@me.com", "jack.mac@wp.pl", "zenek3@ypo.com", "trelek@gryf.com"};
        String[] companyPerson = {"Bolek Lolek", "Stenia Jasna", "Roman Warcabek", "Jadwiga Mała", "Roksana Wielka", "Marek Borek", "Marta Ciołek"};

        Random generator = new Random();
        String textNumber = "60";
        for (int i = 0; i < 7; i++) {
            textNumber += generator.nextInt(10);
        }
        int phoneNumber = Integer.parseInt(textNumber);
        Set<Product> randomProducts = new HashSet<>();
        for (int i = 0; i < (generator.nextInt(newProducts.size()) + 1); i++) {
            randomProducts.add(newProducts.get(generator.nextInt(newProducts.size())));
        }
        List<Product> productsList = randomProducts.stream()
                .collect(Collectors.toList());
        return new NewProvider(companyNames[generator.nextInt(companyNames.length)], companyAddress[generator.nextInt(companyAddress.length)], companyEmail[generator.nextInt(companyEmail.length)], phoneNumber, companyPerson[generator.nextInt(companyPerson.length)], productsList);

    }
}
