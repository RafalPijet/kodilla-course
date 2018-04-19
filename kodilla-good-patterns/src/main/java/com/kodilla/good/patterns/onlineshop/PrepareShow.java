package com.kodilla.good.patterns.onlineshop;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class PrepareShow {

    private Food2Door food2Door = new Food2Door();
    private ProvidersProcessor providersProcessor = new ProvidersProcessor();
    private BufferedReader readData = new BufferedReader(new InputStreamReader(System.in));


    public void progress() {
        menu();
        String  answer = "";
        while (!answer.equals("k")) {
            System.out.print("Dokonaj wyboru:");
            try {
                answer = readData.readLine();
            } catch (IOException e) {
                System.out.println("Błąd danych: " + e);
            }
            if (answer.equals("1")) {
                food2Door.showProviders();
                menu();
            }
            if (answer.equals("2")) {
                NewProvider newProvider = providersProcessor.createNewProvider();
                newProvider.showOffer();
                String providerAnswer = "";
                System.out.print("Czy Pan Prezes życzy sobie, dołączyć tą firmę do naszych dostawców? ('t' lub 'n'):");
                try {
                    providerAnswer = readData.readLine();
                } catch (IOException e) {
                    System.out.println("Błąd danych: " + e);
                }
                if (providerAnswer.equals("t")) {
                    food2Door.addNewProviders(newProvider);
                    System.out.println("Prezesie, mamy nowego dostawcę!!!");
                    menu();
                } else {
                    System.out.println();
                    System.out.println("Pan Prezes odrzucił starania nowej firmy!!!");
                    menu();
                }
            }
            if (answer.equals("3")) {
                food2Door.showOurProducts();
                System.out.println();
                menu();
            }
            if (answer.equals("4")) {
                Transaction transaction = executeContract();
                if (transaction.isCompleted()) {
                    new Warehouse();
                    new Accountant();
                }
                System.out.println();
                System.out.println("Czy dostawa została zrealizowana? --> " + transaction.isCompleted());
                System.out.println();
                menu();
            }
        }
    }

    public Transaction executeContract() {
        int counter = 1;
        Transaction transaction = null;
        List<Provider> list = food2Door.getProviders();
        Map<Integer, Provider> takeProviders = new HashMap<>();
        for (Provider provider : list) {
            takeProviders.put(counter, provider);
            counter++;
        }
        System.out.println();
        takeProviders.entrySet().stream()
                .map(entry -> entry.getKey() + " --> " + entry.getValue())
                .forEach(System.out::println);
        System.out.println();
        String bossAnswer = "";
        System.out.print("Wybierz dostawcę od 1 do " + takeProviders.size() + ":");
        try {
            bossAnswer = readData.readLine();
        } catch (IOException e) {
            System.out.println("Błąd danych: " + e);
        }
        Integer index = Integer.parseInt(bossAnswer);
        for (Map.Entry entry : takeProviders.entrySet()) {
            if (entry.getKey() == index) {
                Provider selectedProvider = takeProviders.get(index);
                List<Product> providerProductsList = selectedProvider.process();
                System.out.println();
                System.out.print("Czy Pan Prezes potwierdza, realizację zamówienia? ('t' lub 'n'):");
                String confirm = "";
                try {
                    confirm = readData.readLine();
                } catch (IOException e) {
                    System.out.println("Błąd danych: " + e);
                }
                if (confirm.equals("t")) {
                    List<Product> ourProductsList = food2Door.getProducts();
                    for (Product providerProduct : providerProductsList) {
                        if (ourProductsList.contains(providerProduct)) {
                            int numberId = providerProduct.getId();
                            for (Product ourProduct : ourProductsList) {
                                if (ourProduct.getId() == numberId) {
                                    ourProduct.setQuantity(providerProduct.getQuantity());
                                }
                            }
                        } else {
                            food2Door.addProduct(providerProduct);
                        }
                    }
                    return new Transaction(selectedProvider, providerProductsList, true);
                } else {
                    System.out.println();
                    System.out.println("Pan Prezes anulował zamówienie!!!");
                    System.out.println();
                    transaction = new Transaction(selectedProvider, providerProductsList, false);
                }
            }
        }
        return transaction;
    }

    public void menu() {
        System.out.println();
        System.out.println("Panel sterujący firmy Food2Door, " + LocalDateTime.now());
        System.out.println("-------------------------------------------------------");
        System.out.println();
        System.out.println("\t1\t\t-\t\tLista dostawców");
        System.out.println();
        System.out.println("\t2\t\t-\t\tOferty nowych dostawców");
        System.out.println();
        System.out.println("\t3\t\t-\t\tStan magazynowy");
        System.out.println();
        System.out.println("\t4\t\t-\t\tWykonaj zamówienie");
        System.out.println();
        System.out.println("\tk\t\t-\t\tKONIEC PRACY");
        System.out.println();
    }
}
