package org.example;

import sun.net.ftp.FtpClient;

import java.util.ArrayList;

public class Storage {
    private final ArrayList<String> quoteList;

    Storage() {
        quoteList = new ArrayList<>();
        quoteList.add("Начинать всегда стоит с того, что сеет сомнения. \n\nБорис Стругацкий.");
        quoteList.add("80% успеха - это появиться в нужном месте в нужное время.\n\nВуди Аллен");
        quoteList.add("Мы должны признать очевидное: понимают лишь те,кто хочет понять.\n\nБернар Вербер");
        quoteList.add("Верь в себя и в то что делаешь. \n\nНет автора");
    }

    String getRandQuote() {

        int randValue = (int) (Math.random() * quoteList.size());

        return quoteList.get(randValue);
    }


}

