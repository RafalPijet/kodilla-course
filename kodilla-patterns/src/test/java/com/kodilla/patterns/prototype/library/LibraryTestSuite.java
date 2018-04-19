package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library number 1");
        IntStream.iterate(1, b -> b + 1)
                .limit(10)
                .forEach(b -> library.getBooks().add(new Book("Title number " + b, "The same author", LocalDate.now().minusYears((long) b + 6).minusMonths((long) b).minusDays((long) b))));
        System.out.println(library.getName() + ": size = " + library.getBooks().size());
        library.getBooks().stream()
                .forEach(book -> System.out.println("\t\t\t\t: " + book));
        Library libraryShallowClone = null;
        Library libraryDeepClone = null;
        try {
            libraryShallowClone = library.shallowCopy();
            libraryShallowClone.setName("Library number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        try {
            libraryDeepClone = library.deepCopy();
            libraryDeepClone.setName("Library number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        library.getBooks().clear();
        System.out.println(library.getName() + ": size = " + library.getBooks().size());
        library.getBooks().stream()
                .forEach(book -> System.out.println("\t\t\t\t: " + book));
        System.out.println(libraryShallowClone.getName() + ": size = " + libraryShallowClone.getBooks().size());
        libraryShallowClone.getBooks().stream()
                .forEach(book -> System.out.println("\t\t\t\t: " + book));
        System.out.println(libraryDeepClone.getName() + ": size = " + libraryDeepClone.getBooks().size());
        libraryDeepClone.getBooks().stream()
                .forEach(book -> System.out.println("\t\t\t\t: " + book));
        //When
        //Then
        Assert.assertEquals(0, library.getBooks().size());
        Assert.assertEquals(0, libraryShallowClone.getBooks().size());
        Assert.assertEquals(10, libraryDeepClone.getBooks().size());
        Assert.assertEquals(library.getBooks(), libraryShallowClone.getBooks());
        Assert.assertNotEquals(library.getBooks(), libraryDeepClone.getBooks());
    }
}
