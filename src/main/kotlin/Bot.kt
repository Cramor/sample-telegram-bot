import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

class Bot : TelegramLongPollingBot(System.getProperty("botToken")) {

    override fun getBotUsername(): String {
        TODO("Not yet implemented")
    }

    override fun onUpdateReceived(update: Update?) {
        TODO("Not yet implemented")
    }


}