import com.github.lamba92.kotlingram.api.generated.InlineQueryResultPhoto
import com.github.lamba92.kotlingram.api.generated.getMe
import com.github.lamba92.kotlingram.builder.buildPollingBot
import com.github.lamba92.kotlingram.builder.respond
import com.github.lamba92.kotlingram.builder.respondPhoto
import com.github.lamba92.kotlingram.builder.respondText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.io.File


val customMessage = buildString {
    append(System.getProperty("java.vm.name"))
    append(", version ")
    append(System.getProperty("java.vm.version"))
}
val media = "https://www.tc-web.it/wp-content/uploads/2019/01/java.jpg"

@ExperimentalStdlibApi
suspend fun main(): Unit = coroutineScope {
    println("Avvio bot looking for trouble")
    buildPollingBot {

        options {
            botApiToken = System.getenv("LFT_BOT_API_TOKEN")
            botUsername = "LookingForTroubleBot"
        }

        handlers {
            messages {
                respondPhoto(
                    photo = media,
                    caption = "Hi, i'm Kotlingram JVM test bot! my master is building me but actually is busy..." +
                            "\n if you wanna help to let me become a real useful bot.. contact him on https://github.com/fscarponi",
                    replyToMessageId = message.messageId
                )
                respondText("You wrote to me \"${message.text}\", my message is $customMessage")
//                val me = api.getMe().response
            }
            inlineQueries {

                val responses = buildList {
                    repeat(10) { index ->
                        add(
                            InlineQueryResultPhoto(
                                id = "response#$index",
                                title = "Inline response #$index",
                                type = "photo",
                                photoUrl = media,
                                thumbUrl = media
                            )
                        )
                    }
                }
                respond(responses)
            }
        }
    }
    println("Bot Avviato!")
}
