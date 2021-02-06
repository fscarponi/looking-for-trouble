package bot

import DIModules
import com.github.lamba92.telegrambots.extensions.buildPollingBot
import di.datas.BotData
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

class LookingForTroubleBotBuilder() : DIAware {

    override val di by DI.lazy {
        import(DIModules.botData)
    }

    private val botData: BotData by instance()

    val bot = buildPollingBot {

        // customize those 2 and do not publish the token!
        botApiToken = botData.botApiToken
        botUsername = botData.botUsername

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
                    receivedMessage.text
                }
            }
        }

    }

}
