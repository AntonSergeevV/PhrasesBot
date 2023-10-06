package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Storage {
    private final List<String> quoteList = List.of(
            "Начинать всегда стоит с того, что сеет сомнения.",
            "80% успеха - это появиться в нужном месте в нужное время.",
            "Мы должны признать очевидное: понимают лишь те, кто хочет понять.",
            "Верь в себя и в то, что делаешь."
    );

    private final Random random = new Random();

    public String getRandQuote() {
        int randValue = random.nextInt(quoteList.size());
        return quoteList.get(randValue);
    }

    public void add(String quote) {
        quoteList.add(quote);
    }
}

