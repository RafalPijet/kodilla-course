package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WarehouseNumber1 implements ServiceOfWarehouse {

    private List<Product> productsList = new ArrayList<>();

    public WarehouseNumber1() {
        addProducts();
    }

    public boolean checkOrder(Order order) {
        Product productFromOrder;
        int check = 0;
        for (HashMap.Entry entry : order.getOrdersMap().entrySet()) {
            productFromOrder = (Product) entry.getKey();
            for (Product product : productsList) {
                if (product.getId() == productFromOrder.getId()) {
                    check++;
                }
            }
        }
        if (check == order.getOrdersMap().size()) {
            return true;
        }
        return false;
    }

    public void addProducts() {
        productsList.add(new Product(2254, "Kalafior", "Warzywa"));
        productsList.add(new Product(5623, "Power Bank", "Akcesoria"));
        productsList.add(new Product(2365, "Zeszyt A5 linia", "Biurowe"));
        productsList.add(new Product(8564, "Kinkiet ścienny 6x3", "Oświetlenie"));
        productsList.add(new Product(3698, "Telewizor SONY 50XcvER", "RTV"));
        productsList.add(new Product(1254, "Rower górski Metron ty56", "Sportowe"));
        productsList.add(new Product(6548, "Cukierki Kasztanki", "Spożywcze"));
        productsList.add(new Product(6542, "Kosiarka spalinowa Ksztuk TY5678", "Ogród"));
        productsList.add(new Product(3360, "Ekierka", "Biurowe"));
        productsList.add(new Product(5693, "Lamka biurkowa AcF10", "Oświetlenie"));
        productsList.add(new Product(7365, "Banany BIO", "Owoce"));
        productsList.add(new Product(8764, "Płyn do spryskiwacza", "Chemia"));
    }
}
