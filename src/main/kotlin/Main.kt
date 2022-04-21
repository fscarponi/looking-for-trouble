import dev.inmo.tgbotapi.bot.Ktor.telegramBot
import dev.inmo.tgbotapi.extensions.api.bot.getMe
import dev.inmo.tgbotapi.extensions.api.chat.get.getChat
import dev.inmo.tgbotapi.extensions.api.send.reply
import dev.inmo.tgbotapi.extensions.api.send.sendMessage
import dev.inmo.tgbotapi.extensions.behaviour_builder.buildBehaviour
import dev.inmo.tgbotapi.extensions.behaviour_builder.buildBehaviourWithLongPolling
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onCommand
import dev.inmo.tgbotapi.extensions.utils.updates.retrieving.retrieveAccumulatedUpdates
import dev.inmo.tgbotapi.updateshandlers.FlowsUpdatesFilter
import kotlinx.coroutines.coroutineScope


val customMessage = buildString {
    append(System.getProperty("java.vm.name"))
    append(", version ")
    append(System.getProperty("java.vm.version"))
}
val media = "https://www.tc-web.it/wp-content/uploads/2019/01/java.jpg"

@ExperimentalStdlibApi
suspend fun main(): Unit{
    println("Avvio bot looking for trouble")
    val bot = telegramBot( System.getenv("LFT_BOT_API_TOKEN"))

    bot.buildBehaviourWithLongPolling {
        println(getMe())

        onCommand("start") {
            reply(it, "Hi:)")
            sendMessage(it.chat,"random message!!")
        }
    }.join()
    println("Bot Terminato!")
}
