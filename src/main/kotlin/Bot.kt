import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import repository.UserRepository

class Bot(val username: String, token: String, val repository: UserRepository) : TelegramLongPollingBot(token) {

    override fun getBotUsername(): String = username

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

    fun sendMessage(id: Long, text: String) {
        val message = SendMessage.builder().chatId(id).text(text).build()
        execute(message)
    }
}