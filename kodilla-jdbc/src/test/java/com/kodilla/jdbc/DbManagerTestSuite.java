package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }
    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " + rs.getString("FIRSTNAME") + ", " + rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        System.out.println();
        Assert.assertEquals(5, counter);
    }
    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "SELECT U.ID, U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_QUANTITY\n" +
                "FROM USERS U, POSTS P\n" +
                "WHERE U.ID = P.USER_ID\n" +
                "GROUP BY P.USER_ID\n" +
                "HAVING COUNT(*) >= 2";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet result = statement.executeQuery(sqlQuery);
        //Then
        int counter = 0;
        while (result.next()) {
            System.out.println(result.getString("FIRSTNAME") + " " + result.getString("LASTNAME") + ", " + result.getInt("POSTS_QUANTITY"));
            counter++;
        }
        result.close();
        statement.close();
        Assert.assertEquals(3, counter);
    }
}
