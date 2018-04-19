package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("test_001");
        //When
        String result = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("test_001", result);
    }
}
