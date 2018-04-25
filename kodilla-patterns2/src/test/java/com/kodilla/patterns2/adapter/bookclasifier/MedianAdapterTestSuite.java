package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookA;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

public class MedianAdapterTestSuite {
    @Test
    public void testPublicationYearMedianWithEvenQuantity() {
        //Given
        Set<BookA> bookASet = new HashSet<>();
        bookASet.add(new BookA("E.L. James", "50 shades of Grey", 2006, "J/2006/02/1324"));
        bookASet.add(new BookA("Arthur Conan Doyle", "Sherlock Holmes", 2001, "D/2001/06/3421"));
        bookASet.add(new BookA("James Fenimore Cooper", "The Last Mohikan", 2003, "C/2003/10/1239"));
        bookASet.add(new BookA("Jules Verne", "A Journey Into the Earth", 2009, "V/2009/04/23"));
        bookASet.add(new BookA("Michael Ende", "Neverending Story", 2007, "E/2007/08/567"));
        bookASet.add(new BookA("Rudyard Kipling", "Book of Jungle", 2008, "K/2008/08/1154"));
        //When
        MedianAdapter medianAdapter = new MedianAdapter();
        int result = medianAdapter.publicationYearMedian(bookASet);
        int quantityBooks = medianAdapter.getBookBMap().size();
        //Then
        assertEquals(6, quantityBooks);
        assertEquals(2007, result);
    }
    @Test
    public void testPublicationYearMedianWithOddQuantity() {
        //Given
        Set<BookA> bookASet = new HashSet<>();
        bookASet.add(new BookA("E.L. James", "50 shades of Grey", 2006, "J/2006/02/1324"));
        bookASet.add(new BookA("Arthur Conan Doyle", "Sherlock Holmes", 2001, "D/2001/06/3421"));
        bookASet.add(new BookA("James Fenimore Cooper", "The Last Mohikan", 2003, "C/2003/10/1239"));
        bookASet.add(new BookA("Jules Verne", "A Journey Into the Earth", 2009, "V/2009/04/23"));
        bookASet.add(new BookA("Michael Ende", "Neverending Story", 2007, "E/2007/08/567"));
        //When
        MedianAdapter medianAdapter = new MedianAdapter();
        int result = medianAdapter.publicationYearMedian(bookASet);
        int quantityBooks = medianAdapter.getBookBMap().size();
        //Then
        assertEquals(5, quantityBooks);
        assertEquals(2006, result);
    }
    @Test
    public void testPublicationYearAverage() {
        //Given
        Set<BookA> bookASet = new HashSet<>();
        bookASet.add(new BookA("E.L. James", "50 shades of Grey", 2006, "J/2006/02/1324"));
        bookASet.add(new BookA("Arthur Conan Doyle", "Sherlock Holmes", 2001, "D/2001/06/3421"));
        bookASet.add(new BookA("James Fenimore Cooper", "The Last Mohikan", 2003, "C/2003/10/1239"));
        bookASet.add(new BookA("Jules Verne", "A Journey Into the Earth", 2009, "V/2009/04/23"));
        bookASet.add(new BookA("Michael Ende", "Neverending Story", 2007, "E/2007/08/567"));
        bookASet.add(new BookA("Rudyard Kipling", "Book of Jungle", 2008, "K/2008/08/1154"));
        //When
        MedianAdapter medianAdapter = new MedianAdapter();
        int result = medianAdapter.publicationYearAverage(bookASet);
        int quantityBooks = medianAdapter.getBookBMap().size();
        //Then
        assertEquals(6, quantityBooks);
        assertEquals(2005, result);
    }
}
