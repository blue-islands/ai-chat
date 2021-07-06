import org.goldrenard.jb.configuration.BotConfiguration;
import org.goldrenard.jb.core.Bot;
import org.goldrenard.jb.core.Chat;

public class Test {

    public static void main(String[] args) {

//        LanguageConfiguration lang = new LanguageConfiguration(null, null, null, null, null, null, null);

        final var bot = new Bot(BotConfiguration.builder()
                .name("alice")
                .path("src/main/resources")
                .jpTokenize(true)
                .build());

        final var chatSession = new Chat(bot);
        final var answer = chatSession.multisentenceRespond("テスト");
        System.out.println(answer);
    }

}
