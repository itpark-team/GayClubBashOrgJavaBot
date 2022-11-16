package com.company.service;

import com.company.site.BashorgParser;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class BashorgService {
    private BashorgParser bashorgParser;

    public BashorgService() {
        this.bashorgParser = new BashorgParser();
    }

    public SendMessage getRandomJoke(long chatId, String textData) throws Exception {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);

        if (textData.equals("/quote")) {
            message.setText(bashorgParser.getRandomQuote());
        } else {
            message.setText("Команда не распознана. Введите /quote для выдачи цитаты");
        }

        return message;
    }
}
