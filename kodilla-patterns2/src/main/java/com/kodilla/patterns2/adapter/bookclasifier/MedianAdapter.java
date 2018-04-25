package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookA;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookB;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    private Map<BookSignature, BookB> bookBMap = new HashMap<>();
    @Override
    public int publicationYearMedian(Set<BookA> bookASet) {
        for (BookA bookA : bookASet) {
            bookBMap.put(new BookSignature(bookA.getSignature()), new BookB(bookA.getAuthor(), bookA.getTitle(), bookA.getPublicationYear()));
        }
        return medianPublicationYear(bookBMap);
    }
    public int publicationYearAverage(Set<BookA> bookASet) {
        for (BookA bookA : bookASet) {
            bookBMap.put(new BookSignature(bookA.getSignature()), new BookB(bookA.getAuthor(), bookA.getTitle(), bookA.getPublicationYear()));
        }
        return averagePublicationYear(bookBMap);
    }

    public Map<BookSignature, BookB> getBookBMap() {
        return bookBMap;
    }
}
