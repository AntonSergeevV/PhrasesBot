package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class Bot extends TelegramLongPollingBot {
    final private String BOT_TOKEN = "6216144261:AAEsP8D-ZsiBtTtC0dca5sS1A8RqGrvQkAY";
    final private String BOT_NAME = "MDASergeevAnton_bot";
    Storage storage;
    private ReplyKeyboardMarkup replyKeyboardMarkup;

    Bot() {
        storage = new Storage();
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage outMess = null;
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {

                Message inMess = update.getMessage();

                String chatId = inMess.getChatId().toString();

                String response = parseMessage(inMess.getText());

                outMess = new SendMessage();


                outMess.setChatId(chatId);
                outMess.setText(response);


                execute(outMess);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        if (outMess != null) {
            outMess.setReplyMarkup(replyKeyboardMarkup);
        }

    }

    public String parseMessage(String textMsg) {
        String response;


        if (textMsg.equals("/start"))
            response = "Приветствую, бот знает много цитат. Жми /get, чтобы получить случайную из них";
        else if (textMsg.equals("/get") || textMsg.equals("Просвяти"))
            response = storage.getRandQuote();
        else
            response = "Сообщение не распознано";

        return response;
    }

    void initKeyboard() {

        replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);


        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);

        keyboardRow.add(new KeyboardButton("Просвяти"));

        replyKeyboardMarkup.setKeyboard(keyboardRows);

    }


}
