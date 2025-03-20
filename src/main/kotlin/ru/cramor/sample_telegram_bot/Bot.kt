package ru.cramor.sample_telegram_bot

import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import ru.cramor.sample_telegram_bot.repository.UserRepository


@Service
class Bot(val properties: BotProperties, val repository: UserRepository) : TelegramLongPollingBot(properties.token) {

    override fun getBotUsername(): String = properties.username

    override fun onUpdateReceived(update: Update) {
        val message = update.message
        val id = message.from.id
        if (repository.userExists(id)) {
            println("Message from someone we know ${message.from.firstName} with text ${message.text}")
        } else {
            println("Registering new guy ${message.from.firstName}")
            repository.addUser(id)
            sendMessage(id, "Привет, ${message.from.firstName}")
        }
    }

    private fun sendMessage(id: Long, text: String) {
        val message = SendMessage.builder().chatId(id).text(text).build()
        execute(message)
    }
}