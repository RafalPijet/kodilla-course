package com.kodilla.good.patterns.onlineshop;

import java.util.*;

public class Food2Door {

    private List<Product> products = new ArrayList<>();
    private List<Provider> providers = new ArrayList<>();

    public Food2Door() {
        MyProvider extraFoodShop = new MyProvider("ExtraFoodShop", "42-118 Koniecpol, ul. Krańcowa 12", "extrafood.biuro@gmail.com", 600123456, "Alojzy Waleczny");
        extraFoodShop.addProduct(new Product(2456, "Cebula drobna 1 kg", "warzywa", "cebula dla płączących", 54));
        extraFoodShop.addProduct(new Product(2947, "Pomidor czerwony 1 Kg", "warzywa", "pomidor twardziel wielki", 87));
        extraFoodShop.addProduct(new Product(2741, "Seler 1 szt", "warzywa", "...a to seler!", 49));
        extraFoodShop.addProduct(new Product(2145, "Ziemniaki 1 kg", "warzywa", "ziemniaczek do pieczenia idealny", 411));
        providers.add(extraFoodShop);
        MyProvider healthyShop = new MyProvider("HealthyShop", "18-552 Sianokosy Zwiędłe, ul. Zapolna 1", "bambum@me.com", 654987452, "Jarosław Maleńki");
        healthyShop.addProduct(new Product(3987, "Gruszka zielona 1 kg", "owoce", "soczysta i słodziutka", 68));
        healthyShop.addProduct(new Product(3125, "Kiwi duże 1 kg", "owoce", "to kiwi, nietylko but ożywi", 25));
        healthyShop.addProduct(new Product(3654, "Banany żółte 1 kg", "owoce", "lekko zgięty, lecz niezabardzo", 12));
        healthyShop.addProduct(new Product(3265, "Winogrono zielone drobne", "owoce", "bez pestek i słodkie", 36));
        providers.add(healthyShop);
        MyProvider glutenFreeShop = new MyProvider("GlutenFreeShop", "33-200 Gościniec, ul. Rydza 5", "biurogluten@wp.pl", 511897521, "Beata Kuna");
        glutenFreeShop.addProduct(new Product(1874, "Serek biały tłusty 1 op", "nabiał", "serek idealny na skwerek", 412));
        glutenFreeShop.addProduct(new Product(1455, "Śmietana wiejska 18% 1 op", "nabiał", "śmietanka to uśmiech poranka", 741));
        glutenFreeShop.addProduct(new Product(1654, "Ser żółty plastrowany 1 op", "nabiał", "świeży jak się należy", 325));
        glutenFreeShop.addProduct(new Product(4141, "Bułka wiejska 1szt", "pieczywo", "rozpływa się w ustach, a nie w dłoni", 3256));
        glutenFreeShop.addProduct(new Product(4587, "Bagietka długa 1szt", "pieczywo", "sztywna i chrupiąca", 1232));
        glutenFreeShop.addProduct(new Product(4691, "Chleb żytni szlachecki 1szt", "pieczywo", "chlebisko firmowe", 569));
        providers.add(glutenFreeShop);
        products.add(new Product(1234, "Mleko 3.2% odKrowy 1 litr", "nabiał", "mleczko, aż miło...", 102));
        products.add(new Product(2874, "Marchew duża 1 kg", "warzywa", "soczysta marcheweczka, palce lizać", 235));
        products.add(new Product(3478, "Jabłka czerwone Lobo 1 kg", "owoce", "wspaniałe słodkie, no no no!", 325));
        products.add(new Product(4897, "Chleb pasterski z ziarnem 1 szt", "pieczywo", "pachnący świeżutki chlebek pod masełko", 45));
    }
    public void showProviders() {
        System.out.println();
        System.out.println("Szanowny Prezesie, oto lista naszych dostawców:");
        System.out.println();
        providers.stream()
                .forEach(System.out::println);
        System.out.println();
    }

    public void showOurProducts() {
        System.out.println();
        System.out.println("Panie Prezesie oto stan magazynowy naszej firmy:");
        System.out.println();
        products.stream()
                .forEach(System.out::println);
    }

    public void addNewProviders(NewProvider newProvider) {
        providers.add(newProvider);
    }

    public List<Provider> getProviders() {
        return new ArrayList<>(providers);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
