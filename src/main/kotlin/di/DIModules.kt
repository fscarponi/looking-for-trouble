import di.datas.BotData
import org.kodein.di.*

object DIModules{

    val botData get() = DI.Module("botData"){

        bind<BotData>() with singleton {
            BotData(instance("BOTNAME"),instance("BOT_API_TOKEN"))
        }
        bind<String>("BOTNAME") with singleton { "LookingForTroubleBot" }
        bind<String>("BOT_API_TOKEN") with singleton { "LookingForTroubleBot" }

    }

}
