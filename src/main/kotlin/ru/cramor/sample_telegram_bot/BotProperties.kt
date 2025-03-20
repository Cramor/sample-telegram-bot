package ru.cramor.sample_telegram_bot

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource

@ConfigurationProperties(prefix = "bot")
@PropertySource("classpath:bot.properties")
data class BotProperties(var username: String, var token: String)
