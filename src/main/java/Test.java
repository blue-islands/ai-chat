import org.goldrenard.jb.configuration.BotConfiguration;
import org.goldrenard.jb.configuration.LanguageConfiguration;
import org.goldrenard.jb.core.Bot;
import org.goldrenard.jb.core.Chat;

public class Test {

    public static void main(String[] args) {

        final var defaultResponse = "私にはその答えがありません。";
        final var errorResponse = "私の脳に何か問題があります。";
        final var scheduleError = "そのイベントをスケジュールできません。";
        final var systemFailed = "システムコマンドの実行に失敗しました。";
        final var templateFailed = "テンプレートが失敗しました。";
        final var tooMuchRecursion = "AIMLの再帰が多すぎます。";
        final var tooMuchLooping = "AIMLのループが多すぎます。";

        final var lang = LanguageConfiguration.builder();
        lang.defaultResponse(defaultResponse);
        lang.errorResponse(errorResponse);
        lang.scheduleError(scheduleError);
        lang.systemFailed(systemFailed);
        lang.templateFailed(templateFailed);
        lang.tooMuchRecursion(tooMuchRecursion);
        lang.tooMuchLooping(tooMuchLooping);

        final var bot = new Bot(BotConfiguration.builder()
                .name("alice")
                .path("src/main/resources")
                .jpTokenize(true)
                .language(lang.build())
                .build());

        final var chatSession = new Chat(bot);
        final var answer = chatSession.multisentenceRespond("テスト");
        System.out.println(answer);
    }

}
