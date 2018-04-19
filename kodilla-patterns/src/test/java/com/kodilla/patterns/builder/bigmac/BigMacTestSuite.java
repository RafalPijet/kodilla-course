package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;

public class BigMacTestSuite {
    @Test
    public void testBuildBigMacFirstVersion() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .giveRoll(BigMac.YES)
                .giveIngredients(Ingredients.CHEESE.getDescription())
                .giveBurgers(5)
                .giveIngredients(Ingredients.ONION.getDescription())
                .giveIngredients(Ingredients.SHRIMP.getDescription())
                .giveSauce(Sauces.THOUSAND_ISLAND.getDescription())
                .giveIngredients(Ingredients.CUCUMBER.getDescription())
                .build();
        System.out.println(bigMac);
        System.out.println();
        //When
        String result = "";
        for (String ingredient : bigMac.getIngredients()) {
            if (ingredient == "ONION") {
                result = ingredient;
            }
        }
        //Then
        Assert.assertEquals(4, bigMac.getIngredients().size());
        Assert.assertEquals(5, bigMac.getBurgers());
        Assert.assertTrue(bigMac.isSesame());
        Assert.assertEquals(Ingredients.ONION.getDescription(), result);
        Assert.assertEquals(Sauces.THOUSAND_ISLAND.getDescription(), bigMac.getSauce());
    }
    @Test
    public void testBuildBigMacSecondVersion() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .giveRoll(BigMac.NO)
                .giveIngredients(Ingredients.MUSHROOMS.getDescription())
                .giveIngredients(Ingredients.BACON.getDescription())
                .giveSauce(Sauces.BARBECUE.getDescription())
                .giveIngredients(Ingredients.CHILLI.getDescription())
                .giveIngredients(Ingredients.SALAD.getDescription())
                .build();
        System.out.println(bigMac);
        System.out.println();
        //When
        String result = bigMac.getIngredients().stream()
                .filter(i -> i.equals("BACON"))
                .collect(Collectors.joining());
        //Then
        Assert.assertEquals(4, bigMac.getIngredients().size());
        Assert.assertEquals(2, bigMac.getBurgers());
        Assert.assertFalse(bigMac.isSesame());
        Assert.assertEquals(Ingredients.BACON.getDescription(), result);
        Assert.assertEquals(Sauces.BARBECUE.getDescription(), bigMac.getSauce());

    }
}
