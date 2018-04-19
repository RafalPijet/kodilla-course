package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User jennifer = new Milenials("Jennifer Connelly");
        User camilla = new YGeneration("Camilla Belle");
        User scarlett = new ZGeneration("Scarlett Johansson");
        //When
        String janniferUse = jennifer.sharePost();
        System.out.println("Jannifer say: " + janniferUse);
        String camillaUse = camilla.sharePost();
        System.out.println("Camilla say: " + camillaUse);
        String scarletUse = scarlett.sharePost();
        System.out.println("Scarlett say: " + scarletUse);
        //Then
        Assert.assertEquals("I use Facebook to share information", janniferUse);
        Assert.assertEquals("I use Twitter to share information", camillaUse);
        Assert.assertEquals("I use Snapchat to share information", scarletUse);
    }
    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User jennifer = new Milenials("Jennifer Connelly");
        //When
        String janniferUse = jennifer.sharePost();
        System.out.println("Jannifer say: " + janniferUse);
        jennifer.changePublisher(new TwitterPublisher());
        janniferUse = jennifer.sharePost();
        System.out.println("Jannifer say: " + janniferUse);
        //Then
        Assert.assertEquals("I use Twitter to share information", janniferUse);
    }
}
