package ru.cramor.sample_telegram_bot

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


@Configuration
@PropertySource("classpath:bot.properties")
class BotConfig {

    @Bean
    @Throws(TelegramApiException::class)
    fun telegramBotsApi(bot: Bot): TelegramBotsApi {
        val api = TelegramBotsApi(DefaultBotSession::class.java)
        api.registerBot(bot)
        return api
    }
}