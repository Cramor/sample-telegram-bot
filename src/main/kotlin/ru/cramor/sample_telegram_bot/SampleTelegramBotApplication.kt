package ru.cramor.sample_telegram_bot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BotProperties::class)
class SampleTelegramBotApplication

fun main(args: Array<String>) {
	runApplication<SampleTelegramBotApplication>(*args)
}
