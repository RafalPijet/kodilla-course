package com.kodilla.testing.library;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserBooksTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTest() {
        System.out.println("POCZĄTEK ZESTAWU TESTÓW");
    }

    @AfterClass
    public static void afterAllTest() {
        System.out.println("\nKONIEC ZESTAWU TESTÓW");
    }

    @Before
    public void beforeTest() {
        testCounter++;
        System.out.println("\nRozpoczęcie przypadku testowego nr " + testCounter);
    }

    @After
    public void afterTest() {
        System.out.println("Zakończenie przypadku testowego nr " + testCounter);
    }

    @Test
    public void testZeroBooksHaveUser() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("David", "Gahan", "62020456821");
        List<Book> booksList = new ArrayList<Book>();
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(booksList);

        //When
        List<Book> answerBooksList = bookLibrary.listBooksInHandsOf(user);

        //Then
        Assert.assertEquals(0, answerBooksList.size());
    }

    @Test
    public void testOneBookHaveUser() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("Martin", "Gore", "63072489745");
        List<Book> booksList = new ArrayList<Book>();
        booksList.add(new Book("Neverending Story", "Michael Ende", 2006));
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(booksList);

        //When
        List<Book> answerBookList = bookLibrary.listBooksInHandsOf(user);

        //Then
        Assert.assertEquals(1, answerBookList.size());
    }

    @Test
    public void testFiveBooksHaveUser() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("Andrew", "Fletcher", "59061436456");
        List<Book> booksList = new ArrayList<Book>();
        for (int i = 0; i < 5; i++) {
            booksList.add(new Book("Title_" + i, "Author_" + i, 2000 + i));
        }
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(booksList);

        //When
        List<Book> answerBookList = bookLibrary.listBooksInHandsOf(user);

        //Then
        Assert.assertEquals(5, answerBookList.size());
    }
}
