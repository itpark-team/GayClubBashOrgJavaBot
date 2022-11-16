package com.company.bot;

import com.company.service.BashorgService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotInitializer extends TelegramLongPollingBot {

    private BashorgService bashorgService;

    public BotInitializer() {
        bashorgService = new BashorgService();
    }

    @Override
    public String getBotUsername() {
        return "GayClubBlueAndroid2020";
    }

    @Override
    public String getBotToken() {
        return "5384747123:AAHYso67z4GII5nTy0lnv2o8mth73OS2Kxw";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            long chatId = update.getMessage().getChatId();
            String textData = update.getMessage().getText();

            try {
                SendMessage message = bashorgService.getRandomJoke(chatId, textData);
                execute(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
