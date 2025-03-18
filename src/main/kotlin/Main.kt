import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import repository.UserRepository

fun main() {
    val bot = Bot(System.getProperty("bot.username"), System.getProperty("bot.token"), UserRepository())
    println("SYSTEM Bot name ${System.getProperty("bot.username")} and token ${System.getProperty("bot.token")}")
    val botsApi = TelegramBotsApi(DefaultBotSession::class.java)
    botsApi.registerBot(bot)
}