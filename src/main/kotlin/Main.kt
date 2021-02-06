import bot.LookingForTroubleBotBuilder
import com.github.lamba92.telegrambots.extensions.KApiContextInitializer


fun main() {
    // this will start the bot!
    val botSession = KApiContextInitializer {
        registerBot(LookingForTroubleBotBuilder().bot)
    }
}
