import com.github.lamba92.telegrambots.extensions.KApiContextInitializer
import com.github.lamba92.telegrambots.extensions.buildPollingBot


fun main() {
    // this will start the bot!
    println("Configurazione del bot in corso...")
    val bot = buildPollingBot {

        // customize those 2 and do not publish the token!
        botApiToken = System.getenv("LFT_BOT_API_TOKEN")
        botUsername = "LookingForTroubleBot"

        kodein { // Kodein.MainBuilder
            // kodein bindings
        }
        underlyingBot { // TelegramLongPollingBot
            // here the underlying bot is exposed
            options { //DefaultBotOptions
                // Edit here the underlying bot
                // initialization options
            }
        }

        handlers {

            // this lambda is executed every time an inline
            // query is received
            inlineQueries {

                // the respond method will send a response
                // to the user that made the request
                respond(emptyList()) { // InlineQueryResultSettings

                }
            }

            // this lambda is executed every time a message
            // is received
            messages {
                val receivedMessage=this.message
                // elaborate the data for your response here

                // the respond method will send a response
                // to the user that made the request
                respond { // SendMessage
                    // Configure your response here
                    text=receivedMessage.text
                }
            }
        }

    }
    println("avvio il bot...")

    val botSession = KApiContextInitializer {
       registerBot(bot)
    }
    println("bot avviato")


}
