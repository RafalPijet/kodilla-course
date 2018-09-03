package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args){
        System.out.println("Lista wszystkich użytkowników forum: ");
        Forum.getUsersList().stream()
                .forEach(System.out::println);
        System.out.println();
        System.out.println("Mapa użytkowników forum po zastosowaniu filtrowania: ");
        Map<Integer, ForumUser> usersMap1 = Forum.getUsersList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> LocalDate.now().compareTo(forumUser.getBirthDate()) >= 20)
                .filter(forumUser -> forumUser.getPostQuantity() > 0)
                .collect(Collectors.toMap(forumUser -> forumUser.getUserID(), forumUser -> forumUser ));

        usersMap1.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
        System.out.println();
        System.out.println();
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String exampleText = "Jestem sobie wesoły Romek i mam na przedmieściu domek.";
        System.out.println("Oryginalny tekst: " + exampleText);
        poemBeautifier.beautify(exampleText, text -> text.toUpperCase());
        poemBeautifier.beautify(exampleText, text -> text.toLowerCase());
        poemBeautifier.beautify(exampleText, text -> text.concat("\b\b\b\b\b\b\b chatę."));
        poemBeautifier.beautify(exampleText, text -> text.substring(13, 25).concat(" ma domek"));
        poemBeautifier.beautify(exampleText, text -> text.replace("Jestem", "Byłem").replace("mam", "miałem"));
        poemBeautifier.beautify(exampleText, text -> text.replaceFirst("m", "ś").substring(0, 28).concat("już!"));
    }
}
